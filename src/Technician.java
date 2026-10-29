public class Technician {
    private final String name;
    private int servicePoints;

    public Technician(String name) {        // creats a technician with 0 points, cant have null name
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Need technician name");
        }
        this.name = name;
        servicePoints = 0;
    }

    public String getName() {
        return name;
    }

    public void addPoints(int amount) {     // adds points, must be positive
        if (amount <= 0) {
            throw new IllegalArgumentException("Points to add must be positive.");
        }
        if (amount > Integer.MAX_VALUE - servicePoints) {
            throw new IllegalArgumentException("Service point total is too large.");
        }
        servicePoints += amount;
    }

    public int getServicePoints() {
        return servicePoints;
    }

    @Override       // two technicians are equal and if their name is the same
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Technician)) {
            return false;
        }
        Technician technician = (Technician) other;
        return name.equals(technician.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name + ": " + servicePoints + " service points";
    }
}
