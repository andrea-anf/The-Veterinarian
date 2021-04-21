import java.util.ArrayList;
import java.util.Random;

public class WaitingRoom extends Thread {
    private int dogCounter;
    private boolean catPresence;

    public WaitingRoom(){
        dogCounter = 0;
        catPresence = false;
    }

    public synchronized void enterRoom(String animal) throws InterruptedException {
        System.out.println("[+] " + animal + " " + Thread.currentThread().getId() + " is trying to enter the room");

        switch (animal){
            case "dog":
                if(dogCounter >= 4){
                    wait();
                }
                if (catPresence == true){
                    wait();
                }
                dogCounter++;
                System.out.println("[+] Dog " + Thread.currentThread().getId() + " in the room: " + dogCounter);

                break;

            case "cat":
                if(dogCounter > 0){
                    wait();
                }
                else if (catPresence == true){
                    wait();
                }

                catPresence = true;
                System.out.println("[+] Cat " + Thread.currentThread().getId() + " in the room");

                break;
        }

    }

    public synchronized void exitRoom(String animal){
        switch (animal){
            case "dog":
                System.out.println("[+] Dog " + Thread.currentThread().getId() + " is leaving the room");
                dogCounter--;
                notify();
                break;
            case "cat":
                System.out.println("[+] Cat " + Thread.currentThread().getId() + " is leaving the room");
                catPresence = false;
                notify();
                break;
        }

    }



}
