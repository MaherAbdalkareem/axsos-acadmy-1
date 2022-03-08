

public class PuzzelTest {
    public static void main(String [] args){
    PuzzelJava puzzel = new PuzzelJava();
    System.out.println(puzzel.getTenRolls());
    System.out.println(puzzel.getRandomLetter());
    System.out.println(puzzel.generatePassword());
    System.out.println(puzzel.getNewPasswordSet(8));
    }
}
