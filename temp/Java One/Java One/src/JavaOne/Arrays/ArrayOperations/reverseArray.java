package JavaOne.Arrays.ArrayOperations;

import java.util.Arrays;
import java.util.Collections;

public class reverseArray {

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void printArray(Integer[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


    public static Integer[] reverseArr(int[] a){
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i]=a[i];
        }
        Collections.reverse(Arrays.asList(b));
        return b;
    }

    public static void main(String[] args) {
        int[] arr = {11, 12,-99, -2 ,112,2,34};

        printArray(reverseArr(arr));
        
    }
}
