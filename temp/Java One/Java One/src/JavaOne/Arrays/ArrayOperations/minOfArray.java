package JavaOne.Arrays.ArrayOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class minOfArray {

    public static int smallestInArray(int[] a){
        int min = 0;
        Integer[] arr = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }

        min = Collections.min(Arrays.asList(arr));

        return min;

    }
    public static String smallestInArray(String[] a){
        String min = "";

        min = Collections.min(Arrays.asList(a));

        return min;

    }

    public static void main(String[] args) {

        int[] a = {-1,-9,9,-3,4,5,6,77};
        String[] str = {"AA","AGH","Aa","hfjkad"};

        System.out.println(smallestInArray(a));
        System.out.println(smallestInArray(str));
        

        
    }
}
