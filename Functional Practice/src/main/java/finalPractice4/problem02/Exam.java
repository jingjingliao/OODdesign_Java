package finalPractice4.problem02;

import java.util.List;

public class Exam implements IExam{

  private List<Problem> problems;

  private Exam(List<Problem> problems){
    this.problems = problems;
  }

  public List<Problem> getProblems() {
    return problems;
  }

  public int getTotalPoints(){
    return this.problems.stream().map(Problem::getMaxPoints).reduce(0, Integer::sum);
  }

  @Override
  public IExam creatExam(List<Problem> problemList) {
    return new Exam(problemList);
  }

}
