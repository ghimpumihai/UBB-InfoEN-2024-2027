package model.stmt;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;
import model.expression.Exp;
import model.value.BoolValue;
import model.value.Value;
public class IfStmt implements IStmt {
    private final Exp exp;
    private final IStmt thenS;
    private final IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el){
        this.exp=e;
        this.thenS=t;
        this.elseS=el;
    }

    @Override
    public PrgState execute(PrgState state) throws StatementException, ADTException {
        Value cond = exp.eval(state.getSymTable());
        if(!(cond instanceof BoolValue b)) throw new StatementException("Condition is not boolean");
        if(b.getVal()) state.getStk().push(thenS);
        else state.getStk().push(elseS);
        return state;
    }
    @Override
    public String toString(){
        return "IF("+exp+") THEN("+thenS+") ELSE("+elseS+")";
    }
}
