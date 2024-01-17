package Searching_Algorithms;

public class BinarySearch {
    
    public static int binarySearch(int[] a, int x){
        int s = 0;
        int e = a.length-1;
        while (s<=e) {
            int mid = (s+e)/2;
 
            if (a[mid]>x) {
                e = mid - 1;
 
            }else if (a[mid]<x) {
                s = mid + 1;
            }else{
                return mid;
            }
 
        }
        return -1;
    }
 

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,66,77,80};
       System.out.println(binarySearch(arr,66));
       

    }
}
