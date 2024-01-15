package JavaOne.Recursion.Power;

public class Power {
    public static int power(int x, int n){

        //base case
        if(n==0){
            return 1;
        }
        int smallOutput = power(x, n-1);

        //assuming we already have power x^n-1

        //so just need to multiply x to that
        int output = x * smallOutput;
        return output;
    }
    public static void main(String[] args) {
        System.out.println(power(2, 5));
    }
}
