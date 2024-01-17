package Miscellaneous;

import java.util.HashMap;

public class Majority {
    
    public static int majorityElement(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }

        for (Integer i : map.keySet()) {
            if(map.get(i) > n/2){return i;}
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2,3,3,3,4,4,4,4,4,4,4};
        System.out.println(majorityElement(arr));
    }
}
