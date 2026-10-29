import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HelpDesk {     // manages support requests, and which technician theyre assigned to
    private final Map<Integer, SupportRequest> requestsById = new LinkedHashMap<>();
    private final Map<Technician, List<SupportRequest>> assignments = new LinkedHashMap<>();

    public void addRequest(SupportRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        if (requestsById.containsKey(request.getId())) {
            throw new IllegalArgumentException("Request ID " + request.getId() + "already exists");
        }
        requestsById.put(request.getId(), request);
    }

    public SupportRequest findRequest(int id) {
        return requestsById.get(id);
    }

    public void assignRequest(Technician technician, int requestId) {       // adds a new request to the help desk exeption iff null or already has a id
        if (technician == null) {
            throw new IllegalArgumentException("Technician cannot be null");
        }
        SupportRequest request = findRequest(requestId);
        if (request == null) {
            throw new IllegalArgumentException("Request " + requestId + "does not exist");
        }
        if (request.isResolved()) {
            throw new IllegalStateException("Cannot assign a resolved request.");
        }
        // Each request has one technician. Duplicate and multiple assignments are rejected.
        for (List<SupportRequest> assignedRequests : assignments.values()) {
            if (assignedRequests.contains(request)) {
                throw new IllegalStateException("Request " + requestId + "is already assigned");
            }
        }
        List<SupportRequest> technicianRequests = assignments.get(technician);      // creat new list for technicion
        if (technicianRequests == null) {
            technicianRequests = new ArrayList<>();
            assignments.put(technician, technicianRequests);
        }
        technicianRequests.add(request);
    }

    public int resolveRequest(Technician technician, int requestId) {   // Has a technician resolve one of their assigned requests
        if (technician == null) {
            throw new IllegalArgumentException("Technician cannot be null");
        }
        SupportRequest request = findRequest(requestId);
        if (request == null) {
            throw new IllegalArgumentException("Request " + requestId + "does not exist");
        }
        List<SupportRequest> technicianRequests = assignments.get(technician);
        if (technicianRequests == null || !technicianRequests.contains(request)) {
            throw new IllegalStateException("Request " + requestId + "is not assigned to"
                    + technician.getName() + ".");
        }
        return request.resolveFor(technician);
    }

    public void printAllRequests() {
        for (SupportRequest request : requestsById.values()) {
            System.out.println(request);
        }
    }

    public void printAssignmentsFor(Technician technician) {    // prints all name requests assigned to the gibin technician
        if (technician == null) {
            throw new IllegalArgumentException("Technician cannot be null");
        }
        System.out.println("assignments for" + technician.getName() + ":");
        List<SupportRequest> technicianRequests = assignments.get(technician);
        if (technicianRequests == null || technicianRequests.isEmpty()) {
            System.out.println("No assignments");
        } else {
            HelpDeskUtil.printAll(technicianRequests);
        }
    }
}
