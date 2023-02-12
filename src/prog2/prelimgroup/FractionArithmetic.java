/**
 Algorithm:

 Input:
 1. Numerator and denominator of Fraction 1.
 2. Numerator and denominator of Fraction 2.

 Process:
 1. The user inputs the numerator and denominator of Fraction 1.
 2. The user inputs the numerator and denominator of Fraction 2.
 3. The user picks which operations to be performed.
 3.1. Adds up Fraction 1 and Fraction 2.
 3.2. Subtracts Fraction 1 to Fraction 2.
 3.3. Multiplies Fraction 1 and Fraction 2.
 3.4. Divides Fraction 1 from Fraction 2.
 3.5. Reduce Fractions either Fraction 1 and 2 depending on what the user picks.
 3.6. Change the numerator and denominator of either Fraction 1 or Fraction 2 depending on what the user picks.
 4. Exits the code.



 Output:
 1. Sum of Fraction 1 and 2 and its decimal form.
 2. Difference of Fraction 1 and 2 and its decimal form.
 3. Product of Fraction 1 and 2 and its decimal form.
 4. Quotient of Fraction 1 and 2 and its decimal form.
 5. Reduced form of either Fraction 1 or 2.
 6. Changed numerator and denominator of either Fraction 1 or 2.
 */


package prog2.prelimgroup;

import javax.swing.*;
import java.text.DecimalFormat;

public class FractionArithmetic {
    static Fraction fraction1 = null;
    static Fraction fraction2 = null;

    public static void main(String[] args) {
        introduction();
        fraction1 = createFraction(1);
        fraction2 = createFraction(2);

        int choice = 0;
        do {
            choice= showMenu();
            chooseArithmetic(choice);
            if (choice==7){
                JOptionPane.showMessageDialog(null,
                        "<html><h1 style='font-family: Calibri; font-size: 18pt;'>" +
                                "Thank You for using the Program. <br>" +
                                "Have a nice day ahead!",
                        "Fraction Arithmetic Program",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }while (choice!=7);
        System.exit(0);
    }//end of main method

    /**This method shows th introduction message*/
    public static void introduction(){
        JOptionPane.showMessageDialog(null,
                "<html><h1 style='font-family: Calibri; font-size: 18pt;'>" +
                        "We are so delighted to welcome you on board! <br>" +
                        "Let's solve some basic arithmetics including Fractions.",
                "Fraction Arithmetic Program",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "<html><h1 style='font-family: Calibri; font-size: 18pt;'> Please enter your two fractions first.",
                "Fraction Arithmetic Program",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**This method shows the menu, returns an int which will determine which operations will be used*/
    public static int showMenu(){
        int answer = Integer.parseInt(JOptionPane.showInputDialog(null,
                "<html><h1 style='font-family: Calibri; font-size: 20pt;'>" + "Fraction 1: " + fraction1 +
                        "<html><h1 style='font-family: Calibri; font-size: 20pt;'>Fraction 2: " +fraction2 +
                "<html><h1 style='font-family: Calibri; font-size: 16pt; display: flex;'> <br>" +
                "What do you want to do?   <br>       " +
                "  1. Add fractions        <br>       " +
                "  2. Subtract fractions   <br>       " +
                "  3. Multiply fractions   <br>       " +
                "  4. Divide fractions     <br>       " +
                "  5. Reduce fractions     <br>       " +
                "  6. Change Fraction       <br>      " +
                "  7. Quit                            ",
                "Menu",
                JOptionPane.QUESTION_MESSAGE));
        return answer;
    }



    /**This method prompts the user to enter the numerator and the denominator of the Fraction object */
    public static Fraction createFraction(int choice){
        int numerator;
        int denominator;

        numerator = Integer.parseInt(JOptionPane.showInputDialog(null,
                "<html><h1 style='font-family: Calibri; font-size: 18pt; '>Enter NUMERATOR of Fraction "
                        + choice + " : ",
                "Fraction " + choice,
                JOptionPane.QUESTION_MESSAGE));
        denominator = Integer.parseInt(JOptionPane.showInputDialog(null,
                "<html><h1 style='font-family: Calibri; font-size: 18pt;'>Enter DENOMINATOR of Fraction "
                        + choice + " : ",
                "Fraction " + choice,
                JOptionPane.QUESTION_MESSAGE));

        Fraction fraction = new Fraction(numerator, denominator);
        return fraction;
    }


    /**This method performs the different arithmetics depending on what the user wants*/
    public static void chooseArithmetic(int choice){
        String operation;
        switch (choice){
            case 1:
                operation="Sum";
                Fraction sum = Fraction.add(fraction1,fraction2);
                formatFinalResult(sum,choice,operation,0);
                break;
            case 2:
                operation="Difference";
                Fraction dif = Fraction.subtract(fraction1,fraction2);
                formatFinalResult(dif,choice,operation,0);
                break;
            case 3:
                operation="Product";
                Fraction prod = Fraction.multiplyBy(fraction1,fraction2);
                formatFinalResult(prod,choice,operation,0);
                break;
            case 4:
                operation="Quotient";
                Fraction quo = Fraction.divideBy(fraction1,fraction2);
                formatFinalResult(quo,choice,operation,0);
                break;
            case 5:
                operation="Reduced Form";

                int pick = pickFraction();
                if (pick == 1){
                    Fraction lowestTerm = Fraction.reduceFraction(fraction1);
                    formatFinalResult(lowestTerm,choice,operation,pick);
                }else{
                    Fraction lowestTerm = Fraction.reduceFraction(fraction2);
                    formatFinalResult(lowestTerm,choice,operation,pick);
                }
                break;
            case 6:
                int choose = pickFraction();

                if (choose == 1){
                    fraction1= createFraction(choose);
                } else{
                    fraction2= createFraction(choose);
                }
                break;
            case 7:
                break;
        }
    }
    /**This method lets the user on which fraction to modify between fraction 1 and fraction 2.*/
    public static int pickFraction() {
        int pick = 0;
        while (pick > 2 || pick < 1) {
            pick = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "<html><h1 style='font-family: Calibri; font-size: 18pt;'>" + "Fraction 1: " + fraction1 +
                            "<br>Fraction 2: " + fraction2 + "<br><br>" +
                            "Press 1 to Select Fraction 1 <br> Press 2 to Select Fraction 2", "Choose Fraction",
                    JOptionPane.INFORMATION_MESSAGE));

            if (pick > 2 || pick < 1) {
                JOptionPane.showMessageDialog(null,
                        "<html><h1 style='font-family: Calibri; font-size: 18pt;'>" +
                                "Please pick either 1 or 2 only."
                        , "Choose Fraction",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return pick;
    }

    /**This method formats the final results into how it will be displayed on the JOptionPane*/
    public static void formatFinalResult(Fraction result, int choice, String operation, int pickFraction){
        if (choice<5){
            DecimalFormat format = new DecimalFormat("##.00");
            JOptionPane.showMessageDialog(null,
                    "<html><h1 style='font-family: Calibri; font-size: 18pt;'>" +
                            operation + " of " + fraction1 + " and " + fraction2 +" : "+
                            "<html><h6 style='font-family: Calibri; font-size: 18pt; color: green;'>" + result +
                            "<html><h6 style='font-family: Calibri; font-size: 18pt; color: black;'><br><br>" +
                            "Decimal Form: " + "<html><h6 style='font-family: Calibri; font-size: 18pt; color: green;'>" +
                            format.format(Fraction.decimalForm(result)),
                    "Results",
                    JOptionPane.INFORMATION_MESSAGE);
        }else if (choice==5){
            if (pickFraction == 1){
                JOptionPane.showMessageDialog(null,
                        "<html><h1 style='font-family: Calibri; font-size: 18pt;'>" +
                                operation + " of " + fraction1 + " : " +
                                "<html><h6 style='font-family: Calibri; font-size: 18pt; color: green;'>" + result,
                        "Results",
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,
                        "<html><h1 style='font-family: Calibri; font-size: 18pt;'>" +
                                operation + " of " + fraction2 + " : " +
                                "<html><h6 style='font-family: Calibri; font-size: 18pt; color: green;'>" + result,
                        "Results",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}//end of class
