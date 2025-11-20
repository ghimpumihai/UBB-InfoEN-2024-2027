package repository;
import model.state.PrgState;
import java.util.ArrayList;
import java.util.List;
public class Repository implements IRepository {
    private final List<PrgState> programs = new ArrayList<>();

    public Repository(){}

    @Override
    public PrgState getCrtPrg(){
        if(programs.isEmpty())
            throw new RuntimeException("No program");
        return programs.getFirst();
    }

    @Override
    public void addProgram(PrgState prg){
        programs.add(prg);
    }
}
