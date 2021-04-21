import java.util.Random;

public class Animal {

    public String specie(){
        Random picker = new Random();
        boolean specie = picker.nextBoolean();

        if(specie == true){
            return "dog";
        }
        else{
            return "cat";
        }

    }
}
