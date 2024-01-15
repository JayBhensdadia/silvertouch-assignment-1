class MathOps{
    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2){
        return new ComplexNumber(c1.real+c2.real, c1.img+c2.img);
    }

    public static Number add(Number n1, Number n2){
        return new Number(n1.real + n2.real);
    }
}
class ComplexNumber{
    int real;
    int img;

    public ComplexNumber(int real, int img){
        this.real = real;
        this.img = img;
    }

    

    public static void printCN(ComplexNumber c){
        System.out.println(c.real + "+i" + c.img);
    }
}

class Number{
    int real;

    public Number(int real){
        this.real = real;
    }

    

    public static void printNumber(Number n){
        System.out.println(n.real);
    }
}




public class Main {
    public static void main(String[] args) {
        ComplexNumber c = new ComplexNumber(1, 2);
        ComplexNumber c2 = new ComplexNumber(2, 3);

        ComplexNumber.printCN(MathOps.add(c, c2));

        Number n1 = new Number(11);
        Number n2 = new Number(12);
        
        Number.printNumber(MathOps.add(n1, n2));


    }
}
