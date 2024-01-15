

class MathOperation{
    public static double sqrt(int n){
        return Math.sqrt(n);
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 16;
        System.out.println("Square root of " + n + " is " + MathOperation.sqrt(n));
    }
}
