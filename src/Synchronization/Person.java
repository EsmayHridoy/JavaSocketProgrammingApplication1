package Synchronization;

public class Person implements Runnable {

    String personName;
    String assignmentName;
    int pages;
    Thread thread;
    PrinterMachine printerMachine;

    Person(String personName, String assignmentName, int pages, PrinterMachine printerMachine) {
        this.personName = personName;
        this.assignmentName = assignmentName;
        this.pages = pages;
        this.printerMachine = printerMachine;

        thread = new Thread(this, assignmentName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Customer: " + personName);
        printerMachine.printing(assignmentName, pages);
    }
}
