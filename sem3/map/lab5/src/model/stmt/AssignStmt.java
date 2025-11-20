package model.stmt;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;

import model.expression.Exp;
import model.value.Value;
import model.type.Type;
import model.adts.MyIDictionary;
public class AssignStmt implements IStmt {
    private final String id;
    private final Exp exp;

    public AssignStmt(String id, Exp exp){ this.id=id; this.exp=exp; }

    @Override
    public PrgState execute(PrgState state) throws StatementException, ADTException {
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        if(!symTbl.isDefined(id)) throw new StatementException("Variable "+id+" not declared");
        Value val = exp.eval(symTbl);
        Type typId = symTbl.lookup(id).getType();
        if(val.getType().equals(typId)){
            symTbl.update(id, val);
        } else throw new StatementException("Type mismatch for variable "+id);
        return state;
    }

    @Override
    public String toString(){
        return id+" = "+exp;
    }
}
