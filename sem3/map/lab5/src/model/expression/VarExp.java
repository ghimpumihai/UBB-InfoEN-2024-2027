package model.expression;
import model.exception.ADTException;
import model.exception.ExpressionException;
import model.value.Value;
import model.adts.MyIDictionary;

public class VarExp implements Exp {
    private final String id;
    public VarExp(String id){ this.id = id; }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws ExpressionException, ADTException {
        return tbl.lookup(id);
    }

    @Override
    public String toString(){
        return id;
    }
}
