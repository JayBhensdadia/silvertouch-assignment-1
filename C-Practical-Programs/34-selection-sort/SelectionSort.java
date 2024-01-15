

/* LOGIC:
 * 
 * repeatedly selecting the smallest (or largest) element from the unsorted portion of the list and moving it to the sorted portion of the list. 
 * 
 * O(n^2)
 * 
 */
public class SelectionSort {
    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void selectionSort(int[] a){
        int n = a.length;
 
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (a[j]<a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
 
    }
    public static void main(String[] args) {

        int[] a = {-1,-9,9,-3,4,5,6,77};
        selectionSort(a);
        printArray(a);
        
    }
}
