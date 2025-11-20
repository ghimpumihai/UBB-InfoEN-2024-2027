package model.stmt;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;
import model.expression.Exp;
import model.value.Value;
public class PrintStmt implements IStmt {
    private final Exp exp;

    public PrintStmt(Exp e){ this.exp=e; }

    @Override
    public PrgState execute(PrgState state) throws StatementException, ADTException {
        Value v = exp.eval(state.getSymTable());
        state.getOut().add(v);
        return state;
    }

    @Override
    public String toString(){
        return "Print("+exp+")";
    }
}
