abstract class PaymentHandler{
    protected PaymentHandler next;

    public void setNextPaymentHandler(PaymentHandler ph){
        this.next = ph;
    }

    public abstract void handlePayment(double amount);
}

class Bank extends PaymentHandler{
    @Override
    public void handlePayment(double amount) {
        if(amount < 500){
            System.out.println("$" + amount+" paid using bank account");
        }else{
            next.handlePayment(amount);
        }
    }
}

class CreditCard extends PaymentHandler{
    @Override
    public void handlePayment(double amount) {
        if(amount < 1000){
            System.out.println("$" + amount+" paid using credit card");
        }else{
            next.handlePayment(amount);
        }
    }
}

class PayPal extends PaymentHandler{
    @Override
    public void handlePayment(double amount) {
        System.out.println("$" + amount+" paid using paypal");
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        PaymentHandler bank = new Bank();
        PaymentHandler creditCard = new CreditCard();
        PaymentHandler paypal = new PayPal();

        bank.setNextPaymentHandler(creditCard);
        creditCard.setNextPaymentHandler(paypal);

        bank.handlePayment(300);
        bank.handlePayment(900);
        bank.handlePayment(1200);
    }
}