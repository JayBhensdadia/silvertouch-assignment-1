package JavaOne.Arrays.ArrayOperations.SortingArrOfUsrDefinedClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class student{
    int id;
    String name;

    public student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String displayStd(){
        return id+" "+name;
    }

}

class sortById implements Comparator<student>{
    @Override
    public int compare(student o1, student o2) {
        return o1.id - o2.id;
    }
}

class sortByName implements Comparator<student>{
    @Override
    public int compare(student o1, student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class sortArrOfUserDefinedClass {
    public static void main(String[] args) {
        ArrayList<student> list = new ArrayList<>();

        list.add(new student(1, "jay"));
        list.add(new student(23, "purv"));
        list.add(new student(5, "janu"));

        System.out.println("Unsorted");
        for (student std : list) {
            System.out.println(std.displayStd());
        }

        System.out.println("Sorted by id");

        Collections.sort(list, new sortById());

        for (student std : list) {
            System.out.println(std.displayStd());
        }


        System.out.println("Sorted by name");
        Collections.sort(list, new sortByName());
        for (student std : list) {
            System.out.println(std.displayStd());
        }

    }
}
