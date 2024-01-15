interface PaymentStrategy{
    public void makePayment(int amount);
}


class CreditCardPayment implements PaymentStrategy{
   @Override
   public void makePayment(int amount) {
       System.out.println("payed $"+amount + " with credit card");
   }
}

class PaypalPayment implements PaymentStrategy{
    @Override
    public void makePayment(int amount) {
        System.out.println("payed $"+amount+" with pay-pal");
    }
}

class Context{
    private PaymentStrategy strategy;

    public Context(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(int amount){
        this.strategy.makePayment(amount);
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Context context = new Context(new CreditCardPayment());
        context.executeStrategy(1200);

        context = new Context(new PaypalPayment());
        context.executeStrategy(1099);
        
    }
}