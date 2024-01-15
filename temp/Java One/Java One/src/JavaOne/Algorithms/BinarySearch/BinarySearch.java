package JavaOne.Algorithms.BinarySearch;

public class BinarySearch {

    //iterative
    public static int binarySearch(int[] a, int x){
        int s = 0;
        int e = a.length;
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
 
    //recursive
    public static int binarySearch(int[] a, int si, int ei, int x){

        //base case 
        if(si>ei){
            return -1;
        }

        int mid = (si + ei)/2;
        
        if(a[mid]==x){
            return mid;
        }else if(a[mid] < x){
            return binarySearch(a, mid+1, ei, x);
        }else{
            return binarySearch(a, si, mid-1, x);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,66,77,80};
       System.out.println(binarySearch(arr,66));
       System.out.println(binarySearch(arr, 0, arr.length - 1, 661));

    }
}
