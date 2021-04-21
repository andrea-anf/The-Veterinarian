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
//                every time a thread is notified by others, check if conditions are false
                while (dogCounter >= 4 | catPresence == true) wait();

                dogCounter++;
                System.out.println("[+] dog " + Thread.currentThread().getId() + " in the room: " + dogCounter);

                break;

            case "cat":
//                every time a thread is notified by others, check if conditions are false
                while (dogCounter > 0 | catPresence == true) wait();

                catPresence = true;
                System.out.println("[+] cat " + Thread.currentThread().getId() + " in the room");
                break;
        }

    }

    public synchronized void exitRoom(String animal){
        switch (animal){
            case "dog":
                dogCounter--;
                System.out.println("[+] dog " + Thread.currentThread().getId() + " is leaving the room, dog(s) in the room: " + dogCounter);
//                notify that a dog is leaving the room
                notify();
                break;
            case "cat":
                catPresence = false;
                System.out.println("[+] cat " + Thread.currentThread().getId() + " is leaving the room");
//                notify that a dog is leaving the room
                notify();
                break;
        }

    }



}
