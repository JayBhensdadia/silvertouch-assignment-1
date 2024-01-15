package JavaOne.Recursion_3;

public class PrintFactorial {
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n * fact(n-1);
    }
    public static void printFact(int n){
        System.out.println(fact(n));
    }
    
    public static void printFact2(int n, int ans){
        if(n==0){
            System.out.println(ans);
            return;
        }
        printFact2(n-1, ans*n);
    }
    public static void main(String[] args) {
        printFact(5);
        printFact2(5, 1);
    }
}
