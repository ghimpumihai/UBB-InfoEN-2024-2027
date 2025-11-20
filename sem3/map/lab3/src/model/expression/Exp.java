package model.expression;
import model.exception.ADTException;
import model.exception.ExpressionException;
import model.value.Value;
import model.adts.MyIDictionary;

public interface Exp {
    Value eval(MyIDictionary<String, Value> tbl) throws ExpressionException, ADTException;
}
