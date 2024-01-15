package JavaOne.VariablesDataType;
/**
 * Instance variables are those variables that are 
 * not defined within a block, method or constructor 
 * but defined within a class.

    Instance variables are declared when an 
    object of that class is created, and when 
    the object gets destroyed the instance variables 
    also get destroyed.

     Initialization of instance variables is 
     not mandatory; it is default taken as 0.

 */

public class InstanceVariable {

    int var;
    int var2 = 10;

    public static void main(String[] args) {
        
        InstanceVariable i = new InstanceVariable();
        System.out.println(i.var);
        System.out.println(i.var2);
    }
    
}
