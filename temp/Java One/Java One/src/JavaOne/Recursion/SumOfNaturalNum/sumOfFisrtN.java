package JavaOne.Recursion.SumOfNaturalNum;
 
public class sumOfFisrtN {
    public static int sumN(int n){
        //base case 
        if(n==0){
            return 0;
        }
        int smallOutput = sumN(n-1);
        // from I.H we assume that we already have sum till n-1

        //so just need to add n into sum till n-1
        int output = n + smallOutput;
        return output;
    }
    public static void main(String[] args) {
        System.out.println(sumN(10));

        //output : 55
    }    
}
