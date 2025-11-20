package model.stmt;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;
import model.expression.Exp;
import model.value.StringValue;
import model.value.IntValue;
import model.value.Value;
import model.type.StringType;
import model.type.IntType;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements IStmt {
    private final Exp exp;
    private final String varName;

    public ReadFile(Exp exp, String varName) {
        this.exp = exp;
        this.varName = varName;
    }

    @Override
    public PrgState execute(PrgState state) throws StatementException, ADTException {
        // Check if var_name is defined in SymTable and its type is int
        if (!state.getSymTable().isDefined(varName)) {
            throw new StatementException("Variable not declared: " + varName);
        }
        
        Value varValue = state.getSymTable().lookup(varName);
        if (!(varValue.getType() instanceof IntType)) {
            throw new StatementException("Variable " + varName + " must be of type int");
        }
        
        // Evaluate exp to a string value
        Value val = exp.eval(state.getSymTable());
        if (!(val.getType() instanceof StringType)) {
            throw new StatementException("Expression in readFile must evaluate to string type");
        }
        
        StringValue stringVal = (StringValue) val;
        
        // Get the BufferedReader from FileTable
        if (!state.getFileTable().isDefined(stringVal)) {
            throw new StatementException("File not opened: " + stringVal.getVal());
        }
        
        BufferedReader reader = state.getFileTable().lookup(stringVal);
        
        // Read a line from the file
        try {
            String line = reader.readLine();
            int intValue;
            if (line == null) {
                intValue = 0;
            } else {
                try {
                    intValue = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    throw new StatementException("Invalid integer format in file: " + line);
                }
            }
            
            // Update SymTable
            state.getSymTable().update(varName, new IntValue(intValue));
        } catch (IOException e) {
            throw new StatementException("Error reading from file: " + e.getMessage());
        }
        
        return state;
    }

    @Override
    public String toString() {
        return "readFile(" + exp + ", " + varName + ")";
    }
}

