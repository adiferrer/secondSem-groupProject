package edu.slu.prog2;

import java.util.Scanner;

/**
 * The FractionArithmetic Class is a demonstration for the Fraction and MixedFraction classes.
 *
 * @author Enrico Castro
 * @author Jeanne Ferrer
 * @author Kurt Nudo
 * @version 2.0
 */
public class FractionArithmetic {
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Demonstrates the usage of the Fraction and MixedFraction classes. <br>
     * by Jeanne Ferrer
     *
     * @param args command-line parameter
     */
    public static void main(String[] args) {
        MixedFraction operand1, operand2, result;
        byte choice = 0;

        showIntro();

        do {
            showMenu();
            do { // validates the input
                try {
                    System.out.print("Enter choice: ");
                    choice = Byte.parseByte(keyboard.nextLine());
                    if (choice < 1 || choice > 9)
                        System.out.println("Please enter a number from 1-10.");
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
                    result = operand1.multiplyBy(operand2);
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
                    result = operand1.divideBy(operand2);
                    System.out.print(operand1.toString() + " / " + operand2.toString() +
                            " = " + result.toString());
                    System.out.println(" or " + result.toDouble());
                    inputBuffer();
                    break;
                case 5: // reciprocate fractions
                    System.out.println("\nRECIPROCATE MIXED FRACTION");
                    operand1 = enterFraction("fraction ");
                    System.out.println("Fraction : " + operand1);
                    operand2 = operand1.reciprocal(operand1);
                    operand2.setWholePart(operand1.getWholePart());
                    System.out.print("Reciprocated : " + operand2.toString());
                    System.out.println(" or "+ operand2.toDouble());
                    inputBuffer();
                    break;
                case 6: // mixed fraction to improper fraction
                    System.out.println("\nFROM MIXED FRACTION TO IMPROPER FRACTION");
                    operand1 = enterFraction("fraction ");
                    System.out.println("Fraction : " + operand1);
                    operand2 = operand1.toFraction();
                    System.out.print("Improper Fraction : " +
                            operand2.toString());
                    System.out.println(" or " + operand2.toDouble());
                    inputBuffer();
                    break;
                case 7: // fraction to decimal operation
                    System.out.println("\nMIXED FRACTION TO DECIMAL");
                    operand1 = enterFraction("fraction ");
                    System.out.print("Fraction : " + operand1);
                    System.out.println(" or " + operand1.toDouble());
                    inputBuffer();
                    break;
                case 8: // simplification operation
                    System.out.println("\nSIMPLIFYING A MIXED FRACTION");
                    operand1 = enterFraction("fraction ");
                    System.out.println("Fraction : " + operand1);
                    operand1.reduce();
                    System.out.print("Simplified Fraction : " +
                            operand1.toString());
                    System.out.println(" or " + operand1.toDouble());
                    inputBuffer();
                    break;
            }

            if (choice != 9) {
                choice = 0;
            }

        } while (choice != 9);

        System.out.println("\nTHANK YOU FOR USING THIS APPLICATION! :-)");
    } // end of main method

    /**
     * Displays an introductory message. <br>
     * Enrico Nathanielle P. Castro <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Display a message
     */
    private static void showIntro() {
        System.out.println("This program performs mathematical operations on mixed fractions.");
        System.out.println("See menu below.");
    }

    /**
     * Displays the list of operations that the application could do.<br>
     * by Jeanne Adeline S. Ferrer <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Display the menu of operations, which are: <br>
     * Add fractions, Subtract fractions, Multiply fractions, Divide fractions,<br>
     * Reciprocate a fraction, Convert a mixed fraction to an improper fraction, <br>
     * Convert a fraction to decimal, Simplify a fraction, Quit
     */
    private static void showMenu() {
        System.out.println("""
                +------------------------------------------+
                |   What do you want to do?                |
                |       1. Add fractions                   |
                |       2. Subtract fractions              |
                |       3. Multiply fractions              |
                |       4. Divide fractions                |
                |       5. Reciprocate fraction            |
                |       6. Convert a mixed fraction to     |
                |          an improper fraction            |
                |       7. Convert a fraction to decimal   |
                |       8. Simplify a fraction             |
                |       9. Quit                            |
                +------------------------------------------+""");
    }

    /**
     * Initializes and declares a Mixed Fraction object based on the data acquired.
     *
     * @param operand determines whether it is the 1st or 2nd Mixed Fraction
     * @return a Mixed Fraction
     */
    private static MixedFraction enterFraction(String operand) {
        MixedFraction fraction = null;
        int wholeNumber = 0, numerator = 0, denominator;

        try {
            wholeNumber = enterFractionData("whole part", operand);
            numerator = enterFractionData("numerator", operand);
            denominator = enterFractionData("denominator", operand);
            fraction = new MixedFraction(wholeNumber, numerator, denominator);
        } catch (NoNumeratorException noNumerator) {
            fraction = new MixedFraction();
            fraction.setWholePart(wholeNumber);
        } catch (NoDenominatorException noDenominator) {
            fraction = new MixedFraction();
            fraction.setWholePart(wholeNumber + numerator);
        } finally {
            return fraction;
        }
    }

    /**
     * This method asks for the specific part of a Fraction.
     *
     * @param part specific part of the Fraction that is being asked of the user
     * @param fractionInfo determines if it is the 1st or 2nd Fraction
     * @return an integer for the respective part of the Fraction
     */
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
            if (part.equalsIgnoreCase("whole part"))
                return 0;
            if (part.equalsIgnoreCase("numerator")) {
                throw new NoNumeratorException();
            } else {
                throw new NoDenominatorException();
            }
        }
    }

    /**
     * Serves as a buffer between performed operation and the next choice of operation of the user. <br>
     * by Jeanne Ferrer <br><br>
     * <p>
     * METHOD ALGORITHM:  <br>
     * 1. Display "Press enter to continue"  <br>
     * 2. Wait for user to press the enter button  <br>
     */
    private static void inputBuffer() {
        System.out.println();
        System.out.print("Press enter to continue");
        keyboard.nextLine();
        System.out.println();
    }
}