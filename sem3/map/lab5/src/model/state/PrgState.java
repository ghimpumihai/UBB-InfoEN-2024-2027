// java
package model.state;

import model.adts.*;
import model.stmt.IStmt;
import model.value.Value;

public class PrgState {
    private static int idCounter = 1;

    private final int id;
    private final MyIStack<IStmt> exeStack;
    private final MyIDictionary<String, Value> symTable;
    private final MyIList<Value> out;
    private final MyIFileTable fileTable;
    private final IStmt originalProgram;

    public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<String, Value> symTable, MyIList<Value> out, IStmt program) {
        this.id = idCounter++;
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.fileTable = new MyFileTable();
        this.originalProgram = program;
        this.exeStack.push(program); // initialize stack with the program
    }

    public MyIFileTable getFileTable() {
        return fileTable;
    }

    public int getId() {
        return id;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    public MyIStack<IStmt> getStk() {
        return exeStack;
    }

    public MyIHeap getHeap() {
        return (MyIHeap) symTable;
    }

    public PrgState oneStep() throws Exception {
        if (exeStack.isEmpty()) {
            throw new Exception("Program state stack is empty");
        }

        IStmt crtStmt = exeStack.pop();
        return crtStmt.execute(this);
    }

    @Override
    public String toString() {
        return "PrgState{" +
                "id=" + id +
                ", exeStack=" + exeStack +
                ", symTable=" + symTable +
                ", out=" + out +
                '}';
    }
}
