
public class ReverseArray {
    
    public static void printArray(int[] arr){
        for (int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static int[] reverseArray(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[arr.length-i-1] = arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        printArray(reverseArray(arr));
    }    
}
