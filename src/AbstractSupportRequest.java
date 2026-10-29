public abstract class AbstractSupportRequest implements SupportRequest {
  private final int id;
  private final String title;
  private final int basePoints;
  private boolean resolved;

  public AbstractSupportRequest(int id, String title, int basePoints) {
    // Bound checking
    if (id <= 0) {
      throw new IllegalArgumentException("ID must be positive.");
    }
    if (title == null || title.isBlank()) {
      throw new IllegalArgumentException("title cannot be blank.");
    }
    if (basePoints <= 0) {
      throw new IllegalArgumentException("Base points must be positive.");
    }
    this.id = id;
    this.title = title;
    this.basePoints = basePoints;
    resolved = false;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public int getBasePoints() {
    return basePoints;
  }

  @Override
  public boolean isResolved() {
    return resolved;
  }


  protected int completeResolution(Technician technician, int points) {
    // bound checking
    if (technician == null) {
      throw new IllegalArgumentException("Technician cannot be null.");
    }
    if (resolved) {
      throw new IllegalStateException("Request " + id + " is already resolved.");
    }
    technician.addPoints(points);
    resolved = true;
    return points;
  }

  @Override
  public String toString() {
    // have to override toString because we are passing in different things
    return "Request " + id + ": " + title + ", base points=" + basePoints
      + ", resolved=" + resolved;
  }
}
