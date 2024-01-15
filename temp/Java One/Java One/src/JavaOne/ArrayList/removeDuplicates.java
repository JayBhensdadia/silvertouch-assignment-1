package JavaOne.ArrayList;

import java.util.ArrayList;

public class removeDuplicates {

    public static ArrayList<Integer> removeConsicutiveDuplicates(int[] arr){

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=arr[i-1]){
                ans.add(arr[i]);
            }
        }
        return ans;

    }
    
    public static void main(String[] args) {
        int[] a = {10,10,20,20,20,30,40,30,30,10};
        ArrayList<Integer> list = removeConsicutiveDuplicates(a);
        System.out.println(list);
    }
}
