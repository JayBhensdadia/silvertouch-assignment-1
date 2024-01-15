package JavaOne.Recursion_3;

import java.util.ArrayList;

public class ArrayListTo2DArray {
    /**
     * for converting 2d arraylist of strings to 2d array of strings
     * String[][] ans = mainList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
     * 
     */
    public static void main(String[] args) {

        System.out.println("---------------------------JB-------------------------------");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i+1);
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(arr);
        list.add(arr);
        list.add(arr);

        int[] a = arr.stream().mapToInt(Integer:: intValue).toArray();
        
        int[][] b = list.stream().map(l->l.stream().mapToInt(Integer :: intValue).toArray()).toArray(int[][] :: new);

        System.out.println("converting ArrayList<Integer> to array:");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

        System.out.println("converting ArrayList<ArrayList<Integer>> to  array :");
        for (int i = 0; i < b.length; i++) {
            int[] temp = b[i];
            for(int j = 0; j < temp.length; j++){
                System.out.print(temp[j]+" ");
            }
            System.out.println();
        }

        System.out.println("jay".substring(0,0)+String.valueOf('J')+"jay".substring(0));
    }
}
