package Sorting_Algorithms;

public class CountingSort {

    public static void countingSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; 
        }

        
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }

        
        int[] count = new int[max + 1];

        
        for (int num : array) {
            count[num]++;
        }

        
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        
        int[] result = new int[array.length];

        
        for (int i = array.length - 1; i >= 0; i--) {
            result[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        
        System.arraycopy(result, 0, array, 0, array.length);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        
        System.out.println("Original Array:");
        printArray(array);

        countingSort(array);

        System.out.println("Sorted Array using Counting Sort:");
        printArray(array);
    }
}
