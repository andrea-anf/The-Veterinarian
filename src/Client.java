import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        String address = "localhost";
        int port = 6789;

        //Create connection
        System.out.println("Connecting to server...");
        Socket connection = new Socket(address, port);
        System.out.println("Successfull connected\n");

        connection.close();

    }
}



