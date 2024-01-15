

public class BankAccount {
    private int accountNumber;
    private int balance;
    

    public BankAccount(int acNo, int bal){
        this.accountNumber = acNo;
        this.balance = bal;
    }


    private void deposit(int amount){
        this.balance+=amount;
    }

    private void withdraw(int amount){
        this.balance -= amount;
    }

    private void displayDetails(){
        System.out.println("Account Number: "+this.accountNumber);
        System.out.println("Balance: " + this.balance);
    }


    public static void main(String[] args) {
        BankAccount account = new BankAccount(108, 10000);
        account.displayDetails();
        System.out.println();
        System.out.println("after deposit of 1500");
        account.deposit(1500);
        account.displayDetails();

        System.out.println();
        System.out.println("after withdrawal of 1200");
        account.withdraw(1200);
        account.displayDetails();
    }
    
}
