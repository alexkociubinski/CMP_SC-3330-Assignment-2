import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main { // test the help desk system
  public static void main(String[] args) {
    HelpDesk helpDesk = new HelpDesk();

    Technician alex = new Technician("Alex");   // create technicians
    Technician jordan = new Technician("Jordan");
    Technician anotherAlex = new Technician("Alex");

    Set<Technician> technicianSet = new HashSet<>();    // see if the hash treats same name technicians as duplicates
    technicianSet.add(alex);
    technicianSet.add(jordan);
    boolean duplicateAdded = technicianSet.add(anotherAlex);
    System.out.println("Added another technician named Alex: " + duplicateAdded);
    System.out.println("Unique technicians in HashSet: " + technicianSet.size());

    List<Technician> technicians = new ArrayList<>();   //  // Use each unique technician once when reporting and summing points
    technicians.add(alex);
    technicians.add(jordan);

    helpDesk.addRequest(new PasswordResetRequest(1, "Student password reset", 5, "student1"));
    helpDesk.addRequest(new PasswordResetRequest(2, "Faculty account reset", 5, "faculty1"));
    helpDesk.addRequest(new DeviceSetupRequest(3, "Set up lab computers", 10, 3));
    helpDesk.addRequest(new DeviceSetupRequest(4, "Configure office printers", 8, 2));
    helpDesk.addRequest(new NetworkIssueRequest(5, "Library Wi-Fi issue", 10, 20));
    helpDesk.addRequest(new NetworkIssueRequest(6, "Classroom network issue", 6, 8));

    helpDesk.assignRequest(alex, 1);
    helpDesk.assignRequest(jordan, 3);
    helpDesk.assignRequest(alex, 5);
    helpDesk.assignRequest(jordan, 4);

    System.out.println("\nResolving requests:");
    System.out.println("Request 1 awarded " + helpDesk.resolveRequest(alex, 1) + " points.");
    System.out.println("Request 3 awarded " + helpDesk.resolveRequest(jordan, 3) + " points.");
    System.out.println("Request 5 awarded " + helpDesk.resolveRequest(alex, 5) + " points.");

    System.out.println("\nInvalid action: resolve request 1 again");
    try {
      helpDesk.resolveRequest(alex, 1);
    } catch (IllegalStateException exception) {
      System.out.println("Caught " + exception);
    }

    System.out.println("\nAll requests:");      // print every request
    helpDesk.printAllRequests();

    System.out.println("\nTechnician assignments:");
    for (Technician technician : technicians) {
      helpDesk.printAssignmentsFor(technician);
    }

    System.out.println("\nFinal technician totals:");   // print final points for each technician
    HelpDeskUtil.printAll(technicians);
    System.out.println("Total service points: " + HelpDeskUtil.sumPoints(technicians));
  }
}
