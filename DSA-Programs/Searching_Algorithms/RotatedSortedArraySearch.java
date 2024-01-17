package Searching_Algorithms;

public class RotatedSortedArraySearch {

    public static int searchInRotatedArray(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; 
            }

            
            if (array[left] <= array[mid]) {
                
                if (array[left] <= target && target < array[mid]) {
                    right = mid - 1; 
                } else {
                    left = mid + 1; 
                }
            } else { 
                
                if (array[mid] < target && target <= array[right]) {
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = searchInRotatedArray(rotatedArray, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the rotated array.");
        }
    }
}
