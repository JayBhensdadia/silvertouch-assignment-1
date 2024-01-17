package Searching_Algorithms;

public class LinearSearch {
    
    public static int linearSearch(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==key){ return i;}
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(linearSearch(arr, 5));
    }
}
