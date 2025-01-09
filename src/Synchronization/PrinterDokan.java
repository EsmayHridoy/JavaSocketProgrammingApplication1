package Synchronization;

public class PrinterDokan {
    public static void main(String[] args) {
        PrinterMachine sharedPrinter = new PrinterMachine();

        Person esmay = new Person("Esmay", "Computer Architecture", 6, sharedPrinter);
        Person bushra = new Person("Bushra", "Data Structure and Algorithm", 12, sharedPrinter);
        Person abid = new Person("Abid", "VLSI", 15, sharedPrinter);
    }
}
