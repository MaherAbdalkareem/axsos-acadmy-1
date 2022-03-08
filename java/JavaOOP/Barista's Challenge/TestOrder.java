public class TestOrder {
    public static void main(String[] args) {
        Order order1= new Order();
        Order order2= new Order();
        Order order3= new Order("Maher");
        Order order4= new Order("Ahmad");
        Order order5= new Order("Mohammad");

        Items item1= new Items("mocha",1.5);
        Items item2= new Items("drip-coffee",3.5);
        Items item3= new Items("tea",1);

        order3.addItems(item1);
        order3.addItems(item2);
        order4.addItems(item3);
        order5.addItems(item2);

        order3.display();
        order5.display();
        order4.display();

        order5.setReady(true);
        order4.setReady(false);
        order5.setReady(true);
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());

        order3.getOrderTottal();
        
}
}

