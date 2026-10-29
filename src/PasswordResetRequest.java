public class PasswordResetRequest extends AbstractSupportRequest {
    private final String accountName;


    // Creates a password reset request with given parameters
    public PasswordResetRequest(int id, String title, int basePoints, String accountName) {
        super(id, title, basePoints); // Initializes the inherited fields from the parent class
        if (accountName == null || accountName.isBlank()) { // check for NULL or blank
            throw new IllegalArgumentException("You can't have a blank account name");
        }
        this.accountName = accountName; // save account name
    }

    // returns the points earned by the technician
    @Override
    public int resolveFor(Technician technician) {
        return completeResolution(technician, getBasePoints());
    }

    // returns a string that describes the password reset request
    @Override
    public String toString() {
        return super.toString() + ", reset the password for " + accountName;
    }
}