package Searching_Algorithms;

public class InterpolationSearch {

    public static int interpolationSearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && target >= array[low] && target <= array[high]) {
            
            int pos = low + ((target - array[low]) * (high - low)) / (array[high] - array[low]);

            if (array[pos] == target) {
                return pos; 
            }

            if (array[pos] < target) {
                low = pos + 1; 
            } else {
                high = pos - 1; 
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int target = 6;

        int result = interpolationSearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
