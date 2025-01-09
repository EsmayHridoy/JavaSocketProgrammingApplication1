package BasicSocketProgrammingWithThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {
    Socket clientSocket;
    Thread thread;
    String name;
    ServerThread(Socket clientSocket, String name){
        this.clientSocket = clientSocket;
        this.name = name;
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream())) {


            Object clientMsg = ois.readObject();
            System.out.println(name+": " + (String) clientMsg);


            String act = "Your are in Queue....";
            oos.writeObject(act);


            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("Your Message: ");
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
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
