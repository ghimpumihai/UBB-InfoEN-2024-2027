package model.stmt;
import model.exception.StatementException;
import model.state.PrgState;

public class CompStmt implements IStmt {
    private final IStmt first, snd;

    public CompStmt(IStmt f, IStmt s){ this.first=f; this.snd=s; }

    @Override
    public PrgState execute(PrgState state) throws StatementException {
        state.getStk().push(snd);
        state.getStk().push(first);
        return state;
    }
    @Override
    public String toString(){
        return "("+first+";"+snd+")";
    }
}
