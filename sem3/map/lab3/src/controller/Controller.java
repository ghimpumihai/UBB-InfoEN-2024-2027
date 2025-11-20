package controller;
import model.exception.ADTException;
import model.exception.StatementException;
import model.state.PrgState;
import repository.IRepository;
import model.stmt.IStmt;
public class Controller {
    private final IRepository repo;

    public Controller(IRepository r){
        this.repo = r;
    }

    public PrgState oneStep(PrgState state) throws StatementException, ADTException {
        var stk = state.getStk();
        if(stk.isEmpty()) throw new ADTException("Program stack is empty");
        IStmt crt = stk.pop();
        return crt.execute(state);
    }

    public void allStep() throws ADTException {
        PrgState prg = repo.getCrtPrg();
        while(!prg.getStk().isEmpty()){
            oneStep(prg);
        }
    }
}
