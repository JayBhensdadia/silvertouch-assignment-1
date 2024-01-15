package JavaOne.Recursion.TowerOfHanoi;

public class TowerOfHanoi {

    public static void solveTOH(int n, char a, char b, char c){

        //base case
        if(n==1){
            System.out.println(a+" to "+c);
            return;
        }

        solveTOH(n-1, a, c, b);
        System.out.println(a + " to "+ c);
        solveTOH(n-1, b, a, c);

    }

    public static void main(String[] args) {
        solveTOH(3, 'a', 'b', 'c');

        // output:
        // a to c
        // a to b
        // c to b
        // a to c
        // b to a
        // b to c
        // a to c
    }
}
