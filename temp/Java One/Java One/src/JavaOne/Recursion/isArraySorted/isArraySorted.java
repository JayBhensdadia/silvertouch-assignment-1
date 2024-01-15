package JavaOne.Recursion.isArraySorted;

public class isArraySorted {

    public static boolean isSorted(int[] a){
        //base case
        // if length = 1 array is sorted

        if(a.length == 1){
            return true;
        }

        //check whether the first element is greater 
        //than second or not 

        if(a[0] > a[1]){
            return false;
        }

        //if not then recursively check for smaller subarray

        int[] smallArray = new int[a.length - 1];
        for(int i = 1; i < a.length; i++){
            smallArray[i-1] = a[i];
        }
        boolean isSmallArraySorted = isSorted(smallArray);

        //if smaller subarray is sorted then array 
        //itself is also sorted
        return isSmallArraySorted;
    }

    public static boolean isSortedBetter(int[] a, int si){

        //base case
        //if start index reaches a.length - 1 
        //there is only one element we need to check 
        //and one element is always sorted
        if(si == a.length - 1){
            return true;
        }

        //check order of si^th and si+1^th 
        if(a[si] > a[si+1]){
            return false;
        }

        //do this recursively for greater start index

        boolean isSmallArraySorted = isSortedBetter(a, si+1);

        //if the small arr is sorted , big is also sorted
        return isSmallArraySorted;

    }
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,7,68};
        System.out.println(isSorted(arr));

        System.out.println(isSortedBetter(arr, 0));

        //output: true
        
    }
}
