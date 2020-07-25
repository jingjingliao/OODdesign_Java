package finalPractice05.problem04;

public class DestinationNode {
  private Destination destinationData;
  private DestinationNode nextDestination;

  public DestinationNode(Destination destinationData,
      DestinationNode nextDestination) {
    this.destinationData = destinationData;
    this.nextDestination = nextDestination;
  }

  public Destination getDestinationData() {
    return destinationData;
  }

  public DestinationNode getNextDestination() {
    return nextDestination;
  }

  public boolean isEmpty() {
    return !(this.destinationData.equals(null) && this.nextDestination.isEmpty());
  }


}
