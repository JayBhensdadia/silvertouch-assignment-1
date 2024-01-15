interface BillingStrategy{
    public void getBill(int amount);
}

class NormalBilling implements BillingStrategy{
    @Override
    public void getBill(int amount) {
        System.out.println("payable amount: $" + amount + ", disount: N/A");
    }
}

class DiscountBilling implements BillingStrategy{
    @Override
    public void getBill(int amount) {
        System.out.println("original amount: $" + amount + ", disount: 10%" + ", payable amount: $" + (int)amount*0.9);
    }
}


class Context {
    private BillingStrategy strategy;
    private String customerType;

    public Context(String customerType){
        this.customerType = customerType;

        if(customerType.equalsIgnoreCase("regular")){
            strategy = new DiscountBilling();
        }else{
            strategy = new NormalBilling();
        }
    }

    

    public void executeStrategy(int amount){
        this.strategy.getBill(amount);
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Context context = new Context("normal");
        context.executeStrategy(1200);

        context = new Context("regular");
        context.executeStrategy(500);
    }
}