// java
package view;

import controller.Controller;
import model.adts.*;
import model.expression.*;
import model.state.PrgState;
import model.stmt.*;
import model.type.*;
import model.value.*;
import repository.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final Map<Integer, IStmt> programs = new HashMap<>();
    private IStmt currentProgram = null;

    public View() {
        initializePrograms();
    }

    private void initializePrograms() {
        // Example 1: int v; v=2; Print(v)
        IStmt ex1 = new CompStmt(
                new VarDeclStmt("v", new IntType()),
                new CompStmt(
                        new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))
                )
        );
        programs.put(1, ex1);

        // Example 2: int a; int b; a=2+3*5; b=a+1; Print(b)
        IStmt ex2 = new CompStmt(
                new VarDeclStmt("a", new IntType()),
                new CompStmt(
                        new VarDeclStmt("b", new IntType()),
                        new CompStmt(
                                new AssignStmt("a", new ArithExp('+',
                                        new ValueExp(new IntValue(2)),
                                        new ArithExp('*',
                                                new ValueExp(new IntValue(3)),
                                                new ValueExp(new IntValue(5))))),
                                new CompStmt(
                                        new AssignStmt("b", new ArithExp('+',
                                                new VarExp("a"),
                                                new ValueExp(new IntValue(1)))),
                                        new PrintStmt(new VarExp("b"))
                                )
                        )
                )
        );
        programs.put(2, ex2);

        // Example 3: bool a; int v; a=true; If a Then v=2 Else v=3; Print(v)
        IStmt ex3 = new CompStmt(
                new VarDeclStmt("a", new BoolType()),
                new CompStmt(
                        new VarDeclStmt("v", new IntType()),
                        new CompStmt(
                                new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(
                                        new IfStmt(new VarExp("a"),
                                                new AssignStmt("v", new ValueExp(new IntValue(2))),
                                                new AssignStmt("v", new ValueExp(new IntValue(3)))),
                                        new PrintStmt(new VarExp("v"))
                                )
                        )
                )
        );
        programs.put(3, ex3);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Enter option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> selectProgram(scanner);
                case 2 -> executeProgram();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("\n===== Toy Language Menu =====");
        System.out.println("1. Input a program");
        System.out.println("2. Run the selected program (step-by-step logging)");
        System.out.println("0. Exit");
        System.out.println("=============================");
    }

    private void selectProgram(Scanner scanner) {
        System.out.println("Select one of the following programs:");
        for (int key : programs.keySet()) {
            System.out.println(key + ". " + programs.get(key));
        }
        System.out.print("Enter program number: ");
        int choice = scanner.nextInt();

        if (programs.containsKey(choice)) {
            currentProgram = programs.get(choice);
            System.out.println("Program " + choice + " selected.");
        } else {
            System.out.println("Invalid selection.");
        }
    }

    private void executeProgram() {
        if (currentProgram == null) {
            System.out.println("No program selected. Please input a program first.");
            return;
        }

        try {
            MyIStack<IStmt> stk = new MyStack<>();
            MyIDictionary<String, Value> sym = new MyDictionary<>();
            MyIList<Value> out = new MyList<>();
            PrgState prg = new PrgState(stk, sym, out, currentProgram);

            IRepository repo = new Repository();
            repo.addProgram(prg);

            Controller ctrl = new Controller(repo);
            // new step-by-step logging run
            ctrl.allStepWithLogging();

            System.out.println("Execution finished.");
            System.out.println("Final Output: " + prg.getOut().getList());
        } catch (Exception e) {
            System.err.println("Runtime error: " + e.getMessage());
        }
    }
}
