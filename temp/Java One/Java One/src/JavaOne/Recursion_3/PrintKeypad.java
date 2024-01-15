package JavaOne.Recursion_3;

import java.util.HashMap;

public class PrintKeypad {
    public static HashMap<Integer,String> map;

    //hashmap that stores the string corresponding to 
    //every numbers in the dial pad
    public static void createMap(){
        map = new HashMap<>();
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        map.put(0,"");
    }

    public static void printKeypad(int n , String sofar){
        createMap();
        if(n==0){
            System.out.println(sofar);
            return;
        }
        int num = map.get(n%10).length();
        for(int i = 0; i<num;i++){
            printKeypad(n/10, sofar+map.get(n%10).charAt(i));
        }

    }

    public static void main(String[] args) {
        printKeypad(234, "");
    }
}
