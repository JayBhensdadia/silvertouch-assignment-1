import java.util.ArrayList;
import java.util.List;

interface Employee{
    public void displayDetails();
}

class Developer implements Employee{
    String name;
    String role;

    public Developer(String name, String role){
        this.name = name;
        this.role = role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Role: " + this.role);
    }
}

class Manager implements Employee{
    String name;
    String role;

    public Manager(String name, String role){
        this.name = name;
        this.role = role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Role: " + this.role);
    }
}


class CompanyDirectory implements Employee{

    List<Employee> list = new ArrayList<>();

    public void addEmployee(Employee emp){
        list.add(emp);
    }

    public void removeEmployee(Employee emp){
        list.remove(emp);
    }

    @Override
    public void displayDetails() {
        for (Employee emp : list) {
            emp.displayDetails();
            System.out.println("----------------------------");
        }
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Employee e1 = new Developer("jay", "full-stack developer");

        Employee e2 = new Manager("ajay", "product-manager");

        CompanyDirectory dir = new CompanyDirectory();

        dir.addEmployee(e1);
        dir.addEmployee(e2);

        dir.displayDetails();
    }
}