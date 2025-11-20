package model.stmt;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;
import model.expression.Exp;
import model.value.StringValue;
import model.value.Value;
import model.type.StringType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenRFile implements IStmt {
    private final Exp exp;

    public OpenRFile(Exp exp) {
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws StatementException, ADTException {
        Value val = exp.eval(state.getSymTable());
        
        // Check if the value is a StringType
        if (!(val.getType() instanceof StringType)) {
            throw new StatementException("Expression in openRFile must evaluate to string type");
        }
        
        StringValue stringVal = (StringValue) val;
        String filename = stringVal.getVal();
        
        // Check if the file is already in FileTable
        if (state.getFileTable().isDefined(stringVal)) {
            throw new StatementException("File already opened: " + filename);
        }
        
        // Open the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            state.getFileTable().put(stringVal, reader);
        } catch (IOException e) {
            throw new StatementException("Error opening file: " + filename + " - " + e.getMessage());
        }
        
        return state;
    }

    @Override
    public String toString() {
        return "openRFile(" + exp + ")";
    }
}

