package model.value;
import model.type.IntType;
import model.type.Type;
public class IntValue implements Value {
    private final int val;
    public IntValue(int v){
        this.val=v;
    }
    public int getVal(){
        return val;
    }
    @Override
    public Type getType(){
        return new IntType();
    }
    @Override
    public String toString(){
        return Integer.toString(val);
    }

    @Override
    public boolean equals(Object another){
        if (another instanceof IntValue iv) {
            return this.val == iv.val;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(val);
    }
}
