package model.expression;
import model.exception.ExpressionException;
import model.value.Value;
import model.adts.MyIDictionary;
public class ValueExp implements Exp {
    private final Value val;
    public ValueExp(Value v){ this.val = v; }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws ExpressionException {
        return val;
    }

    @Override
    public String toString(){
        return val.toString();
    }
}
