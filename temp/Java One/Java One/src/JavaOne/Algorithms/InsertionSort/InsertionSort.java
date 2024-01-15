package JavaOne.Algorithms.InsertionSort;

public class InsertionSort {
    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void insertionSort(int[] a) {

        int n = a.length;
 
        for (int i = 0; i < n; i++) {
 
            // insert ith element in sorted portion
 
            int j = i - 1;
            int temp = a[i];
 
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
 
            // position will be j+1
 
            a[j + 1] = temp;
 
        }
 
    }

    public static void main(String[] args) {

        int[] a = {-1,-9,9,-3,4,5,6,77};
        insertionSort(a);
        printArray(a);
        
    }
}
