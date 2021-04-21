import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {


        ServerSocket welcomeSocket = new ServerSocket(6789);
        WaitingRoom room = new WaitingRoom();


        while(true){
            System.out.println("\n[+] Waiting for animals");
            Socket connection = welcomeSocket.accept();
            System.out.println("[+] Connected with: " + connection.getInetAddress() + ":" + connection.getPort());

            //passing the connection to a new worker
            Worker sonThread = new Worker(connection, room);
            sonThread.start();
        }
    }
}