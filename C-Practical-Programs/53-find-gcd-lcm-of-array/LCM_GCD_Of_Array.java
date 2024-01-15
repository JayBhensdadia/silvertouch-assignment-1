/*
 * int result = arr[0];
 * result = gcd(result, arr[0])
 * 
 * int result = arr[0];
 * result = lcm(result, arr[0]);
 */

public class LCM_GCD_Of_Array {
    public static int gcd(int a, int b){
        int min = Math.min(a, b);

        for (int i = 2; i <= min; i++) {
            if(a%i==0 && b%i==0){ return i; }
        }

        return 1;
    } 

    public static int lcm(int a, int b){
        int ans = (a * b) / gcd(a,b);
        return ans;
    }


    public static int lcm(int[] arr){
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result,arr[i]);
        }

        return result;
    }

    public static int gcd(int[] arr){
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 12,3,81};
        System.out.println("GCD = " + gcd(arr));
        System.out.println("LCM = " + lcm(arr));
    }
}
