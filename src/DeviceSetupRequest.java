public class DeviceSetupRequest extends AbstractSupportRequest {
  private final int deviceCount;

  public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount) {
    super(id, title, basePoints);
    // BOUNDS
    if (deviceCount <= 0) {
      throw new IllegalArgumentException("Device count must be positive.");
    }
    if (deviceCount > Integer.MAX_VALUE / basePoints) {
      throw new IllegalArgumentException("Device setup points are too large.");
    }
    this.deviceCount = deviceCount;
  }

  @Override
  public int resolveFor(Technician technician) {
    int points = getBasePoints() * deviceCount;
    return completeResolution(technician, points);
  }

  @Override
  public String toString() {
    // Different toString
    return super.toString() + ", device setup, devices=" + deviceCount;
  }
}