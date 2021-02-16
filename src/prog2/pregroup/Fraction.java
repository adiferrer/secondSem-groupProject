package prog2.pregroup;

/**
 * The Fraction class
 * A template for a fraction that has the form numerator/denominator
 */

public class Fraction {
    // object fields
    private int numerator; // holds the numerator of this fraction
    private int denominator; // holds the denominator of this fraction

    /**
     * Constructs a fraction with numerator = 0 and denominator = 1
     * This constructor allows a Fraction with an equivalent numeric value of zero to
     * be created… This becomes the default constructor (since it has no arguments)…
     * Example of usage: Fraction fraction = new Fraction();
     **/
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * This constructor creates a Fraction with the specified whole number as its initial value…
     * Example of usage: Fraction fraction = new Fraction(10);
     */
    public Fraction(int wholeNumVal) {
        this.numerator = wholeNumVal;
        denominator = 1;
    }

	/*
	Alternative version of the constructor above, implemented by calling the
	constructor defined below, using the this reference variable…
		public Fraction(int wholeNumVal) {
		   this(wholeNumVal, 1);
		}
	*/

    /**
     * This constructor creates a Fraction using the explicit numerator and denominator values…
     * Example of usage: Fraction fraction = new Fraction(5, 2);
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Accessor/Getter Method
     * Returns the value of the numerator of this fraction
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Accessor/Getter Method
     * Returns the value of the denominator of this fraction
     */
    public int getDenominator() {
        return denominator;
    }


    /**
     * Mutator/Setter Method
     * Sets the value of the numerator of this fraction to numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Mutator/Setter Method
     * Sets the value of the denominator of this fraction to denom
     */
    public void setDenominator(int denom) {
        denominator = denom;
    }

    /**
     * Returns a string form of the fraction following the format numerator/denominator
     **/
    public String toString() {  // this is an overridden method from the Object class
        return (numerator + "/" + denominator);
    }

    /**
     * Returns the equivalent value of the fraction in double format
     */
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /*
        METHOD NAME: add

        METHOD DESCRIPTION: Returns the sum of this fraction and another fraction
        PARAMETERS:
                    1. Fraction other
        METHOD ALGORITHM:
                    1. Create new object to hold the resulting Fraction
                    2. If both denominators are equal,
                            Set denominator to denominator of the first Fraction
                            Add Fraction and other Fraction
                       Else
                            Compute the LCM of the denominators
                            Set denominator to the LCM
                            Compute for the sum of both Fractions  
                    3. Set numerator and denominator of the resulting Fraction
                    4. Return the resulting Fraction
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

    /*
        METHOD NAME: subtract
        WRITTEN BY: Jeanne Adeline S. Ferrer

        METHOD DESCRIPTION: Returns the difference of this Fraction and another Fraction
        PARAMETERS:
                    1. Fraction other
        METHOD ALGORITHM:
                    1. Create new object to hold the resulting Fraction
                    2. If both denominators are equal,
                            Set denominator
                            Subtract numerators of Fraction and other Fraction
                       Else
                            Compute the LCM of the denominators
                            Set denominator to the LCM 
                            Compute for the difference of both numerators of the Fractions
                    3. Set numerator and denominator of the resulting Fraction
                    4. Return the resulting Fraction
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

    /*
        METHOD NAME: multiply
        WRITTEN BY: Jerome Bustarde
        METHOD DESCRIPTION: Returns the product of a fraction and another fraction
        PARAMETERS:
                        1. Fraction other
        METHOD ALGORITHM:
                        1. Create a new object to hold Fraction object
                        2. Initialize variable num to hold product of the two numerator
                        3. Initialize variable den to hold product of the two denominator
                        4. Invoke the setNumerator method to set the value of the product of the numerator
                            to the numerator of variable product
                        5. Invoke the setDenominator method to set the value of the product of the denominator
                            to the denominator of variable product
                        6. Return the fraction product
     */
    public Fraction multiply(Fraction other) {
        Fraction product = new Fraction();
        int num = numerator * other.getNumerator();
        int den = denominator * other.getDenominator();
        product.setNumerator(num);
        product.setDenominator(den);
        //product.reduce();
        return product;
    }

    /*
        METHOD NAME: divide
        WRITTEN BY: Jonah Andre De Guzman
        METHOD DESCRIPTION: Returns the quotient of a fraction and another fraction
        PARAMETERS:
            1. Fraction other
        METHOD ALGORITHM:
            1. Create a new object to hold the resulting quotient
            2. Initialize a variable (newNum) representing the resulting quotient's numerator
            3. Initialize a variable (newDen) representing the resulting quotient's denominator
            4. Invoke the setNumerator method to set the value of newNum to the value of the
                quotient fraction's numerator
            5. Invoke the setDenominator method to set the value of newDen to the value of
                the quotient fraction's denominator
            6. Return the resulting quotient fraction
    */
    public Fraction divide(Fraction other) {
        Fraction quotient = new Fraction();
        int newNum = numerator * other.getDenominator();
        int newDen = denominator * other.getNumerator();
        quotient.setNumerator(newNum);
        quotient.setDenominator(newDen);
        quotient.reduce();
        return quotient;
    }   // end of the divide method

    /*
        METHOD NAME: reciprocal ()
        WRITTEN BY: Kurt Matthew C. Nudo
        METHOD DESCRIPTION: Returns the reciprocal of a Fraction object
        PARAMETERS:
                            1. Fraction param - Receive the passed Fraction
                               instance. 
        METHOD ALGORITHM:
                            1. Create a new Fraction object (result)
                            2. Create an int variable to hold the old denominator
                               of this object 
                            3. Set the denominator of the result Fraction to the passed
                               Fraction instance's numerator (param)
                            4. Set the numerator of the result Fraction equal to the temporary int
                               variable that holds the old denominator variable of this object
                            5. Return the modified Fraction object (result)       
     */

    public Fraction reciprocal(Fraction param) {
        var result = new Fraction();
        int temporaryDenominator = getDenominator();
        result.setDenominator(param.getNumerator());
        result.setNumerator(temporaryDenominator);
        return result;
    }

    /*
        METHOD NAME: fractionToDecimal
        WRITTEN BY: Enrico P. Castro
        METHOD DESCRIPTION: Returns the value of a converted fraction into its decimal form
        PARAMETERS:
                            1. N/A
        METHOD ALGORITHM:
                            1. Create new object to hold decimal object
                            2. Call toDouble method
                            3. Return decimal value
     */
    public String fractionToDecimal() {
        Fraction decimal = new Fraction(numerator, denominator);
        String fToD = "" + decimal.toDouble();
        return fToD;
    }

    /*
        METHOD NAME: compareFraction
        WRITTEN BY: EUGENE JUSTIN G. PANGWI
        METHOD DESCRIPTION: Compares the two fractions and determines whether one of which
                            is greater,lesser or equal to the other.
        PARAMETERS:         
                            1. Fraction other - Receives the fractions
        METHOD ALGORITHM:
                            1. Creates placeholder for the fractions 
                            2. Compares the fractions by cross multiplying the 
                               fractions then subtracting (comparison = a*d - c*b).
                            3. If comparison is, 
                              3.a Equal to 0 then return a statement saying a/b = c/d.
                              3.b Greater than 0 then return a statement saying a/b > c/d.
                              3.c Lesser than 0 then return a statement saying a/b < c/d.
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
     * Reduces this fraction to its simplest form
     */
    public void reduce() {
        int gcd = computeGCD(numerator, denominator); // determine the greatest common divisor of numerator and denominator
        int newNumerator = numerator / gcd; //compute newNumerator, the numerator of the simplest form of this fraction
        int newDenominator = denominator / gcd; //compute newDenominator, the denominator of the simplest form of this fraction
        setNumerator(newNumerator); // set the value of the new numerator for this fraction
        setDenominator(newDenominator); // set the value of the new denominator for this fraction
    }

    /* Instructions: Provide implementation for the declared method below (computeGCD).
                   : Provide implementations of the other operations pertaining to the abstraction of a fraction.
                     Note that the first operation (add) has been provided above in which case you no longer have to
                     define this operation.
                   : Place all your answers below this comment.

        METHOD NAME: computeGCD
        WRITTEN BY: Jerome Bustarde
        METHOD DESCRIPTION: Computes the greatest common divisor of the numerator and denominator
         
        PARAMATERS: 
                1. int numerator, int denominator - receive values assigned to data members numerator & denominator
        METHOD ALGORITHM: (derived from Euclid's Algorithm)
                1. Provide for GCD
                2. Use an If statement to check if the condition that the denominator data member isn't assigned w/ a 0.
                3. Enclose the following instructions in a do statement
                3. Assign the modulo of the values assigned to the data members numerator and denominator to int GCD.
                4. Assign denominator to numerator and GCD to denominator
                5. Close the do statement with the while condition that the modulo of the values assign to the data members
                   numerator and denominator
     */
    private int computeGCD(int num, int den){
        int rem = 1;
        while (rem != 0) {
            rem = den % num;
            den = num;
            num = rem;
        }
        return den;
    }

    /*
        METHOD NAME: computeLCM
        WRITTEN BY: Jeanne Adeline S. Ferrer

        METHOD DESCRIPTION: Returns the LCM (least common multiplier) of two denominators
        PARAMETERS:
                    1. First denominator
                    2. Second denominator
        METHOD ALGORITHM:
                    1. Set the initial LCM as the greater number of the two given denominators
                    2. While true
                        If LCM mod d1 AND LCM mod d2 both equal to 0,
                            Break the while loop
                        Else
                            Increment LCM
                    3. Return the LCM
     */
    private int computeLCM(int d1, int d2) {
        int lcm = Math.max(d1, d2);

        while (true) {
            if (lcm % d1 == 0 && lcm % d2 == 0)
                break;
            ++lcm;
        }

        return lcm;
    }
}

