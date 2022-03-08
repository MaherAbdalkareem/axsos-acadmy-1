public class TestOrders {
    public static void main(String[] args) {
        Items item1= new Items();
        Items item2= new Items();
        Items item3= new Items();
        Items item4= new Items();
        item1.name="mocha";
        item2.name="latte";
        item3.name="drip coffee";
        item4.name="capuccino";
        item1.price= 1.5;
        item2.price= 0.5;
        item3.price= 2.5;
        item4.price= 1;
        Order order1= new Order();
        Order order2= new Order();
        Order order3= new Order();
        Order order4= new Order();
        order1.name="Cindhuri";
        order2.name="Jimmy";
        order3.name="Noah";
        order4.name="Sam";
        System.out.println(order1.name);
        order2.items.add(item1);
        order2.total+=item1.price;
        order3.items.add(item4);
        order3.total+=item4.price;
        order4.items.add(item2);
        order4.total+=item2.price;
        order1.ready=true;
        order4.items.add(item2);
        order4.total+=item2.price;
        order4.items.add(item2);
        order4.total+=item2.price;
        order2.ready=true;
        System.out.println(order4.total);
    }
}
