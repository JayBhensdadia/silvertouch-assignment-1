import java.util.ArrayList;
import java.util.List;

public class MergeList {

    public static List<Integer> merge(int[] l1, int[] l2) {
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();

        while (j < l2.length && i < l1.length) {

            if (l1[i] <= l2[j]) {
                ans.add(l1[i]);
                i++;
            }

            else {
                ans.add(l2[j]);
                j++;
            }

        }

        while (i < l1.length) {
            ans.add(l1[i]);
            i++;
        }

        while (j < l2.length) {
            ans.add(l2[j]);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 5, 6, 11 };
        int[] arr2 = { 3, 4, 7 };
        List<Integer> list = merge(arr1, arr2);
        System.out.println(list);
    }
}
