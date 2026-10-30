CMP_SC 3330 Group Assignment 2
Alex Kociubinski, Jaden Scott, Brayden Staley

GITHUB: https://github.com/alexkociubinski/CMP_SC-3330-Assignment-2

IDE Used: ItelliJ IDEA

TEAM CONTRIBUTIONS:

Brayden:
- AbstractSupportRequest.java
- DeviceSetupRequest.java
- NetworkIssueRequest.java

Jaden:
- Technician.java
- HelpDesk.java
- Main.java

Alex:
-SupportRequest.java
-PasswordResetRequest.java
-HelpDeskUtil.java

Basic Design Choices:
1. A request cannot be resolved more than once, doing so throws an IllegalStateException.
2. Each request can only be assigned to a single technician once. If you try to do so the program throws an IllegalStateException.
3. Uses the formula (basePoints + affectedUsers) to award service points when resolved.
