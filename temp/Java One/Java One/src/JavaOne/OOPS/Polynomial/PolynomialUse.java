package JavaOne.OOPS.Polynomial;

public class PolynomialUse {
    public static void main(String[] args) {
        Polynomial p  = new Polynomial();
        p.setCoefficient(0, 3);
        p.setCoefficient(1, 1);
        
        p.print();
        System.out.println(p.degree());



        Polynomial p2 = new Polynomial();
        p2.setCoefficient(0, 4);
        p2.setCoefficient(1, 2);
        
        p2.print();
        System.out.println(p2.degree());


        // p2.setCoefficient(2, p2.getCoeeficient(2)+4);
        // p2.print();
        
        
        //System.out.println(p2.getCoeeficient(2));


        // System.out.println(p.degree());

        //p.multiply(p2);
        //p.print();
    }
}
