package Synchronization;

public class PrinterMachine {
    String assignmentName;
    int pages;

    synchronized void printing(String assignmentName, int pages) {
        System.out.println(assignmentName + " --> Printing started");

        for (int page = 1; page <= pages; page++) {
            System.out.println(assignmentName + " --> Page#" + page);
        }

        System.out.println(assignmentName + " --> Completed");
    }
}
