import java.util.ArrayList;
import java.util.List;

class Stock{
    String name;
    private int price = 1;
    List<Buyer> buyers = new ArrayList<>();

    public Stock(){}
    public Stock(String name){
        this.name = name;
    }

    public void buy(Buyer b){
        buyers.add(b);
    }

    public void notifyAllBuyers(){
        for (Buyer b : buyers) {
            b.update();
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        this.notifyAllBuyers();
    }

}

class Buyer{
    String name;
    Stock stock;

    public Buyer(Stock s, String name){
        this.name = name;
        this.stock = s;
    }

    public void buyStock(){
        this.stock.buy(this);
    }

    public void update(){
        System.out.println("Stock price changed to: " + this.stock.getPrice());
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Stock tata = new Stock("tata");

        Buyer b1 = new Buyer(tata, "jay");
        b1.buyStock();

        tata.setPrice(10);
        tata.setPrice(12);
    }
}