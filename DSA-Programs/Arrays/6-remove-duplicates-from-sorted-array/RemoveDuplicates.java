import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    

    public static void printArray(int[] arr){
        for (int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static List<Integer> removeDuplicates(List<Integer> arr){
        Set<Integer> set = new HashSet<>(arr);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Integer[] arr = { 0,0, 1 , 1, 2, 3, 4, 5,5};
        List<Integer> ans = removeDuplicates(Arrays.asList(arr));
        System.out.println(ans);
    }
}
