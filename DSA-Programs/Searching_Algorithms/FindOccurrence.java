package Searching_Algorithms;

public class FindOccurrence {

    public static int findFirstOccurrence(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; 
    }

    public static int findLastOccurrence(int[] array, int target) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; 
    }



    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 2, 2, 3, 4, 4, 5, 6};

        int target = 2;

        int firstOccurrence = findFirstOccurrence(sortedArray, target);
        int lastOccurrence = findLastOccurrence(sortedArray, target);

        if (firstOccurrence != -1 && lastOccurrence != -1) {
            System.out.println("First occurrence of " + target + ": " + firstOccurrence);
            System.out.println("Last occurrence of " + target + ": " + lastOccurrence);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}
