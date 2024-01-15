package JavaOne.OOPS;

public class Student {
    String name;
    int rollNo;
    private static int totalStudents;

    public Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
        totalStudents++;
    }

    public static int getTotalStudents(){
        //System.out.println(rollNo); 
        //cannot use class's non static properties inside the static method
        return totalStudents;
    }

}
