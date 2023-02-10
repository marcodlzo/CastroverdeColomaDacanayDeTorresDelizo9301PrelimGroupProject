package prog2.prelimgroup;

import java.util.Scanner;

public class FractionArithmetic {
    static Scanner kbd = new Scanner(System.in);
    static Fraction fraction1 = null;
    static Fraction fraction2 = null;

    public static void main(String[] args) {
        int choice = 0;
        //we have to enter the first fraction
        do {
            showMenu();
            choice = choose(1,8);
            if (choice>1){
                System.out.println("Must enter the first fraction. Pick 1");
            }
        }while (choice>1);

        cases(choice);

        do {
            showMenu();
            choice = choose(1,8);

            if (choice == 8){
                System.out.println("Thankyou for using the program");
            }
            cases(choice);

        }while (choice!=8);







    }

    public static void showMenu(){
        System.out.println("+------------------------------------------+");
        System.out.println("|   What do you want to do?                |");
        System.out.println("|       1. Enter value of fraction 1       |");
        System.out.println("|       2. Enter value of fraction 2       |");
        System.out.println("|       3. Add fractions                   |");
        System.out.println("|       4. Subtract fractions              |");
        System.out.println("|       5. Multiply fractions              |");
        System.out.println("|       6. Divide fractions                |");
        System.out.println("|       7. Reduce fractions                |");
        System.out.println("|       8. Quit                            |");
        System.out.println("+------------------------------------------+");
    }

    public static int choose(int min, int max){
        int choice=0;
        do {
            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(kbd.nextLine());
        }while (choice>max || choice<min);
        return choice;

    }

    public static Fraction createFraction(int choice){
        int numerator;
        int denominator;


        System.out.print("\nEnter the numerator of fraction " + choice + " :" );
        numerator = Integer.parseInt(kbd.nextLine());
        System.out.print("Enter the denominator of fraction " + choice + " :" );
        denominator = Integer.parseInt(kbd.nextLine());

        Fraction fraction = new Fraction(numerator, denominator);
        return fraction;
    }

    public static void cases(int choice){
        switch (choice){
            case 1:
                fraction1=createFraction(choice);
                break;
            case 2:
                fraction2=createFraction(choice);
                break;
            case 3:
                Fraction sum = Fraction.add(fraction1,fraction2);
                System.out.println(sum);
                break;
            case 4:
                Fraction dif = Fraction.subtract(fraction1,fraction2);
                System.out.println(dif);
                break;
            case 5:
                Fraction prod = Fraction.multiplyBy(fraction1,fraction2);
                System.out.println(prod);
                break;
            case 6:
                Fraction quo = Fraction.divideBy(fraction1,fraction2);
                System.out.println(quo);
                break;
            case 7:
                Fraction summ = Fraction.add(fraction1,fraction2);
                System.out.println(summ);
                break;
            case 8:
                break;
        }
    }




}
