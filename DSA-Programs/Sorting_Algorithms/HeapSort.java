package Sorting_Algorithms;


public class HeapSort {

    public static void heapSort(int[] array) {
        int n = array.length;

        // max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        
        for (int i = n - 1; i > 0; i--) {
            
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Original Array:");
        printArray(array);

        heapSort(array);

        System.out.println("Sorted Array using Heap Sort:");
        printArray(array);
    }
}
