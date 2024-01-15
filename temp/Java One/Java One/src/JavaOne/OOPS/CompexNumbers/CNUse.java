package JavaOne.OOPS.CompexNumbers;

public class CNUse {
    public static void main(String[] args) {
        ComplexNumbers c1 = new ComplexNumbers(1, 3);
        ComplexNumbers c2 = new ComplexNumbers(2, 3);

        ComplexNumbers a = ComplexNumbers.add(c1, c2);
        a.print();

        ComplexNumbers b = ComplexNumbers.multiply(c1, c2);
        b.print();

        
    }
}
