import java.util.ArrayList;
import java.util.List;


//two incompatible interfaces
interface Item{
    public String getName();
    public String getPrice();
    public String getRestaurantName();
}

interface GroceryItem{
    public String getName();
    public String getPrice();
    public String getStore();
}


class Pizza implements Item{
    @Override
    public String getName() {
        return "Pizza";
    }

    @Override
    public String getPrice() {
        return "$12";
    }

    @Override
    public String getRestaurantName() {
        return "Dominos";
    }

    public void displayDetails(){
        System.out.println("Name: " + this.getName() + ", Price: " + getPrice() + ", Restaurant: " + getRestaurantName());
    }
}

class Suger implements GroceryItem{
    @Override
    public String getName() {
        return "Suger";
    }

    @Override
    public String getPrice() {
        return "$5";
    }

    @Override
    public String getStore() {
        return "All-in-One-General-store";
    }

    public void displayDetails(){
        System.out.println("Name: " + this.getName() + ", Price: " + getPrice() + ", Store: " + getStore());
    }

}


//adapter
class GroceryAdapter implements Item{
    private GroceryItem gitem;
    public GroceryAdapter(GroceryItem item){
        this.gitem = item;
    }

    @Override
    public String getName() {
        return gitem.getName();
    }

    @Override
    public String getPrice() {
        return gitem.getPrice();
    }

    @Override
    public String getRestaurantName() {
        return gitem.getStore();
    }
}


class Store{
    private List<Item> list;

    public Store(){
        list = new ArrayList<>();
    }

    public void addItem(Item item){
        list.add(item);
    }

    public void removeItem(Item item){
        list.remove(item);
    }

    public void displayItems(){
        for (Item item : list) {
            System.out.println(item.getName());
        }
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Pizza pizza = new Pizza();
        Suger suger = new Suger();

        Store store = new Store();
        store.addItem(pizza);
        store.addItem(new GroceryAdapter(suger));

        store.displayItems();
    }
}