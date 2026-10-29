public class NetworkIssueRequest extends AbstractSupportRequest {
  private final int affectedUsers;

  public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
    super(id, title, basePoints);
    // bounds
    if (affectedUsers <= 0) {
      throw new IllegalArgumentException("Affected users must be positive.");
    }
    if (affectedUsers > Integer.MAX_VALUE - basePoints) {
      throw new IllegalArgumentException("Network issue points are too big.");
    }
    this.affectedUsers = affectedUsers;
  }

  @Override
  public int resolveFor(Technician technician) {
    // add one point for each.
    int points = getBasePoints() + affectedUsers;
    return completeResolution(technician, points);
  }

  @Override
  public String toString() {
    return super.toString() + ", network issue, affected users = " + affectedUsers;
  }
}