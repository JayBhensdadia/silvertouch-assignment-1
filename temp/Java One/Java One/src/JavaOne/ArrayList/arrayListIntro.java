package JavaOne.ArrayList;

import java.util.ArrayList;

public class arrayListIntro {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(1,80);
        
        System.out.println(arr);
        arr.remove(0);
        System.out.println(arr);
        arr.remove(arr.get(2));
        System.out.println(arr);
        arr.set(1, 22);
        System.out.println(arr);


        ArrayList<Integer> list = new ArrayList<>(20);
        list.add(11);

        //here size of list is 1 and capacity is 20

        //size = number of elements
        //capacity = max number of elements that can be stored 
        //currenlty (although it can grow once 20 elements are added)
    }
}
