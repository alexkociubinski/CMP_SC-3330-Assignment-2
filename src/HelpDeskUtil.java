import java.util.List;

public class HelpDeskUtil {
    //print all items in the list, use generic T for type safety
    public static <T> void printAll(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    // returns total points earned by all technicians in the list
    public static int sumPoints(List<? extends Technician> technicians) {
        int total = 0;
        for (Technician technician : technicians) { // add each technician's points
            total += technician.getServicePoints();
        }
        return total; // return total points
    }
}