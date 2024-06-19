import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BugTracker bugTracker = new BugTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bug Tracking System Menu:");
            System.out.println("1. Insert Bug");
            System.out.println("2. Update Bug");
            System.out.println("3. Delete Bug");
            System.out.println("4. View All Bugs");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    insertBug(scanner, bugTracker);
                    break;
                case 2:
                    updateBug(scanner, bugTracker);
                    break;
                case 3:
                    deleteBug(scanner, bugTracker);
                    break;
                case 4:
                    viewAllBugs(bugTracker);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void insertBug(Scanner scanner, BugTracker bugTracker) {
        System.out.println("Enter bug description:");
        String description = scanner.nextLine();
        System.out.println("Enter bug status:");
        String status = scanner.nextLine();
        System.out.println("Enter bug priority:");
        String priority = scanner.nextLine();

        Bug bug = new Bug(description, status, priority);
        bugTracker.reportBug(bug);
    }

    private static void updateBug(Scanner scanner, BugTracker bugTracker) {
        System.out.println("Enter the ID of the bug to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter new status:");
        String status = scanner.nextLine();
        System.out.println("Enter new priority:");
        String priority = scanner.nextLine();

        bugTracker.updateBug(id, status, priority);
    }

    private static void deleteBug(Scanner scanner, BugTracker bugTracker) {
        System.out.println("Enter the ID of the bug to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        bugTracker.deleteBug(id);
    }

    private static void viewAllBugs(BugTracker bugTracker) {
        System.out.println("All Bugs:");
        bugTracker.getAllBugs().forEach(System.out::println);
    }
}
