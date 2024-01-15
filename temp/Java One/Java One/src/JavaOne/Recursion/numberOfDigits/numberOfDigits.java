package JavaOne.Recursion.numberOfDigits;

public class numberOfDigits {
    
    public static int numOfDigits(int n){
        //base case
        if(n<10){
            return 1;
        }
        int smallOutput = numOfDigits(n/10);
        //assuming we already have digits till n/10
        
        //so adding 1 will give us our ans
        int output = 1 + smallOutput;
        return output;
    }
    
    public static void main(String[] args) {
        System.out.println(numOfDigits(12357));
        System.out.println(numOfDigits(156));
        System.out.println(numOfDigits(1));

        //output : 
        //  5 
        //  3 
        //  1
    }
}
