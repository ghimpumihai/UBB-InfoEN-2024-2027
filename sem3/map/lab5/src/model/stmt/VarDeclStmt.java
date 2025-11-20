package model.stmt;
import model.exception.StatementException;
import model.state.PrgState;
import model.type.Type;
import model.value.Value;
import model.adts.MyIDictionary;


public class VarDeclStmt implements IStmt {
    private final String name;
    private final Type typ;

    public VarDeclStmt(String name, Type typ){ this.name=name; this.typ=typ; }

    @Override
    public PrgState execute(PrgState state) throws StatementException {
        MyIDictionary<String, Value> sym = state.getSymTable();
        if(sym.isDefined(name)) throw new StatementException("Variable already declared: "+name);
        sym.put(name, typ.defaultValue());
        return state;
    }
    @Override
    public String toString(){ return typ+" "+name; }
}
