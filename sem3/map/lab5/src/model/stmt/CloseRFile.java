package model.stmt;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;
import model.expression.Exp;
import model.value.StringValue;
import model.value.Value;
import model.type.StringType;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseRFile implements IStmt {
    private final Exp exp;

    public CloseRFile(Exp exp) {
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws StatementException, ADTException {
        // Evaluate exp to a string value
        Value val = exp.eval(state.getSymTable());
        if (!(val.getType() instanceof StringType)) {
            throw new StatementException("Expression in closeRFile must evaluate to string type");
        }
        
        StringValue stringVal = (StringValue) val;
        
        // Get the BufferedReader from FileTable
        if (!state.getFileTable().isDefined(stringVal)) {
            throw new StatementException("File not opened: " + stringVal.getVal());
        }
        
        BufferedReader reader = state.getFileTable().lookup(stringVal);
        
        // Close the BufferedReader
        try {
            reader.close();
        } catch (IOException e) {
            throw new StatementException("Error closing file: " + e.getMessage());
        }
        
        // Delete the entry from FileTable
        state.getFileTable().remove(stringVal);
        
        return state;
    }

    @Override
    public String toString() {
        return "closeRFile(" + exp + ")";
    }
}

