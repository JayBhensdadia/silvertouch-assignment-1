
/* LOGIC:
 * The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.
 * 
 * O(n^2) -> worst case
 * O(n) -> best case
 */
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
 
            //array is sorted till i-1 (j)
            int j = i - 1;
            
            //current element
            int temp = a[i];
 
            //decreament the j till you find element smaller than temp
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
