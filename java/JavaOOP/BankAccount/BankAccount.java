import java.util.ArrayList;
import java.util.Random;

public class BankAccount {
    private double checkBalance ;
    private double savingBalance;
    private static int numberOfAccounts;
    private static double amountOfMoney;
    public String accountNumber;
    // constructor
    public BankAccount(){
        numberOfAccounts++;
        accountNumber=accountNumber();
    }
    // getter & setter
    public void setCheckBalance(double checkBalance){
        this.checkBalance=checkBalance;
        amountOfMoney+=checkBalance;
    }
    public void setSavingBalance(double savingBalance){
        this.savingBalance=savingBalance;
        amountOfMoney+=savingBalance;
    }
    public double getCkeckBalance(){
        return checkBalance;
    }
    public double getSavingBalance(){
        return savingBalance;
    }
    public static double getAmountOfMoney(){
        return amountOfMoney;
    }
    public static int getNumberOfAccount(){
        return numberOfAccounts;
    }
    // methodes
    public void deposit(double money , String account){
        if (account == "saving"){
            savingBalance+=money;
            amountOfMoney+=money;
        }
        else if (account == "check"){
            checkBalance+=money;
            amountOfMoney+=money;
        }
        else{
            System.out.println("there is no account");
        }
        
    }
    public void withdraw(double money , String account){
        if (account == "saving" && savingBalance > money){
            savingBalance-=money;
            amountOfMoney-=money;
        }
        else if (account == "check" && checkBalance > money){
            checkBalance-=money;
            amountOfMoney-=money;
        }
        else{
            System.out.println("there is no account or there is no enough money");
        }
    }
    public void display(){
        System.out.println(" saving amont is : " + savingBalance);
        System.out.println(" check amount is : " + checkBalance);
        System.out.println("Total is : " + amountOfMoney);
    }
    private String accountNumber(){
        Random number = new Random();
        int low = 1;
        int high= 10;
        String myAccountnumber= new String();
        for (int i=0;i<10;i++){
            int num = number.nextInt(high-low) +low;
            myAccountnumber+=num;
        }
        return myAccountnumber;
    }
}
