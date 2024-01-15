
import java.util.ArrayList;


/*
 *  1 2 3 4 5 
 *  3 4 5 6 7
 * 
 * -----------
 *  3 4 5 
 * 
 * 
 */

public class IntersectionOfArrays {
    
    public static int[] intersection(int[] a1, int[] a2){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if(a1[i]==a2[j]){ list.add(a1[i]);}
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;

    }

    public static void printArray(int[] arr){
        for (int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {3,4,5,6,7,8};

        int[] ans = intersection(arr1, arr2);
        printArray(ans);
    }
    
}
