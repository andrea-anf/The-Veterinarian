import java.net.*;
import java.io.*;
public class Worker extends Thread{
    private Socket connection = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private String animal;
    Animal myAnimal = new Animal();
    WaitingRoom room;

    public Worker(Socket newSocket, WaitingRoom r){
        connection = newSocket;
        room = r;
        try{
            inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            outToClient = new DataOutputStream(connection.getOutputStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        try{
            //animal = inFromClient.readLine();
            animal = myAnimal.specie();
            room.enterRoom(animal);
            Thread.sleep(10000);
            room.exitRoom(animal);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
