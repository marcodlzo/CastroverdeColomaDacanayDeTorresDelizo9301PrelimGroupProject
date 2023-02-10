package prog2.prelimgroup;

import javax.swing.*;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(){
        numerator = 0;
        denominator =1;
    }

    public Fraction(int numerator , int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**This method gets the denominator of the object returning it as an int*/
    public int getNumerator(){
        return numerator;
    }

    /**This method gets the denominator of the object and returning it as an int*/
    public int getDenominator(){
        return denominator;
    }

    /**This method returns a string format of the object*/
    public String toString(){
        return numerator + "/" + denominator;
    }

    /**This method is used to compute for GCD.*/
    private static int computeGCD(int a, int b){
        if (a ==0)
            return b;
        else
            return computeGCD(b%a, a);

    }

    /**This method is used to compute the LCD of a fraction.
     * This is useful in adding, subtracting fractions and comparing fractions*/
    private static int computeLCM(int a, int b){
        int lcm = (a*b)/computeGCD(a,b);
        return lcm;
    }

    /**This method adds fractions. Its parameters contain two fraction with data type of Fraction
     returns the string format of the result*/
    public static Fraction add (Fraction first, Fraction second){
        //compute for LCD a.k.a LCM of the two numbers
        int lcm = computeLCM(first.getDenominator(), second.getDenominator());

        //this code performs the typical steps in adding fractions
        int sum = (((lcm/first.denominator)* first.numerator)
                + ((lcm/second.getDenominator())*second.getNumerator()));

        //create an object for the resulting fraction
        Fraction ans = new Fraction(sum, lcm);
        return ans;
    }

    /**This method subtracts fractions. Its parameters contain two fraction with data type of Fraction
     returns the string format of the result*/
    public static Fraction subtract (Fraction first, Fraction second){
        //compute for LCD a.k.a LCM
        int lcm = computeLCM(first.getDenominator(), second.getDenominator());

        //this code performs the typical steps in subtracting fractions
        int dif = (((lcm/first.getDenominator())* first.getNumerator())
                - ((lcm/second.getDenominator())*second.getNumerator()));

        //create an object for the resulting fraction
        Fraction ans = new Fraction(dif, lcm);

        return ans;
    }

    /**This method multiplies fractions. Its parameters contain two fraction with data type of Fraction
     returns the string format of the result*/
    public static Fraction multiplyBy (Fraction first, Fraction second){
        int numerator =  (first.getNumerator()* second.getNumerator());
        int denominator = (first.getDenominator())* second.getDenominator();

        Fraction ans = new Fraction(numerator, denominator);
        return ans;
    }

    /**This method divides fractions. Its parameters contain two fraction with data type of Fraction
     returns the string format of the result*/
    public static Fraction divideBy (Fraction first, Fraction second){
        int numerator = (first.getNumerator()* second.getDenominator());
        int denominator = (first.getDenominator())* second.getNumerator();

        Fraction ans = new Fraction(numerator, denominator);
        return ans;
    }

    /**This method reduce fractions and returns the lowest form of the fraction*/
    public  static  Fraction reduceFraction (Fraction given){
        int gcd = computeGCD(given.getNumerator(), given.getDenominator());
        int numeratorLT = given.getNumerator()/gcd;
        int denominatorLT = given.getDenominator()/gcd;

        Fraction fraction = new Fraction(numeratorLT, denominatorLT);
        return fraction;
    }

    /**This method makes the fraction into its decimal form*/
    public static double decimalForm(Fraction ans){
        return (double) ans.numerator/ans.denominator;
    }
}//end of class
