package JavaOne.Arrays.ArrayOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class maxOfArray {

    public static int largestInArray(int[] a){
        int max = 0;
        Integer[] arr = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }

        max = Collections.max(Arrays.asList(arr));

        return max;

    }
    public static String largestInArray(String[] a){
        String max = "";
       
        max = Collections.max(Arrays.asList(a));

        return max;

    }

    public static void main(String[] args) {

        int[] a = {-1,-9,9,-3,4,5,6,77};
        String[] str = {"AA","AGH","Aa","hfjkad"};

        System.out.println(largestInArray(a));
        System.out.println(largestInArray(str));
        

        
    }
    
}
