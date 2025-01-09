package BasicSocketProgrammingWithThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ServerSocket serverSocket = new ServerSocket(22222);
        int index = 1;

        while(true){
            System.out.println("Waiting for client..........");
            Socket socket= serverSocket.accept();
            System.out.println("Connected to the client...........");
            ServerThread serverThread = new ServerThread(socket,"client"+index++);

        }
    }
}
