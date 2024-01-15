package JavaOne.Arrays.ArrayOperations;

import java.util.Arrays;
import java.util.Collections;

public class sortOperation {

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


    public static void ascendingSort(int[] a){
        Arrays.sort(a);
    }
    public static Integer[] descendingSort(int[] b){

        Integer[] a = new Integer[b.length];

        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
        

        Arrays.sort(a,Collections.reverseOrder());
        return a;
    }

    public static void main(String[] args) {

        int[] arr = {11, 12,-99, -2 ,112,2,34};

        System.out.println("array");
        printArray(arr);

        System.out.println("ascending order");
        ascendingSort(arr);
        printArray(arr);
        System.out.println("descending order");
        //descendingSort(arr)
        printArray(descendingSort(arr));
        
        
    }
}
