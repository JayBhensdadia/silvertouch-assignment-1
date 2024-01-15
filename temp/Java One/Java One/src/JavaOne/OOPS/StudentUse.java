package JavaOne.OOPS;

public class StudentUse {
    public static void main(String[] args) {
       
        System.out.println(Student.getTotalStudents());

        Student s1 = new Student("jay", 1);
        Student s2 = new Student("janu", 2);

        System.out.println(Student.getTotalStudents());

        
    }
}
