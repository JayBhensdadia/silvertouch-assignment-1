package Miscellaneous;

public class ReverseSentence {
    
    public static String reverseString(String str){
        String[] arr = str.split(" ");

        String ans = "";

        for (int i = arr.length-1; i >= 0; i--) {
            ans+=arr[i] + " ";
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "this is a sample string";
        System.out.println(reverseString(str));
    }

}
