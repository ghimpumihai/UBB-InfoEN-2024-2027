// java
package controller;

import model.state.PrgState;
import repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    /**
     * Executes all programs step-by-step and prints the execution stack,
     * symbol table and output for each program after every step.
     */
    public void allStepWithLogging() throws Exception {
        List<PrgState> prgList = removeCompletedPrograms(repo.getPrgList());

        while (!prgList.isEmpty()) {
            // Print current state of each program
            for (PrgState prg : prgList) {
                printPrgState(prg);
            }

            // Execute one step for each program (sequentially)
            List<PrgState> afterStep = new ArrayList<>();
            for (PrgState prg : prgList) {
                try {
                    prg.oneStep();
                } catch (Exception e) {
                    System.err.println("Error during oneStep: " + e.getMessage());
                }
                afterStep.add(prg);
            }

            // Update repository and filter out completed programs
            repo.setPrgList(afterStep);
            prgList = removeCompletedPrograms(repo.getPrgList());
        }

        // Print final states (if any)
        for (PrgState prg : repo.getPrgList()) {
            printPrgState(prg);
        }
    }

    /**
     * Executes the program step-by-step and logs state after each step.
     */
    public void allStep() throws Exception {
        PrgState prg = repo.getCrtPrg();
        if (prg == null) {
            throw new Exception("No program in repository");
        }
        
        repo.logPrgStateExec();
        while (!prg.getStk().isEmpty()) {
            oneStep(prg);
            repo.logPrgStateExec();
            prg.getHeap().setContent(GarbageCollector(
                    getAddrFromSymTable(prg.getSymTable().getContent().values()),
                    prg.getHeap().getContent()));
        }
    }

    /**
     * Executes one step of the program.
     */
    public void oneStep(PrgState prg) throws Exception {
        if (prg.getStk().isEmpty()) {
            throw new Exception("Program state stack is empty");
        }
        prg.oneStep();
    }

    private List<PrgState> removeCompletedPrograms(List<PrgState> in) {
        return in.stream()
                .filter(p -> !p.getStk().isEmpty())
                .collect(Collectors.toList());
    }

    private void printPrgState(PrgState prg) {
        System.out.println("=== Program State (id=" + prg.getId() + ") ===");
        System.out.println("Execution stack: " + prg.getStk());
        System.out.println("Symbol table: " + prg.getSymTable());
        System.out.println("Output: " + prg.getOut());
        System.out.println("---------------------------------");
    }
}
