package JavaOne.Recursion_3;

public class PrintMinInArray {

    public static void printMin(int[] arr, int si, int minSoFar){
        if(si==arr.length){
            System.out.println(minSoFar);
            return;
        }

        if(arr[si]<minSoFar){
            minSoFar = arr[si];
        }
        printMin(arr, si+1, minSoFar);
    }
    public static void main(String[] args) {
        int[] a = {12,3,5,7,8,9,1};
        printMin(a, 0, Integer.MAX_VALUE);
    }
}
