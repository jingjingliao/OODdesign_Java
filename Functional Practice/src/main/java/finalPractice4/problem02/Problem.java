package finalPractice4.problem02;

import java.util.List;

public class Problem {
  private List<Subproblem> subproblems;

  public Problem(List<Subproblem> subproblems){
    this.subproblems = subproblems;
  }

  public List<Subproblem> getSubproblems() {
    return subproblems;
  }

  public int getMaxPoints(){
    return this.subproblems.stream().map(Subproblem::getMaximumValue).reduce(0, Integer::sum);
  }

  public int getTotalAchievedPoints(){
    return this.subproblems.stream().map(Subproblem::getAchievedValue).reduce(0, Integer::sum);
  }

}
