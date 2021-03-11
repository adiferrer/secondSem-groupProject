package edu.slu.prog2;

/**
 * The Fraction class is a template for
 * a fraction that has the form numerator/denominator.
 *
 * @author Jerome Bustarde
 * @author Enrico Castro
 * @author Andre De Guzman
 * @author Jeanne Ferrer
 * @author Kurt Nudo
 * @author Jomari Ocampo
 * @author Eugene Pangwi
 * @version 2.0
 */

public class Fraction {
    /**
     * Holds the numerator of this fraction.
     */
    private int numerator;

    /**
     * Holds the denominator of this fraction.
     */
    private int denominator;

    /**
     * Constructs a fraction with numerator = 0 and denominator = 1. <br>
     * This constructor allows a Fraction with an equivalent numeric value of zero to
     * be created <br>
     * This becomes the default constructor (since it has no arguments) <br>
     * Example of usage: Fraction fraction = new Fraction();
     **/
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * This constructor creates a Fraction with the specified whole number as its initial value. <br>
     *
     * @param wholeNumVal example of usage: Fraction fraction = new Fraction(10);
     */
    public Fraction(int wholeNumVal) {
        this.numerator = wholeNumVal;
        denominator = 1;
    }

	/*
	Alternative version of the constructor above, implemented by calling the
	constructor defined below, using the this reference variable
		public Fraction(int wholeNumVal) {
		   this(wholeNumVal, 1);
		}
	*/

    /**
     * This constructor creates a Fraction using the explicit numerator and denominator values. <br>
     * Example of usage: Fraction fraction = new Fraction(5, 2); <br>
     *
     * @param numerator   sets an entered value of numerator to the Fraction's numerator
     * @param denominator sets an entered value of denominator to the Fraction's denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Accessor/Getter Method <br>
     *
     * @return the value of the numerator of this fraction
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Accessor/Getter Method <br>
     *
     * @return the value of the denominator of this fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Mutator/Setter Method <br>
     *
     * @param numerator sets the value of the numerator of this fraction to numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Mutator/Setter Method <br>
     *
     * @param denom sets the value of the denominator of this fraction to denom
     */
    public void setDenominator(int denom) {
        denominator = denom;
    }

    /**
     * String form of the Fraction object.
     *
     * @return a string form of the fraction following the format numerator/denominator
     **/
    public String toString() {  // this is an overridden method from the Object class
        return (numerator + "/" + denominator);
    }

    /**
     * Computes for the decimal equivalent of a Fraction.
     *
     * @return the equivalent value of the fraction in double format
     */
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /**
     * Computes for the sum of two Fractions. <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new object to hold the resulting Fraction. <br>
     * 2, If both denominators are equal, denominator is set to denominator of the first Fraction.
     * Then, add the Fraction and other Fraction. <br>
     * Else, compute the LCM of the denominators then set denominator to the LCM. <br>
     * 3. Set numerator and denominator of the resulting Fraction. <br>
     * 4. Then, return the resulting Fraction. <br><br>
     *
     * @param other another Fraction object
     * @return the sum of two Fractions
     */
    public Fraction add(Fraction other) {
        Fraction sum = new Fraction();
        int den = 0, num = 0;
        if (denominator == other.getDenominator()) { // if the denominators are equal
            den = denominator;
            num = numerator + other.getNumerator();
        } else { // if the denominators are not equal
            den = computeLCM(denominator, other.getDenominator());
            num = den / denominator * numerator + den / other.getDenominator() * other.getNumerator();
        }
        sum.setNumerator(num);
        sum.setDenominator(den);
        sum.reduce();
        return sum;
    }

    /**
     * Computes for the difference of two Fractions. <br>
     * by Jeanne Ferrer <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create new object to hold the resulting Fraction <br>
     * 2. If both denominators are equal, set denominator then
     * subtract numerators of Fraction and other Fraction. <br>
     * Else, compute the LCM of the denominators then set denominator to the LCM.
     * Compute for the difference of both numerators of the Fractions. <br>
     * 3. Set numerator and denominator of the resulting Fraction. <br>
     * 4. Return the resulting Fraction. <br><br>
     *
     * @param other other Fraction to subtract
     * @return the difference of this Fraction and another Fraction
     */
    public Fraction subtract(Fraction other) {
        Fraction difference = new Fraction();
        int den = 0, num = 0;
        if (denominator == other.getDenominator()) { // if the denominators are equal
            den = denominator;
            num = numerator - other.getNumerator();
        } else { // if the denominators are not equal
            den = computeLCM(denominator, other.getDenominator());
            num = (den / denominator * numerator) - (den / other.getDenominator() * other.getNumerator());
        }
        difference.setNumerator(num);
        difference.setDenominator(den);
        difference.reduce();
        return difference;
    }

    /**
     * Computes the product of a Fraction and another Fraction. <br>
     * by Jerome Bustarde <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new object to hold Fraction object. <br>
     * 2. Initialize variable num to hold product of the two numerator. <br>
     * 3. Initialize variable den to hold product of the two denominator. <br>
     * 4. Invoke the setNumerator method to set the value of the product of the numerator
     * to the numerator of variable product. <br>
     * 5. Invoke the setDenominator method to set the value of the product of the denominator
     * to the denominator of variable product. <br>
     * 6. Return the Fraction product. <br><br>
     *
     * @param other other Fraction to multiply with
     * @return the product of a Fraction and another Fraction
     */
    public Fraction multiplyBy(Fraction other) {
        Fraction product = new Fraction();
        int num = numerator * other.getNumerator();
        int den = denominator * other.getDenominator();
        product.setNumerator(num);
        product.setDenominator(den);
        product.reduce();
        return product;
    }

    /**
     * Computes for the quotient of two Fractions. <br>
     * by Jonah Andre De Guzman <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new object to hold the resulting quotient. <br>
     * 2. Initialize a variable (newNum) representing the resulting quotient's numerator <br>
     * 3. Initialize a variable (newDen) representing the resulting quotient's denominator <br>
     * 4. Invoke the setNumerator method to set the value of newNum to the value of the
     * quotient fraction's numerator. <br>
     * 5. Invoke the setDenominator method to set the value of newDen to the value of
     * the quotient fraction's denominator. <br>
     * 6. Return the resulting quotient fraction. <br><br>
     *
     * @param other another Fraction that serves as the divisor
     * @return the quotient of a Fraction and another Fraction
     */
    public Fraction divideBy(Fraction other) {
        Fraction quotient = new Fraction();
        int newNum = numerator * other.getDenominator();
        int newDen = denominator * other.getNumerator();
        quotient.setNumerator(newNum);
        quotient.setDenominator(newDen);
        quotient.reduce();
        return quotient;
    }   // end of the divide method

    /**
     * Returns the reciprocal of a Fraction object. <br>
     * by Kurt Matthew C. Nudo <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new Fraction object (result). <br>
     * 2. Create an int variable to hold the old denominator
     * of this object. <br>
     * 3. Set the denominator of the result Fraction to the passed
     * Fraction instance's numerator (param). <br>
     * 4. Set the numerator of the result Fraction equal to the temporary int
     * variable that holds the old denominator variable of this object. <br>
     * 5. Return the modified Fraction object (result). <br><br>
     *
     * @param param receives the passed Fraction instance.
     * @return the reciprocal of a Fraction object
     */

    public Fraction reciprocal(Fraction param) {
        var result = new Fraction();
        int temporaryDenominator = getDenominator();
        result.setDenominator(param.getNumerator());
        result.setNumerator(temporaryDenominator);
        return result;
    }

    /**
     * Compares the two fractions and determines whether one of which
     * is greater,lesser or equal to the other. <br>
     * by Eugene Justin G. Pangwi <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Creates placeholder for the fractions. <br>
     * 2. Compares the fractions by cross multiplying the
     * fractions then subtracting (comparison = a*d - c*b). <br>
     * 3. If comparison is, <br>
     * a. Equal to 0 then return a statement saying a/b = c/d. <br>
     * b. Greater than 0 then return a statement saying a/b greater than c/d. <br>
     * c. Lesser than 0 then return a statement saying a/b lesser than c/d. <br><br>
     *
     * @param other receives the Fraction
     */
    public void compareFraction(Fraction other) {
        int num1 = numerator; // placeholder for Fraction 1 numerator
        int num = other.getNumerator(); // placeholder for Fraction 2 numerator
        int den1 = denominator; // placeholder for Fraction 1 denominator
        int den = other.getDenominator(); // placeholder for Fraction 2 denominator
        int comparison = num1 * den - num * den1;
        if (comparison > 0) {
            System.out.println(num1 + "/" + den1 + " is greater than " + num + "/" + den);
        } else if (comparison == 0) {
            System.out.println(num1 + "/" + den1 + " and " + num + "/" + den + " are equal");
        } else {
            System.out.println(num1 + "/" + den1 + " is lesser than " + num + "/" + den);
        }
    }

    /**
     * Reduces the fraction to its simplest form.
     */
    public void reduce() {
        int gcd = computeGCD(numerator, denominator); // determine the greatest common divisor of numerator and denominator
        int newNumerator = numerator / gcd; //compute newNumerator, the numerator of the simplest form of this fraction
        int newDenominator = denominator / gcd; //compute newDenominator, the denominator of the simplest form of this fraction
        setNumerator(newNumerator); // set the value of the new numerator for this fraction
        setDenominator(newDenominator); // set the value of the new denominator for this fraction
    }

    /**
     * Computes the greatest common divisor of the numerator and denominator. <br>
     * by Jerome Bustarde <br><br>
     * <p>
     * METHOD ALGORITHM: (derived from Euclid's Algorithm) <br>
     * 1. Provide for GCD. <br>
     * 2. Use an If statement to check if the condition that the denominator data member isn't assigned w/ a 0. <br>
     * 3. Enclose the following instructions in a do statement:
     * Assign the modulo of the values assigned to the data members numerator and denominator to int GCD.
     * Assign denominator to numerator and GCD to denominator. <br>
     * 4. Close the do statement with the while condition that the modulo of the values assign to the data members
     * numerator and denominator. <br><br>
     *
     * @param num receive value assigned to data member, numerator
     * @param den receive value assigned to data member, denominator
     * @return the greatest common divisor of the numerator and denominator
     */
    private int computeGCD(int num, int den) {
        int rem = 1;
        while (rem != 0) {
            rem = den % num;
            den = num;
            num = rem;
        }
        return den;
    }

    /**
     * Computes for the LCM (least common multiplier) of two denominators. <br>
     * by Jeanne Ferrer<br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Set the initial LCM as the greater number of the two given denominators. <br>
     * 2. While true, if LCM mod d1 AND LCM mod d2 both equal to 0, break the while loop.
     * Else, increment LCM. <br>
     * 3. Return the LCM. <br><br>
     *
     * @param d1 first denominator
     * @param d2 second denominator
     * @return the LCM (least common multiplier) of two denominators
     */
    protected int computeLCM(int d1, int d2) {
        int lcm = Math.max(d1, d2);

        while (true) {
            if (lcm % d1 == 0 && lcm % d2 == 0)
                break;
            ++lcm;
        }

        return lcm;
    }
} //end of Fraction class

