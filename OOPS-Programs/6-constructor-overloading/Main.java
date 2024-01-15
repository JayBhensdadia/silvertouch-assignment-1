class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(){
        this.name = "unknown";
        this.age = -1;
    }

    public void displayDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("jay", 21);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}