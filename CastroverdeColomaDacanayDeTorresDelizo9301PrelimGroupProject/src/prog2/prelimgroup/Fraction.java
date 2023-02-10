package prog2.prelimgroup;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(){
        numerator = 0;
        denominator =1;
    }

    public Fraction(int wholeNumVal){

    }

    public Fraction(int numerator , int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**This method sets the numerator of the object*/
    public void setNumerator(int num){
        this.numerator = num;
    }

    /**This method sets the denominator of the object*/
    public void setDenominator(int num){
        this.denominator = num;
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

    public double toDouble(){
        return (double) numerator/denominator;
    }

    /**This method is used to compute for GCD. This is useful in converting fraction to decimal*/
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
        //this basically constructs an object for the answers and its
        // actual parameters are the computation for the numerator and denominator
        Fraction ans = new Fraction((first.getNumerator()* second.getNumerator()),
                (first.getDenominator())* second.getDenominator());

        return ans;
    }

    /**This method divides fractions. Its parameters contain two fraction with data type of Fraction
     returns the string format of the result*/
    public static Fraction divideBy (Fraction first, Fraction second){

        Fraction ans = new Fraction((first.getNumerator()* second.getDenominator()),
                (first.getDenominator())* second.getNumerator());

        return ans;
    }

    public static double decimalForm(Fraction ans){
        return (double) ans.numerator/ans.denominator;
    }






}
