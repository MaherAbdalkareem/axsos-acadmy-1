
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
 class PuzzelJava {
    public ArrayList<Integer> getTenRolls(){
        Random number = new Random();
        ArrayList<Integer> randomArray= new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            int num = number.nextInt();
            randomArray.add(num);
        }
        return randomArray;
    }
    public String getRandomLetter(){
        ArrayList<String> letter = new ArrayList<String>();
        Collections.addAll(letter,"A","B","C","D","E","F","J","H","I","G","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        int low=0;
        int high=25;
        Random number = new Random();
        int num = number.nextInt(high-low) +low;
        String alpha=letter.get(num);
        return alpha;
    }
    public ArrayList<String> generatePassword(){
        ArrayList<String> letter = new ArrayList<String>();
        Collections.addAll(letter,"A","B","C","D","E","F","J","H","I","G","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        int low=0;
        int high=25;
        ArrayList<String> password =new ArrayList<String>();
        for (int i=0 ; i<8;i++){
        Random number = new Random();
        int num = number.nextInt(high-low) +low;
        String alpha=letter.get(num);
        password.add(alpha);
    }
    return password;}

    public ArrayList<String> getNewPasswordSet(int number){
        ArrayList<String> letter = new ArrayList<String>();
        Collections.addAll(letter,"A","B","C","D","E","F","J","H","I","G","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        int low=0;
        int high=25;
        ArrayList<String> password =new ArrayList<String>();
        for (int i=0 ; i< number;i++){
        Random x = new Random();
        int num = x.nextInt(high-low) +low;
        String alpha=letter.get(num);
        password.add(alpha);
    }
    return password;}
}
