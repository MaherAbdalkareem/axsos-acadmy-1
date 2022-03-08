
import java.util.ArrayList;
import java.util.Collections;

import javafx.print.Collation;
 class CafeUtil {
    public int getStreakGoal(int num){
        int sum=0;
        for (int i=0;i <= num ;i++){
            sum+=i;
        }
        return sum;
    }
    public double getOrderTotal(double[] prices){
        double sum =0;
        for (int i=0; i<prices.length;i++){
            sum+=prices[i];
        }
        return sum ;
    }
    public void displayMenu(ArrayList<String> menuList){
        for (int i=0;i<menuList.size();i++){
        System.out.println(i + menuList.get(i));
    }
    } 
    public void addCustomer(ArrayList<String> customer){
        System.out.println("Please enter your name : ");
        String userName=System.console().readLine();
        customer.add(userName);
        System.out.println("Hello " + userName +"! There are " + (customer.size()-1) + "people ahead of you"  );
        System.out.println(customer);
    }
}
