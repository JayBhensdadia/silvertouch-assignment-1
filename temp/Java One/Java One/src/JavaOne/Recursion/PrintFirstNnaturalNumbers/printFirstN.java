package JavaOne.Recursion.PrintFirstNnaturalNumbers;

public class printFirstN {
    public static void printN(int n){
        //base case
        if(n==0){
            return;
        }
        //small output
        printN(n-1);
        //output
        System.out.println(n);
    }
    public static void main(String[] args) {
        printN(10);
    }
}
