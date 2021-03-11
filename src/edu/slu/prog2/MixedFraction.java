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

    /**
     * Mutuator/Setter Method <br>
     * by Eugene Justin Pangwi
     *
     * @param wholeNumber sets a number to the whole part of a Mixed Fraction
     */
    public void setWholePart(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }

    // setFractionPart by Eugene Justin Pangwi

    /**
     * Accessor/Getter Method <br>
     * by Eugene Justin Pangwi
     *
     * @return wholeNumber of a MixedFraction
     */
    public int getWholePart() {
        return wholeNumber;
    }

    // getFractionPart by Eugene Justin Pangwi

    /**
     * Converts a mixed fraction to an improper fraction. <br>
     * by Jomari Ocampo  <br>
     * ex. 3 1/2 convert to 7/2 <br>
     *
     * @param p receives a Mixed Fraction
     * @return an improper Fraction
     */
    public MixedFraction toFraction(MixedFraction p) {
        int mFractionNum = p.getWholePart() * p.getDenominator() + p.getNumerator();
        p.setNumerator(mFractionNum);
        p.setDenominator(p.getDenominator());
        p.setWholePart(0);
        return p;
    }

    /**
     * Adds two Mixed Fractions and overwrites the add method of Fraction. <br>
     * by Kurt Matthew C. Nudo <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new Fraction object to hold the resulting MixedFraction <br>
     * 2. If both denominators are equal, <br>
     * Set denominator equal to the denominator of the first fraction then <br>
     * Add numerators of the current object instance and the passed Fraction parameter <br>
     * Else, compute the LCM of the denominators, <br>
     * Set denominator to the LCM,<br>
     * And Compute for the sum of the MixedFraction instance and the passed
     * Fraction parameter <br>
     * 3. Set numerator of the resulting MixedFraction object <br>
     * 4. Set denominator of the resulting MixedFraction object <br>
     * 5. Return the resulting Fraction <br><br>
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
     * Adds two Mixed Fractions and overwrites the add method of Fraction. <br>
     * by Kurt Matthew C. Nudo <br><br>
     *
     * METHOD ALGORITHM: <br>
     * 1. Create a new Fraction object to hold the resulting MixedFraction <br>
     * 2. If both denominators are equal,
     * Set denominator equal to the denominator of the first fraction then <br>
     * Add numerators of the current object instance and the passed Fraction parameter <br>
     * Else, Compute the LCM of the denominators, <br>
     * Set denominator to the LCM <br>
     * Compute for the sum of the MixedFraction instance and the passed
     * Fraction parameter <br>
     * 3. Set the whole number of the resulting MixedFraction instance
     * equal to the sum of the passed MixedFraction parameter's wholeNumber
     * and this MixedFraction object's wholeNumber <br>
     * 4. Set numerator of the resulting MixedFraction object <br>
     * 5. Set denominator of the resulting MixedFraction object <br>
     * 6. Return the resulting Fraction <br><br>
     *
     * @param param receives the passed MixedFraction instance.
     * @return the sum of two MixedFraction objects
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

        sum.setWholePart(this.getWholePart() + param.getWholePart());
        sum.setNumerator(num);
        sum.setDenominator(den);
        sum.reduce();
        return sum;
    }

    // overwrite subtract method

    /**
     * Overload subtract method <br>
     * by Enrico Castro <br>
     *
     * @param param receives a Mixed Fraction to subtract
     * @return the difference of two Mixed Fractions
     */
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

        diff.setWholePart(this.getWholePart() - param.getWholePart());
        diff.setNumerator(num);
        diff.setDenominator(den);
        diff.reduce();
        return diff;
    }

    // overwrite multiplyBy method by Jerome

    // overload multiplyBy method by Jerome
    /*public MixedFraction multiplyBy(MixedFraction param) {
        var product = new MixedFraction();
        int num, den, wN;
        wN = param.getWholeNumber();
        num = param.getNumerator();
        den = param.getDenominator();

    }*/

    // overwrite divideBy method by Andre
    //public MixedFraction divideBy(Fraction param) {
    // temporary notes for me, please ignore thanks
    // override

    //}

    // overload divideBy method by Andre
    //public MixedFraction divideBy(MixedFraction param) {
    // temporary notes for me, please ignore thanks
    // overload

    //}

    /**
     * Override toString method <br>
     * by Andre
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
     * Returns the equivalent value of the fraction in double format <br>
     * by Kurt Nudo
     */
    public double toDouble() {
        return this.getWholePart() + ((double) this.getNumerator() / this.getDenominator());
    }
}
