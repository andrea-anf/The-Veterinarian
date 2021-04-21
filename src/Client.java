import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        String address = "localhost";
        int port = 6789;
        String data;
        Scanner user_input = new Scanner(System.in);

        //Create connection
        System.out.println("Connecting to server...");
        Socket connection = new Socket("localhost", 6789);
        System.out.println("Successfull connected\n");

        //crete "file descriptor" for i/o
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        DataOutputStream outToServer = new DataOutputStream(connection.getOutputStream());

/*
        System.out.println("animal:");
        String animal = user_input.nextLine();
        outToServer.writeBytes(animal+"\n");
*/

        System.out.println("Press enter to leave the veterinarian...");
        user_input.nextLine();
        outToServer.writeBytes("\n");


        connection.close();

    }
}



