package BasicSocketProgrammingWIthoutThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket clientSocket = new Socket("127.0.0.1", 22222);
        Scanner userInputScanner = new Scanner(System.in);

        System.out.print("Enter your message: ");
        String userMessage = userInputScanner.nextLine();

        ObjectOutputStream outputToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inputFromServer = new ObjectInputStream(clientSocket.getInputStream());

        outputToServer.writeObject(userMessage);

        while (true) {
            Object serverResponse = inputFromServer.readObject();
            System.out.println("BasicSocketProgrammingWIthoutThread.Server: " + (String) serverResponse);

            String serverMessage = (String) serverResponse;
            if ("not available".equals(serverMessage) || "served".equals(serverMessage)) break;
        }

        clientSocket.close();
        userInputScanner.close();
    }
}
