package app;
import model.adts.*;
import model.state.PrgState;
import repository.*;
import controller.*;
import model.stmt.*;
import model.expression.*;
import model.value.*;
import model.type.*;
public class Main {
    public static void main(){
        try{
            // Example1: int v; v=2; Print(v)
            IStmt ex1 = new CompStmt(
                new VarDeclStmt("v", new IntType()),
                new CompStmt(
                    new AssignStmt("v", new ValueExp(new IntValue(2))),
                    new PrintStmt(new VarExp("v"))
                )
            );
            runExample(ex1, "Example1");

            // Example2: int a; int b; a=2+3*5; b=a+1; Print(b)
            IStmt ex2 = new CompStmt(
                new VarDeclStmt("a", new IntType()),
                new CompStmt(
                    new VarDeclStmt("b", new IntType()),
                    new CompStmt(
                        new AssignStmt("a", new ArithExp('+', new ValueExp(new IntValue(2)),
                            new ArithExp('*', new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                        new CompStmt(
                            new AssignStmt("b", new ArithExp('+', new VarExp("a"), new ValueExp(new IntValue(1)))),
                            new PrintStmt(new VarExp("b"))
                        )
                    )
                )
            );
            runExample(ex2, "Example2");

            // Example3: bool a; int v; a=true; If a Then v=2 Else v=3; Print(v)
            IStmt ex3 = new CompStmt(
                new VarDeclStmt("a", new BoolType()),
                new CompStmt(
                    new VarDeclStmt("v", new IntType()),
                    new CompStmt(
                        new AssignStmt("a", new ValueExp(new BoolValue(true))),
                        new CompStmt(
                            new IfStmt(new VarExp("a"), new AssignStmt("v", new ValueExp(new IntValue(2))),
                                    new AssignStmt("v", new ValueExp(new IntValue(3)))),
                            new PrintStmt(new VarExp("v"))
                        )
                    )
                )
            );
            runExample(ex3, "Example3");
        } catch(Exception e){
            System.err.println("Runtime error: " + e.getMessage());
        }
    }

    private static void runExample(IStmt program, String name) throws Exception {
        System.out.println("--- Running: " + name + " ---");
        MyIStack<IStmt> stk = new MyStack<>();
        MyIDictionary<String, Value> sym = new MyDictionary<>();
        MyIList<Value> out = new MyList<>();
        PrgState prg = new PrgState(stk, sym, out, program);
        IRepository repo = new Repository();
        repo.addProgram(prg);
        Controller ctrl = new Controller(repo);
        ctrl.allStep();
        System.out.println("Output: " + prg.getOut().getList());
        System.out.println(prg);
    }
}
