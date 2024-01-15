//component

import java.util.ArrayList;
import java.util.List;

interface Department{
    void displayDetails();
}


//leaf
class Sales implements Department{
    @Override
    public void displayDetails() {
        System.out.println("This is a SALES department");
    }
}


class It implements Department{
    @Override
    public void displayDetails() {
        System.out.println("This is an IT department");
    }
}


class Finance implements Department{
    @Override
    public void displayDetails() {
        System.out.println("This is a Finance department");
    }
}


//composite
class Head implements Department{
    private List<Department> departments;

    public Head(){ departments = new ArrayList<>();}


    public void addDepartment(Department dept){
        departments.add(dept);
    }

    public void removeDepartment(Department dept){
        departments.remove(dept);
    }

    @Override
    public void displayDetails() {
        System.out.println("Head Department:");
        for (Department d : departments) {
            d.displayDetails();
        }
    }

}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Sales sales = new Sales();
        It it = new It();
        Finance finance = new Finance();

        Head head = new Head();
        head.addDepartment(finance);
        head.addDepartment(sales);


        head.displayDetails();
    }
}