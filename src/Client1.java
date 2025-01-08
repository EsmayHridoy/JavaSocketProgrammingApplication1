import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1",22222);
        Scanner input = new Scanner(System.in);
        System.out.print("Your message: ");
        String yourMsg = input.nextLine();

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream((socket.getInputStream()));

        oos.writeObject(yourMsg);

        while(true){
            Object serverMsg = ois.readObject();
            System.out.println("Server: "+(String)serverMsg);

            String act = (String) serverMsg;
            if("not available".equals(act) || "served".equals(act))break;
        }
        socket.close();
        input.close();
    }
}
