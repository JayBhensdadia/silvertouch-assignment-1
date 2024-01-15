package JavaOne.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

import JavaOne.ArrayList.removeDuplicates;

public class RemoveDuplicates {

    public static ArrayList<Integer> removeDup(int[] a){

        HashMap<Integer,Boolean> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if(!map.containsKey(a[i])){
                list.add(a[i]);
                map.put(a[i], true);
            }
        }

        return list;

    }
    
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,3,1,6,2,5};
        ArrayList<Integer> output = removeDup(arr);
        System.out.println(output);
    }
}
