

class Calculator{
    public int add(int a, int b){
        return a+b;
    }

    public int add(int a, int b, int c){
        return a+b+c;
    }
}


public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();

        System.out.println("4+5 = " + cal.add(4, 5));
        System.out.println("4+5+6 = " + cal.add(4, 5, 6));
    }
}
