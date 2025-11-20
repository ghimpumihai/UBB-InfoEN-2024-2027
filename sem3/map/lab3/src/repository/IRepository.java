package repository;
import model.state.PrgState;
public interface IRepository {
    PrgState getCrtPrg();
    void addProgram(PrgState prg);
}
