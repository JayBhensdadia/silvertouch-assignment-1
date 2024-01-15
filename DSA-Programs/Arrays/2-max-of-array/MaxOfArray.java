
public class MaxOfArray {


    public static int max(int[] arr){
        int maximum = Integer.MIN_VALUE;
        for (int item : arr) {
            if(item > maximum){ maximum = item; }
        }
        return maximum;
    }

    public static void main(String[] args) {
        int[] arr = {1,23,3,4,5};
        System.out.println(max(arr));
    }    
}
