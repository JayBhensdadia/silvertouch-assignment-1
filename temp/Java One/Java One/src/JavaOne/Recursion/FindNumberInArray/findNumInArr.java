package JavaOne.Recursion.FindNumberInArray;

public class findNumInArr {

    public static boolean find(int a[], int key){
        //base case
        //if length is one then there is only one element

        if(a.length == 1){

            // if that element is == key than return true
            // false otherwise

            if(a[0]==key){
                return true;
            }else{
                return false;
            }
        }

        // if the first element is key in current arr
        if(a[0]==key){
            return true;
        }

        //then recursively check for smaller sub array

        //smaller subarray starting from index 1 of current arr
        int[] smallArr = new int[a.length - 1];

        for(int i = 1; i < a.length; i++){
            smallArr[i-1] = a[i];
        }
        boolean isFoundInSmallArr = find(smallArr, key);

        // if it is found in smaller sub array then it is 
        // also going to be found in arr
        return isFoundInSmallArr;


    }
    public static void main(String[] args) {
        int[] arr = {10,2,3,4,5,6};
        System.out.println(find(arr,60));
    }
}
