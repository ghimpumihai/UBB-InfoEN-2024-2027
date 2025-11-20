package model.value;
import model.type.BoolType;
import model.type.Type;
public class BoolValue implements Value {
    private final boolean val;

    public BoolValue(boolean v){
        this.val=v;
    }

    public boolean getVal(){
        return val;
    }

    @Override
    public Type getType(){
        return new BoolType();
    }

    @Override
    public String toString(){
        return Boolean.toString(val);
    }

    @Override
    public boolean equals(Object another){
        if (another instanceof BoolValue bv) {
            return this.val == bv.val;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(val);
    }
}
