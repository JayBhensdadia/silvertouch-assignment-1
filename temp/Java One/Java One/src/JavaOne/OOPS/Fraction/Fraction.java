package JavaOne.OOPS.Fraction;

import JavaOne.Conditionals.nested;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private static int findGCD(int a, int b){

        int gcd = 1;
        for(int i = 2; i <= Math.min(a, b); i++){
            if(a%i==0 && b%i==0){
                gcd = i;
            }
        }
        return gcd;
    }

    private static int findLCM(int a, int b){
        int gcd = findGCD(a, b);
        int lcm = (a*b)/gcd;
        return lcm;
    }

    private void simplify() {

        int gcd = findGCD(numerator, denominator);

        numerator = numerator / gcd;
        denominator = denominator / gcd;

    }

    public void setNumerator(int n){
        numerator = n;
    }
    public void setDenominator(int n){
        if(n==0){
            System.out.println("denominator can not be zero");
        }else{
            denominator = n;
        }

    }


    public int getNumerator(){
        return numerator;
    }
    
    public int getDenominator() {
        return denominator;
    }

    public void print(){
        System.out.println(numerator+"/"+denominator);
    }

    public void increment(){
        numerator = numerator + denominator;
        simplify();
    }

    public static Fraction add(Fraction f1, Fraction f2){
        f1.simplify();
        f2.simplify();
       
        int numerator = (f1.numerator * f2.denominator) + (f2.numerator * f1.denominator);
        int denominator = f1.denominator * f2.denominator;
        Fraction f = new Fraction(numerator, denominator);
        f.simplify();
        return f;

    }



}
