package model.stmt;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;
import model.expression.Exp;
import model.value.BoolValue;
import model.value.Value;

public class WhileStmt implements IStmt {
    private final Exp exp;
    private final IStmt stmt;

    public WhileStmt(Exp e, IStmt s) {
        this.exp = e;
        this.stmt = s;
    }

    @Override
    public PrgState execute(PrgState state) throws StatementException, ADTException {
        Value cond = exp.eval(state.getSymTable());
        if (!(cond instanceof BoolValue b)) {
            throw new StatementException("Condition is not boolean");
        }
        if (b.getVal()) {
            state.getStk().push(this);
            state.getStk().push(stmt);
        }
        return state;
    }

    @Override
    public String toString() {
        return "WHILE(" + exp + ") DO(" + stmt + ")";
    }
}

