interface Coffee{
    public int cost();
}


class BasicCoffee implements Coffee{
    @Override
    public int cost() {
        return 10;
    }
}

class Decorator implements Coffee{
    private Coffee cf;

    public Decorator(Coffee cf){
        this.cf = cf;
    }

    @Override
    public int cost() {
        return this.cf.cost();
    }
}


class Milk extends Decorator{

    public Milk(Coffee cf){
        super(cf);
    }

    @Override
    public int cost() {
        return super.cost() + 5;
    }
}


class Suger extends Decorator{

    public Suger(Coffee cf){
        super(cf);
    }

    @Override
    public int cost() {
        return super.cost() + 15;
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Coffee milkCoffee = new Milk(new BasicCoffee());
        Coffee sugerCoffee = new Suger(new BasicCoffee());
        Coffee milkSugerCoffee = new Suger(new Milk(new BasicCoffee()));
        System.out.println("Milk coffee price = " + milkCoffee.cost());
        System.out.println("Milk + Suger coffee price = " + milkSugerCoffee.cost());
    }
}