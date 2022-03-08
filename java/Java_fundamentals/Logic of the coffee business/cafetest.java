import java.util.ArrayList;
import java.util.Collections;

public class cafetest {
    public static void main(String [] args){
        CafeUtil coffees = new CafeUtil();
        int streakCafe = coffees.getStreakGoal(10);
        System.out.println("Purchases needed for week 10 :" + streakCafe);
        double[] order={3.5, 1.5, 4.0, 4.5};
        double orderTotal = coffees.getOrderTotal(order);
        System.out.println("Order Total: " + orderTotal);
        ArrayList<String> myMenu= new ArrayList<String>();
        Collections.addAll(myMenu,"café de goteo", "capuchino", "latte","moka");
        coffees.displayMenu(myMenu);
        ArrayList<String> users= new ArrayList<String>();
        for(int i= 0; i<4;i++){
        coffees.addCustomer(users);}
    }
}
