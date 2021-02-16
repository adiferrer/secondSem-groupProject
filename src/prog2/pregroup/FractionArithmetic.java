package prog2.pregroup;

import java.util.Scanner;

public class FractionArithmetic {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Fraction operand1, operand2, result;
        byte choice = 0;

        showIntro();

        do {
            showMenu();
            do { // validates the input
                try {
                    System.out.print("Enter choice: ");
                    choice = Byte.parseByte(keyboard.nextLine());
                    if (choice < 1 || choice > 8)
                        System.out.println("Please enter a number from 1-9.");
                } catch (NumberFormatException x) {
                    System.out.println("Not a valid input!");
                }
            } while (choice < 1 || choice > 9);

            switch (choice) {
                case 1: // addition operation
                    System.out.println("\nADDING TWO FRACTIONS");
                    operand1 = enterFraction("fraction 1 ");
                    System.out.println("Fraction 1: " + operand1);
                    operand2 = enterFraction("fraction 2 ");
                    System.out.println("Fraction 2: " + operand2);
                    result = operand1.add(operand2);
                    System.out.print(operand1.toString() + " + " + operand2.toString() +
                            " = " + result.toString());
                    System.out.println(" or " + result.toDouble());
                    inputBuffer();
                    break;
                case 2: // subtraction operation
                    System.out.println("\nSUBTRACTING TWO FRACTIONS");
                    operand1 = enterFraction("fraction 1 ");
                    System.out.println("Fraction 1: " + operand1);
                    operand2 = enterFraction("fraction 2 ");
                    System.out.println("Fraction 2: " + operand2);
                    result = operand1.subtract(operand2);
                    System.out.print(operand1.toString() + " - " + operand2.toString() +
                            " = " + result.toString());
                    System.out.println(" or " + result.toDouble());
                    inputBuffer();
                    break;
                case 3: // multiplication operation
                    System.out.println("\nMULTIPLYING TWO FRACTIONS");
                    operand1 = enterFraction("fraction 1 ");
                    System.out.println("Fraction 1: " + operand1);
                    operand2 = enterFraction("fraction 2 ");
                    System.out.println("Fraction 2: " + operand2);
                    result = operand1.multiply(operand2);
                    System.out.print(operand1.toString() + " x " + operand2.toString() +
                            " = " + result.toString());
                    System.out.println(" or " + result.toDouble());
                    inputBuffer();
                    break;
                case 4: // division operation
                    System.out.println("\nDIVIDING TWO FRACTIONS");
                    operand1 = enterFraction("fraction 1 ");
                    System.out.println("Fraction 1: " + operand1);
                    operand2 = enterFraction("fraction 2 ");
                    System.out.println("Fraction 2: " + operand2);
                    result = operand1.divide(operand2);
                    System.out.print(operand1.toString() + " / " + operand2.toString() +
                            " = " + result.toString());
                    System.out.println(" or " + result.toDouble());
                    inputBuffer();
                    break;
                case 5: // reciprocal operation
                    System.out.println("\nGETTING THE RECIPROCAL");
                    operand1 = enterFraction("fraction ");
                    System.out.println("Fraction : " + operand1);
                    result = operand1.reciprocal(operand1);
                    System.out.print(operand1.toString() + " = " +
                            result.toString());
                    System.out.println(" or " + result.toDouble());
                    inputBuffer();
                    break;
                case 6: // fraction to decimal operation
                    System.out.println("\nFRACTION TO DECIMAL");
                    operand1 = enterFraction("fraction ");
                    System.out.println("Fraction : " + operand1);
                    System.out.println(operand1.fractionToDecimal());
                    inputBuffer();
                    break;
                case 7: // simplification operation
                    System.out.println("\nSIMPLIFYING A FRACTION");
                    operand1 = enterFraction("fraction ");
                    operand2 = operand1;
                    System.out.println("Fraction : " + operand1);
                    operand2.reduce();
                    System.out.println(operand1.toString() + " = " +
                            operand2.toString());
                    inputBuffer();
                    break;
                case 8: // comparison operation
                    System.out.println("\nCOMPARING TWO FRACTIONS");
                    operand1 = enterFraction("fraction 1 ");
                    System.out.println("Fraction 1: " + operand1);
                    operand2 = enterFraction("fraction 2 ");
                    System.out.println("Fraction 2: " + operand2);
                    operand1.compareFraction(operand2);
                    inputBuffer();
                    break;
            }

            choice = 0;
        } while (choice != 9);

        System.out.println("\nTHANK YOU FOR USING THIS APPLICATION! :-)");
    }

    /*
 /*
        METHOD NAME: showIntro
        WRITTEN BY: ENRICO CASTRO

        METHOD DESCRIPTION: Displays a message 

        PARAMETERS:
                    N/A
        METHOD ALGORITHM:
                    1. Display a message 
    */
    private static void showIntro() {
        System.out.println("This program performs mathematical operations on fractions.");
        System.out.println("See menu below.");
    }


    /*
        METHOD NAME: showMenu
        WRITTEN BY: Jeanne Adeline S. Ferrer

        METHOD DESCRIPTION: Displays the list of operations that the
                            application could do
        PARAMETERS:
                    N/A
        METHOD ALGORITHM:
                    1. Display the menu of operations, which are
                            a. Add fractions
                            b. Subtract fractions
                            c. Multiply fractions
                            d. Divide fractions
                            e. Reciprocate a fraction
                            f. Convert a fraction to decimal
                            g. Simplify a fraction
                            h. Compare fractions
                            i. Quit

     */
    private static void showMenu() {
        System.out.println("""
                +------------------------------------------+
                |   What do you want to do?                |
                |       1. Add fractions                   |
                |       2. Subtract fractions              |
                |       3. Multiply fractions              |
                |       4. Divide fractions                |
                |       5. Reciprocate a fraction          |
                |       6. Convert a fraction to decimal   |
                |       7. Simplify a fraction             |
                |       8. Compare fractions               |
                |       9. Quit                            |
                +------------------------------------------+""");
    }

    private static Fraction enterFraction(String operand) {
        Fraction fraction = null;
        int numerator = 0, denominator;

        try {
            numerator = enterFractionData("numerator", operand);
            denominator = enterFractionData("denominator", operand);
            fraction = new Fraction(numerator, denominator);
        } catch (NoNumeratorException noNumerator) {
            fraction = new Fraction();
        } catch (NoDenominatorException noDenominator) {
            fraction = new Fraction(numerator);
        } finally {
            return fraction;
        }
    }

    private static int enterFractionData(String part, String fractionInfo) {
        int input;
        try {
            System.out.print("Enter " + part + " of " + fractionInfo + ": ");
            input = Integer.parseInt(keyboard.nextLine());
            if (part.equalsIgnoreCase("denominator") && input == 0) {
                System.out.println("Denominator cannot be zero.");
                input = enterFractionData(part, fractionInfo);
            }
            return input;
        } catch (Exception exc) {
            if (part.equalsIgnoreCase("numerator")) {
                throw new NoNumeratorException();
            } else {
                throw new NoDenominatorException();
            }
        }
    }

    /*
        METHOD NAME: inputBuffer
        WRITTEN BY: Jeanne Adeline S. Ferrer

        METHOD DESCRIPTION: Serves as a buffer between performed operation and the next
                            choice of operation of the user
        PARAMETERS:
                    N/A
        METHOD ALGORITHM:
                    1. Display "Press enter to continue"
                    2. Wait for user to press the enter button

     */
    private static void inputBuffer() {
        System.out.println();
        System.out.print("Press enter to continue");
        keyboard.nextLine();
        System.out.println();
    }
}

