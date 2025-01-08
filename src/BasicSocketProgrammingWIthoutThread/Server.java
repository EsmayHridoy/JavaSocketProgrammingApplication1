package BasicSocketProgrammingWIthoutThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("BasicSocketProgrammingWIthoutThread.Server is running...");

        while (true) {
            System.out.println("Waiting for a client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {


                Object clientMsg = ois.readObject();
                System.out.println("Client: " + (String) clientMsg);


                String act = "Your are in Queue....";
                oos.writeObject(act);


                Scanner input = new Scanner(System.in);
                while (true) {
                    System.out.print("Your Message: ");
                    act = input.nextLine();
                    oos.writeObject(act);

                    if ("served".equals(act) || "not available".equals(act)) {
                        break;
                    }
                }

                System.out.println("Client served. Waiting for the next client...");
            } catch (Exception e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                socket.close();
            }
        }
    }
}
