package repository;
import model.state.PrgState;

import java.util.List;

public interface IRepository {
    PrgState getCrtPrg();
    void addProgram(PrgState prg);
    public List<PrgState> getPrgList();
    public void setPrgList(List<PrgState> newList);
    void logPrgStateExec() throws Exception;
}
