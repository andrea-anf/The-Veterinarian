import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {


        ServerSocket welcomeSocket = new ServerSocket(6789);
        WaitingRoom room = new WaitingRoom();
        System.out.println("\n[+] The veterinarian is open, just waiting for animals...");


        while(true){
//            System.out.println("\n[+] Waiting for connections");
            Socket connection = welcomeSocket.accept();
//            System.out.println("[+] Connected with: " + connection.getInetAddress() + ":" + connection.getPort());

            //passing the connection to a new worker
            Worker sonThread = new Worker(connection, room);
            sonThread.start();
        }
    }
}