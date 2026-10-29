// Make an interface for a support request
public interface SupportRequest {
    int getID();
    String getTitle();
    int getBasePoints();
    boolean isResolved();
    int resolveFor(Technician technician);
}