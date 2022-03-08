import java.util.ArrayList;

public class Order {
    private String name;
    double total;
    private boolean ready;
    private ArrayList<Items> items;
    public Order(){
        this.name="Guest";
        this.items=new ArrayList<Items>();
    }
    public Order(String name){
        this.name=name;
        this.items=new ArrayList<Items>();
    }
    public void setName(String name){
        this.name=name;
    }
    public void setReady(boolean ready){
        this.ready=ready;
    }
    public void setArrayList(ArrayList<Items> items){
        this.items=items;
    }
    public String getName(){
        return name;
    }
    public boolean getReady(){
        return ready;
    }
    public ArrayList<Items> getItems(){
        return items;
    }
    public void addItems(Items item){
        items.add(item);
    }
    public String getStatusMessage(){
        if (this.ready){
            return "Your order is ready.";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public void display(){
        total=0;
        System.out.println("Customer name is : " + name);
        for ( Items item : items){
        System.out.println(item.getName() + ":" + item.getPrice());
        total+=item.getPrice();
    }
        System.out.println("Total :" + total);
    }
    public void getOrderTottal(){
        total=0;
        for ( Items item : items){
            total+=item.getPrice();
        }
        System.out.println("Total :" + total);
    }

}
