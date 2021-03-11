package edu.slu.prog2;

/**
 * The MixedFraction class is a template for a fraction that has the form wholeNumber numerator/denominator.
 *
 * @author Jerome Bustarde
 * @author Enrico Castro
 * @author Andre De Guzman
 * @author Jeanne Ferrer
 * @author Kurt Nudo
 * @author Jomari Ocampo
 * @author Eugene Pangwi
 * @version 1.0
 */
public class MixedFraction extends Fraction {
    // object field
    private int wholeNumber; // holds the whole number of a mixed fraction

    /**
     * Constructs a mixed fraction with numerator = 0 and denominator = 1. <br>
     * by Jerome Bustarde <br>
     * <p>
     * This constructor allows a Mixed Fraction with an equivalent numeric value of zero to
     * be created <br>
     * This becomes the default constructor (since it has no arguments) <br>
     * Example of usage: MixedFraction mFraction = new MixedFraction();
     */
    MixedFraction() {
        super();
    }

    /**
     * This constructor creates a Mixed Fraction with a specified whole number as its initial value. <br>
     * by Jerome Bustarde <br>
     * <p>
     * <br>
     * Example of usage: MixedFraction mFraction = new MixedFraction();
     */
    MixedFraction(int wholeNumber, Fraction fraction) {
        super(fraction.getNumerator(), fraction.getDenominator());
        this.wholeNumber = wholeNumber;
    }

    /**
     * by Jerome Bustarde
     */
    MixedFraction(int wholeNumber, int num, int den) {
        this.wholeNumber = wholeNumber;
        super.setNumerator(num);
        super.setDenominator(den);
    }

    /*
    by Jerome Bustarde
     */
   /* MixedFraction(Fraction fraction) {
        super(fraction.setNumerator());
    }*/

    // Accessor Methods
    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }

    public int getWholeNumber() {
        return wholeNumber;
    }

    /**
     * Adds two Mixed Fractions and overwrites the add method of Fraction. <br>
     * by Kurt Matthew C. Nudo <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * Create a new Fraction object to hold the resulting MixedFraction <br>
     * If both denominators are equal, <br>
     * Set denominator equal to the denominator of the first fraction
     * Add numerators of the current object instance and the passed Fraction parameter
     * Else
     * Compute the LCM of the denominators
     * Set denominator to the LCM
     * Compute for the sum of the MixedFraction instance and the passed
     * Fraction parameter
     * 3. Set numerator of the resulting MixedFraction object
     * 4. Set denominator of the resulting MixedFraction object
     * 5. Return the resulting Fraction
     *
     * @param param receives the passed Fraction instance.
     * @return the sum of a MixedFraction object and a Fraction object
     */

    public MixedFraction add(Fraction param) {
        var sum = new MixedFraction();
        int den, num;
        if (getDenominator() == param.getDenominator()) {
            den = getDenominator();
            num = getNumerator() + param.getDenominator();
        } else {
            den = computeLCM(getDenominator(), param.getDenominator());
            num = den / getDenominator() * getNumerator()
                    + den / param.getDenominator() * param.getDenominator();
        }
        sum.setNumerator(num);
        sum.setDenominator(den);
        sum.reduce();

        return sum;
    }

    /**
     * METHOD NAME: add ()
     * WRITTEN BY: Kurt Matthew C. Nudo
     * METHOD DESCRIPTION: Returns the sum of two MixedFraction objects
     * PARAMETERS:
     * 1. Fraction param - Receive the passed MixedFraction
     * instance.
     * METHOD ALGORITHM:
     * 1. Create a new Fraction object to hold the resulting MixedFraction
     * 2. If both denominators are equal,
     * Set denominator equal to the denominator of the first fraction
     * Add numerators of the current object instance and the passed Fraction parameter
     * Else
     * Compute the LCM of the denominators
     * Set denominator to the LCM
     * Compute for the sum of the MixedFraction instance and the passed
     * Fraction parameter
     * 3. Set the whole number of the resulting MixedFraction instance
     * equal to the sum of the passed MixedFraction paramater's wholeNumber
     * and this MixedFraction object's wholeNumber
     * 4. Set numerator of the resulting MixedFraction object
     * 5. Set denominator of the resulting MixedFraction object
     * 6. Return the resulting Fraction
     */
    public MixedFraction add(MixedFraction param) {
        var sum = new MixedFraction();
        int den, num;

        if (getDenominator() == param.getDenominator()) {
            den = getDenominator();
            num = getNumerator() + param.getNumerator();
        } else {
            den = computeLCM(getDenominator(), param.getDenominator());
            num = den / getDenominator() * getNumerator()
                    + den / param.getDenominator() * param.getNumerator();
        }

        sum.setWholeNumber(this.getWholeNumber() + param.getWholeNumber());
        sum.setNumerator(num);
        sum.setDenominator(den);
        sum.reduce();
        return sum;
    }

    public MixedFraction subtract(MixedFraction param) {
        var diff = new MixedFraction();
        int den, num;

        if (getDenominator() == param.getDenominator()) {
            den = getDenominator();
            num = getNumerator() - param.getNumerator();
        } else {
            den = computeLCM(getDenominator(), param.getDenominator());
            num = den / getDenominator() * getNumerator()
                    - den / param.getDenominator() * param.getNumerator();
        }

        diff.setWholeNumber(this.getWholeNumber() - param.getWholeNumber());
        diff.setNumerator(num);
        diff.setDenominator(den);
        diff.reduce();
        return diff;
    }

    /*public MixedFraction multiplyBy(MixedFraction param) {
        var product = new MixedFraction();
        int num, den, wN;
        wN = param.getWholeNumber();
        num = param.getNumerator();
        den = param.getDenominator();

    }*/

    /**
     * Returns the equivalent value of the fraction in double format
     */
    public double toDouble() {
        return this.getWholeNumber() + ((double) this.getNumerator() / this.getDenominator());
    }

    /**
     *
     */
    //public MixedFraction divideBy(Fraction param) {
    // temporary notes for me, please ignore thanks
    // override

    //}

    /**
     *
     */
    //public MixedFraction divideBy(MixedFraction param) {
    // temporary notes for me, please ignore thanks
    // overload

    //}

    /**
     *
     */
    public String toString() {
        // temporary notes for me, please ignore thanks
        // A    1 1/2
        // B    0 1/2 -> 1/2
        // C    2 0/1 -> 2

        if (wholeNumber == 0) {
            return (this.getNumerator() + "/" + this.getDenominator());
        }
        if (this.getDenominator() == 1) {
            return (wholeNumber + " ");
        } else {
            return (wholeNumber + " " + this.getNumerator() + "/" + this.getDenominator());
        }
    }

    /**
     * Converts a mixed fraction to an improper fraction.
     * ex. 3 1/2 convert to 7/2
     */
    public MixedFraction toFraction(MixedFraction p) {

        int mFractionNum = p.getWholeNumber() * p.getDenominator() + p.getNumerator();
        p.setNumerator(mFractionNum);
        p.setDenominator(p.getDenominator());
        p.setWholeNumber(0);

        return p;

    }
}
