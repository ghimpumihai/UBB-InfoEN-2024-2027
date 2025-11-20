package model.state;
import model.adts.MyIStack;
import model.adts.MyIDictionary;
import model.adts.MyIList;
import model.stmt.IStmt;
import model.value.Value;
public class PrgState {
    private final MyIStack<IStmt> exeStack;
    private final MyIDictionary<String, Value> symTable;
    private final MyIList<Value> out;
    private final IStmt originalProgram;

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symtbl, MyIList<Value> out, IStmt prg){
        this.exeStack = stk;
        this.symTable = symtbl;
        this.out = out;
        this.originalProgram = prg;
        this.exeStack.push(prg);
    }
    public MyIStack<IStmt> getStk(){
        return exeStack;
    }

    public MyIDictionary<String, Value> getSymTable(){
        return symTable;
    }

    public MyIList<Value> getOut(){
        return out;
    }
    public IStmt getProgram(){
        return originalProgram;
    }

    @Override
    public String toString(){
        return "PrgState{exeStack="+exeStack.toString()+", symTable="+symTable.toString()+", out="+out.toString()+"}";
    }
}
