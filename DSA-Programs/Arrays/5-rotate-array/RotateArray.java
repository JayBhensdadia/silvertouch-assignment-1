

public class RotateArray {

    public static void printArray(int[] arr){
        for (int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static void printRotatedArray(int[] arr, int k){

        int[] ans = new int[arr.length];
        int n = arr.length;

        //put last k elements at begining
        for(int i =0; i< k; i++){
            ans[i] = arr[n-k+i];
        }

        //put first n-k elements at last
        for(int i = k; i < ans.length; i++){
            ans[i] = arr[i-k];
        }
        printArray(ans);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        printRotatedArray(arr, 2);
    }
}
