package JavaOne.OOPS.CompexNumbers;

import JavaOne.OOPS.Fraction.Fraction;

public class ComplexNumbers {
    private int real;
    private int imaginary;

    public ComplexNumbers(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }
    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }
    public int getReal() {
        return real;
    }
    public int getImaginary() {
        return imaginary;
    }


    public void print(){
        System.out.println(this.real+"+"+"i"+this.imaginary);
    }

    public void add(ComplexNumbers c){
        this.real += c.real;
        this.imaginary += c.imaginary;
    }

    public static ComplexNumbers add(ComplexNumbers c1 , ComplexNumbers c2){

        int real = c1.real + c2.real;
        int imaginary = c1.imaginary + c2.imaginary;

        ComplexNumbers ans = new ComplexNumbers(real, imaginary);
        return ans;

    }

    public void multiply(ComplexNumbers c){
        this.real = (this.real * c.real) - (this.imaginary * c.imaginary);
        this.imaginary  = (this.real * c.imaginary) + (this.imaginary * c.real);
    }

    public static ComplexNumbers multiply(ComplexNumbers c1 , ComplexNumbers c2){

        int real = (c1.real * c2.real) - (c1.imaginary * c2.imaginary);
        int imaginary = (c1.real * c2.imaginary) + (c1.imaginary * c2.real);

        ComplexNumbers ans = new ComplexNumbers(real, imaginary);
        return ans;

    }




}
