package JavaOne.OOPS.Fraction;

public class FractionUse {
    public static void main(String[] args) {
        //Fraction f = new Fraction(4, 6);
        // f.print();
        // f.increment();
        // f.print();
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(1, 2);
         Fraction ans = Fraction.add(f1, f2);
         ans.print();
    }
}
