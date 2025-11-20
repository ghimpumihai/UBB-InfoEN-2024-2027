package model.stmt;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws StatementException, ADTException;
}
