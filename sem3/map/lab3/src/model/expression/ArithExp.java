package model.expression;
import model.exception.ADTException;
import model.exception.ExpressionException;
import model.value.Value;
import model.value.IntValue;
import model.type.IntType;
import model.adts.MyIDictionary;
public class ArithExp implements Exp {
    private final Exp e1, e2;
    private final char op;
    public ArithExp(char op, Exp e1, Exp e2){
        this.op=op;
        this.e1=e1;
        this.e2=e2;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws ExpressionException, ADTException {
        Value v1 = e1.eval(tbl);
        if(!(v1.getType() instanceof IntType)) throw new ExpressionException("First operand is not integer");
        Value v2 = e2.eval(tbl);
        if(!(v2.getType() instanceof IntType)) throw new ExpressionException("Second operand is not integer");
        int n1 = ((IntValue)v1).getVal();
        int n2 = ((IntValue)v2).getVal();
        return switch(op){
            case '+' -> new IntValue(n1 + n2);
            case '-' -> new IntValue(n1 - n2);
            case '*' -> new IntValue(n1 * n2);
            case '/' -> {
                if(n2==0)
                    throw new ExpressionException("Division by zero");
                yield new IntValue(n1 / n2);
            }
            default -> throw new ExpressionException("Unknown arithmetic operator: "+op);
        };
    }

    @Override
    public String toString(){
        return "("+e1+" "+op+" "+e2+")";
    }
}
