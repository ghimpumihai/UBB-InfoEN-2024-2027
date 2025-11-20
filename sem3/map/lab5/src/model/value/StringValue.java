package model.value;
import model.type.StringType;
import model.type.Type;

public class StringValue implements Value {
    private final String val;

    public StringValue(String v){
        this.val = v;
    }

    public String getVal(){
        return val;
    }

    @Override
    public Type getType(){
        return new StringType();
    }

    @Override
    public String toString(){
        return val;
    }

    @Override
    public boolean equals(Object another){
        if (another instanceof StringValue sv) {
            return this.val.equals(sv.val);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return val.hashCode();
    }
}

