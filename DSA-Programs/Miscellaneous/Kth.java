package Miscellaneous;

import java.util.Arrays;

public class Kth {
    
    public static int smallest(int[] arr, int k){
        if (k>=arr.length) {
            return -1;
        }
        Arrays.sort(arr);
        return arr[k-1];
    }

    public static int largest(int[] arr, int k){
        if (k>=arr.length) {
            return -1;
        }
        Arrays.sort(arr);
        return arr[arr.length-k];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,4,5,3};
        int k = 3;

        System.out.println(k+"th largest element: " + largest(arr, k));
        System.out.println(k+"th smallest element: " + smallest(arr, k));
        
    }
}
