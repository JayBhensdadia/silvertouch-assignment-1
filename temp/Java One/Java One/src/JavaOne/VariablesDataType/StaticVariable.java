package JavaOne.VariablesDataType;

/**
 * Static variables are almost the same as instance 
 * variables , they are also defined outside of block,
 *  method or constructor and in the class.

    But the difference is that it is defined with 
    the ‘static’ keyword.

    Note : 
    the static variables have only one copy means 
    if you have defined variable in class and 
    you have created many objects of that class then also 
    the static variable is the only one memory location known 
    by that variable name (only one copy exists.)
 */

public class StaticVariable {
    static int var = 10;

    public static void main(String[] args) {
        StaticVariable s1 = new StaticVariable();
        StaticVariable s2 = new StaticVariable();

        System.out.println("before any operation");
        System.out.println("s1.var: "+s1.var);
        System.out.println("s2.var: "+s2.var);


        s2.var = 111;

        System.out.println("after doing s2.var = 111");
        System.out.println("s1.var: "+s1.var);
        System.out.println("s2.var: "+s2.var);

    }
    
}
