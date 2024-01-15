/**
 * Person
 */
public class Person {

    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    private void displayDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: "+this.age);
    }


    public static void main(String[] args) {
        Person p = new Person("jay", 21);
        p.displayDetails();
    }
}