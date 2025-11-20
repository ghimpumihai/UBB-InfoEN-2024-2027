// java
package repository;

import model.adts.MyIList;
import model.adts.MyList;
import model.adts.MyIStack;
import model.adts.MyIDictionary;
import model.state.PrgState;
import model.stmt.IStmt;
import model.value.Value;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository implements IRepository {
    private List<PrgState> prgList;
    private String logFilePath;

    public Repository() {
        this.prgList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter log file path: ");
        this.logFilePath = scanner.nextLine();
    }

    public Repository(PrgState prg, String logFilePath) {
        this.prgList = new ArrayList<>();
        this.prgList.add(prg);
        this.logFilePath = logFilePath;
    }

    @Override
    public List<PrgState> getPrgList() {
        return prgList;
    }

    @Override
    public void setPrgList(List<PrgState> newList) {
        this.prgList = newList;
    }

    @Override
    public PrgState getCrtPrg() {
        if (prgList.isEmpty()) {
            return null;
        }
        return prgList.get(0);
    }

    @Override
    public void addProgram(PrgState prg) {
        prgList.add(prg);
    }

    @Override
    public void logPrgStateExec() throws Exception {
        PrgState prg = getCrtPrg();
        if (prg == null) {
            return;
        }

        try (PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)))) {
            logFile.println("ExeStack:");
            
            // Print stack from top to bottom
            MyIStack<IStmt> stack = prg.getStk();
            List<IStmt> stackList = stack.toList();
            // Reverse to print from top to bottom
            for (int i = stackList.size() - 1; i >= 0; i--) {
                logFile.println(stackList.get(i).toString());
            }
            
            logFile.println("SymTable:");
            MyIDictionary<String, Value> symTable = prg.getSymTable();
            var content = symTable.getContent();
            for (var entry : content.entrySet()) {
                logFile.println(entry.getKey() + " --> " + entry.getValue().toString());
            }
            
            logFile.println("Out:");
            List<Value> outList = prg.getOut().getList();
            for (Value val : outList) {
                logFile.println(val.toString());
            }
            
            logFile.println("FileTable:");
            // FileTable will be added later
            if (prg.getFileTable() != null) {
                var fileTableContent = prg.getFileTable().getContent();
                for (var entry : fileTableContent.entrySet()) {
                    logFile.println(entry.getKey().toString());
                }
            }
            
            logFile.println(); // Empty line between states
        } catch (IOException e) {
            throw new Exception("Error writing to log file: " + e.getMessage());
        }
    }
}
