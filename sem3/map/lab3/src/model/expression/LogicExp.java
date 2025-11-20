package model.expression;
import model.exception.ADTException;
import model.exception.ExpressionException;
import model.value.Value;
import model.value.BoolValue;
import model.type.BoolType;
import model.adts.MyIDictionary;
public class LogicExp implements Exp {
    private final Exp e1, e2;
    private final String op;

    public LogicExp(String op, Exp e1, Exp e2){
        this.op=op;
        this.e1=e1;
        this.e2=e2;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws ExpressionException, ADTException {
        Value v1 = e1.eval(tbl);
        if(!(v1.getType() instanceof BoolType)) throw new ExpressionException("First operand is not boolean");
        Value v2 = e2.eval(tbl);
        if(!(v2.getType() instanceof BoolType)) throw new ExpressionException("Second operand is not boolean");
        boolean b1 = ((BoolValue)v1).getVal();
        boolean b2 = ((BoolValue)v2).getVal();
        return switch(op){
            case "and" -> new BoolValue(b1 && b2);
            case "or" -> new BoolValue(b1 || b2);
            default -> throw new ExpressionException("Unknown logical operator: "+op);
        };
    }

    @Override
    public String toString(){
        return "("+e1+" "+op+" "+e2+")";
    }
}
