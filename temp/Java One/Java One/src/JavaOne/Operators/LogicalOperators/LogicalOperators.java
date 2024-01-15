package JavaOne.Operators.LogicalOperators;

public class LogicalOperators {
    public static void main(String[] args) {


        System.out.println("10 > 2 && 3 > 2 : "+(10>2 && 3>2));
        System.out.println("10 > 2 || 3 > 2 : "+(10>2 && 3>2));
        System.out.println(" !(10 > 2) : "+!(10>2));

        // note that if

        // LHS of && is false then RHS is not even executed 
        // in java

        // similarly if the LHS of || is ture then RHS is not 
        // even executed in java
    }
}
