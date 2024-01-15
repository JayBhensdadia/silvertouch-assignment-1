/**
 * 1-sum-of-elements
 */
public class SumOfElements {

    public static int sum(int[] arr){
        int ans = 0;
        for (int i : arr) {
            ans+=i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(sum(arr));
    }
}