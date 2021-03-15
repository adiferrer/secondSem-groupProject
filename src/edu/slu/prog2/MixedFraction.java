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
    private int wholePart; // holds the whole number of a mixed fraction

    /**
     * Constructs a mixed fraction with numerator = 0 and denominator = 1. <br>
     * by Jerome Bustarde <br>
     * <p>
     * This constructor allows a Mixed Fraction with an equivalent numeric value of zero to
     * be created <br>
     * This becomes the default constructor (since it has no arguments) <br>
     * Example of usage: MixedFraction mFraction = new MixedFraction();
     */
    public MixedFraction() {
        super();
    }

    /**
     * This constructor creates a Mixed Fraction with a specified whole number as its initial value. <br>
     * by Jerome Bustarde <br>
     * Example of usage: MixedFraction mFraction = new MixedFraction(); <br>
     *
     * @param wholeNumber receives the whole number part for the Mixed Fraction
     * @param fraction    receives the Fraction part for the Mixed Fraction
     */
    public MixedFraction(int wholeNumber, Fraction fraction) {
        setNumerator(fraction.getNumerator());
        setDenominator(fraction.getDenominator());
        this.wholePart = wholeNumber;
    }

    /**
     * by Jerome Bustarde
     *
     * @param wholeNumber receives the whole number for the Mixed Fraction
     * @param num         receives the numerator for the Mixed Fraction
     * @param den         receives the denominator for the Mixed Fraction
     */
    public MixedFraction(int wholeNumber, int num, int den) {
        this.wholePart = wholeNumber;
        super.setNumerator(num);
        super.setDenominator(den);
    }

    /**
     * Constructor that receives a given Fraction. <br>
     * Sets the numerator of a Mixed Fraction to a given numerator of a Fraction <br>
     * Sets the denominator of a Mixed Fraction to a given denominator of a Fraction <br>
     *
     * @param fraction receives a given Fraction
     */
    public MixedFraction(Fraction fraction) {
        fraction.setNumerator(fraction.getNumerator());
        fraction.setDenominator(fraction.getDenominator());
    }

    /**
     * Mutuator/Setter Method. <br>
     * by Eugene Justin Pangwi
     *
     * @param wholeNumber sets a number to the whole part of a Mixed Fraction
     */
    public void setWholePart(int wholeNumber) {
        this.wholePart = wholeNumber;
    }

    /**
     * Mutuator/Setter Method. <br>
     * by Eugene Justin Pangwi <br>
     *
     * @param fraction receives a given Fraction
     */
    public void setFractionPart(Fraction fraction) {
        int den = fraction.getDenominator();
        int num = fraction.getNumerator();
        fraction.setNumerator(num);
        fraction.setDenominator(den);
    }

    /**
     * Accessor/Getter Method. <br>
     * by Eugene Justin Pangwi
     *
     * @return wholeNumber of a MixedFraction
     */
    public int getWholePart() {
        return wholePart;
    }

    /**
     * Accessor/Getter Method. <br>
     * by Eugene Justin Pangwi <br>
     * 1. It uses getNumerator and getDenominator through a constructed object
     * of mixed fraction to get both the numerator and denominator of
     * Mixed Fraction. <br>
     *
     * @return a fraction object
     */
    public Fraction getFractionPart() {
        Fraction fraction = new Fraction();
        fraction.getNumerator();
        fraction.getDenominator();
        return fraction;
    }

    /**
     * Converts a mixed fraction to an improper fraction. <br>
     * by Jomari Ocampo  <br>
     * ex. 3 1/2 converts to 7/2 <br>
     */
    public void toFraction() {
        setNumerator(getWholePart() * getDenominator() + getNumerator());
        setDenominator(getDenominator());
        setWholePart(0);
    }

    /**
     * Converts an improper fraction to a mixed fraction. <br>
     * ex. 5/3 converts to 1 2/3
     */
    public void toMixedFraction() {
        setWholePart(getNumerator() / getDenominator());
        setNumerator(getNumerator() % getDenominator());
    }

    /**
     * Adds two Mixed Fractions and overrides the add method of Fraction. <br>
     * by Kurt Matthew C. Nudo <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new MixedFraction object to hold this object's improper fraction form <br>
     * 2. Create a new MixedFraction object to hold the sum <br>
     * 2. If both denominators are equal, <br>
     * Set denominator equal to the denominator of the first fraction then <br>
     * Add numerators of the current object instance and the passed Fraction parameter <br>
     * Else, compute the LCM of the denominators, <br>
     * Set denominator to the LCM,<br>
     * And Compute for the sum of the MixedFraction instance and the passed
     * Fraction parameter <br>
     * 3. Set numerator of the resulting MixedFraction object <br>
     * 4. Set denominator of the resulting MixedFraction object <br>
     * 5. Convert the sum to mixed fraction form <br>
     * 7. Reduce the fraction to lowest terms <br>
     * 8. Return the resulting Fraction <br><br>
     *
     * @param param receives the passed Fraction instance.
     * @return the sum of a MixedFraction object and a Fraction object
     */
    public MixedFraction add(Fraction param) {
        var sum = new MixedFraction();
        int den, num;
        toFraction();
        if (getDenominator() == param.getDenominator()) {
            den = getDenominator();
            num = getNumerator() + param.getDenominator();
        } else {
            den = computeLCM(getDenominator(), param.getDenominator());
            num = den / getDenominator() * getNumerator()
                    + den / param.getDenominator() * param.getDenominator();
        }
        toMixedFraction();
        sum.setNumerator(num);
        sum.setDenominator(den);
        sum.reduce();
        sum.toMixedFraction();

        return sum;
    }

    /**
     * Adds two Mixed Fractions and overloads the add method of Fraction. <br>
     * by Kurt Matthew C. Nudo <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new MixedFraction object to hold this object's improper fraction form <br>
     * 2. Create a new MixedFraction object to hold the sum<br>
     * 3. If both denominators are equal,
     * Set denominator equal to the denominator of the first fraction then <br>
     * Add numerators of the current object instance and the passed Fraction parameter <br>
     * Else, Compute the LCM of the denominators, <br>
     * Set denominator to the LCM <br>
     * Compute for the sum of the MixedFraction instance and the passed
     * Fraction parameter <br>
     * 4. Set the whole number of the resulting MixedFraction instance
     * equal to the sum of the passed MixedFraction parameter's wholeNumber
     * and this MixedFraction object's wholeNumber <br>
     * 5. Set numerator of the resulting MixedFraction object <br>
     * 6. Set denominator of the resulting MixedFraction object <br>
     * 7. Convert the sum into Mixed fraction form <br>
     * 8. Reduce the sum object to the lowest terms <br>
     * 7. Return the resulting MixedFraction <br><br>
     *
     * @param param receives the passed MixedFraction instance.
     * @return the sum of two MixedFraction objects
     */
    public MixedFraction add(MixedFraction param) {
        var sum = new MixedFraction();
        int den, num;
        toFraction();
        param.toFraction();
        if (getDenominator() == param.getDenominator()) {
            den = getDenominator();
            num = getNumerator() + param.getNumerator();
        } else {
            den = computeLCM(getDenominator(), param.getDenominator());
            num = den / getDenominator() * getNumerator()
                    + den / param.getDenominator() * param.getNumerator();
        }
        toMixedFraction();
        param.toMixedFraction();
        sum.setWholePart(this.getWholePart() + param.getWholePart());
        sum.setNumerator(num);
        sum.setDenominator(den);
        sum.reduce();
        sum.toMixedFraction();

        return sum;
    }

    /**
     * Computes for the difference of two Fractions and overrides subtract method. <br>
     * by Enrico Castro <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Convert this mixed fraction to an equivalent improper fraction <br>
     * 2. Subtract the improper fraction to the other fraction <br>
     * 3. Convert the result of step b to a mixed fraction form <br>
     * 4. Return the result of step c <br><br>
     *
     * @param param other Fraction to subtract
     * @return the difference of this Mixed Fraction and another Fraction
     */
    public MixedFraction subtract(Fraction param) {
        var subtract = new MixedFraction();
        int den, num;
        toFraction();
        if (getDenominator() == param.getDenominator()) {
            den = getDenominator();
            num = getNumerator() + param.getDenominator();
        } else {
            den = computeLCM(getDenominator(), param.getDenominator());
            num = den / getDenominator() * getNumerator()
                    - den / param.getDenominator() * param.getDenominator();
        }
        toMixedFraction();
        subtract.setNumerator(num);
        subtract.setDenominator(den);
        subtract.reduce();
        subtract.toMixedFraction();

        return subtract;
    }

    /**
     * Computes for the difference of two Fractions and overloads subtract method. <br>
     * by Enrico Castro <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Convert this mixed fraction to an equivalent improper fraction(first) <br>
     * 2. Convert the other mixed fraction to an equivalent improper fraction(second) <br>
     * 3. Subtract the two resulting fractions from steps a and b <br>
     * 4. Convert the result of step c to a mixed fraction form <br>
     * 5. Return the result of step d <br><br>
     *
     * @param param receives a Mixed Fraction to subtract
     * @return the difference of two Mixed Fractions
     */
    public MixedFraction subtract(MixedFraction param) {
        var subtract = new MixedFraction();
        int den, num;
        toFraction();
        param.toFraction();
        if (getDenominator() == param.getDenominator()) {
            den = getDenominator();
            num = getNumerator() - param.getNumerator();
        } else {
            den = computeLCM(getDenominator(), param.getDenominator());
            num = den / getDenominator() * getNumerator()
                    - den / param.getDenominator() * param.getNumerator();
        }
        toMixedFraction();
        subtract.setNumerator(num);
        subtract.setDenominator(den);
        subtract.reduce();
        subtract.toMixedFraction();

        return subtract;
    }

    /**
     * Computes the product of a Mixed Fraction and another Fraction, and overrides multiplyBy method. <br>
     * by Jerome Bustarde <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new object to hold Mixed Fraction object. <br>
     * 2. Initialize variable num to hold product of the two numerator. <br>
     * 3. Initialize variable den to hold product of the two denominator. <br>
     * 4. Invoke the setNumerator method to set the value of the product of the numerator
     * to the numerator of variable product. <br>
     * 5. Invoke the setDenominator method to set the value of the product of the denominator
     * to the denominator of variable product. <br>
     * 6. Return the Fraction product. <br><br>
     *
     * @param param other Fraction to multiply with
     * @return the product of a Mixed Fraction and another Fraction
     */
    public MixedFraction multiplyBy(Fraction param) {
        var product = new MixedFraction();
        int num = getNumerator() * param.getNumerator();
        int den = getDenominator() * param.getDenominator();
        product.setNumerator(num);
        product.setDenominator(den);
        product.reduce();
        return product;
    }

    /**
     * Computes the product of two Mixed Fractions and overloads multiplyBy method. <br>
     * by Jerome Bustarde <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new object to hold Mixed Fraction object. <br>
     * 2. Initialize variable num, den, wN, num2, den2, wN2 to hold numerator, denominator and whole number
     * of the 2 mixed fraction. <br>
     * 3. Convert the mixed fractions to improper fractions <br>
     * 4. Compute for the product of the 2 improper fractions <br>
     * 5. Convert the product to a mixed fraction <br>
     * 6. Return the Mixed Fraction product <br>
     *
     * @param param other Mixed Fraction to multiply with
     * @return the product of two Mixed Fractions
     */
    public MixedFraction multiplyBy(MixedFraction param) {
        var product = new MixedFraction();
        int num, den, wN, num2, den2, wN2;
        wN = getWholePart();
        num = getNumerator();
        den = getDenominator();
        num = (wN * den) + num;
        wN2 = param.getWholePart();
        num2 = param.getNumerator();
        den2 = param.getDenominator();
        num2 = (wN2 * den2) + num2;
        num = num * num2;
        den = den * den2;
        wN = num / den;
        num = num % den;
        product.setWholePart(wN);
        product.setNumerator(num);
        product.setDenominator(den);
        product.reduce();
        return product;
    }

    /**
     * Computes for the quotient of a Mixed Fraction and other Fraction, and overrides divideBy method. <br>
     * by Andre De Guzman <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new object to hold Mixed Fraction object. <br>
     * 2. Initialize variables. <br>
     * 3. Convert the mixed fractions to improper fractions. <br>
     * 4. Compute for the quotient of the 2 improper fractions. <br>
     * 5. Convert the quotient to a mixed fraction. <br>
     * 6. Return the Mixed Fraction product <br>
     *
     * @param param other Fraction to divide by
     * @return the quotient of a Mixed Fraction and another Fraction
     */
    public MixedFraction divideBy(Fraction param) {
        var quotient = new MixedFraction();

        // numerator into improper
        int num = (getDenominator() * getWholePart()) + getNumerator();
        int den;
        int whole;

        // dividing two fractions
        num = num * param.getDenominator();
        den = getDenominator() * param.getNumerator();

        // into mixed fraction
        whole = num / den;
        num = num % den;

        quotient.setNumerator(num);
        quotient.setDenominator(den);
        quotient.setWholePart(whole);
        quotient.reduce();

        return quotient;
    }   // end of the divideBy method

    /**
     * Computes for the quotient of two Mixed Fractions and overloads divideBy method. <br>
     * by Andre De Guzman <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new object to hold Mixed Fraction object. <br>
     * 2. Initialize variables. <br>
     * 3. Convert the mixed fractions to improper fractions. <br>
     * 4. Compute for the quotient of the 2 improper fractions. <br>
     * 5. Convert the quotient to a mixed fraction. <br>
     * 6. Return the Mixed Fraction product <br>
     *
     * @param param other Mixed Fraction to divide by
     * @return the quotient of two Mixed Fractions
     */
    public MixedFraction divideBy(MixedFraction param) {
        var quotient = new MixedFraction();

        // numerators into improper
        int num = (getWholePart() * getDenominator()) + getNumerator();
        int otherNum = (param.getWholePart() * param.getDenominator()) + getNumerator();
        int den;
        int whole;

        // dividing the two fractions
        num = num * param.getDenominator();
        den = getDenominator() * otherNum;

        // into mixed fraction
        if (den != 0) {
            whole = num / den;
            num = num % den;
            quotient.setNumerator(num);
            quotient.setDenominator(den);
            quotient.setWholePart(whole);
            quotient.reduce();
        }

        return quotient;
    }   // end of the divideBy method

    /**
     * Overrides toString method. <br>
     * by Andre De Guzman <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. If whole part of Mixed Fraction is equal to 0,
     * display the numerator over denominator only. <br>
     * 2. If denominator of Mixed Fraction is equal to 1,
     * add the whole part of Mixed Fraction to the numerator of Mixed Fraction,
     * then display the result. <br>
     * 3. Else,
     * display the Mixed Fraction in the form of "wholePart numerator/denominator." <br><br>
     *
     * @return a string containing the mixed fraction
     */
    public String toString() {
        if (getWholePart() == 0) {
            // from "0 1/2" to "1/2"
            return (getNumerator() + "/" + getDenominator());
        }
        if (getDenominator() == 1) {
            // from "1 2/1" to "3"
            return ("" + (getWholePart() + getNumerator()));
        } else {
            // from "1 1/2" to "1 1/2"
            return (getWholePart() + " " + getNumerator() + "/" + getDenominator());
        }
    }   // end of the toString method

    /**
     * @return the decimal value of this mixed number. <br>
     * by Kurt Nudo
     */
    public double toDouble() {
        return (wholePart + 1.0 * getNumerator() / getDenominator());
    }

    /**
     * Returns the reciprocal of a Mixed Fraction object. <br>
     * by Jeanne Ferrer <br><br>
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Create a new Mixed Fraction object (result). <br>
     * 2. Create an int variable to hold the old denominator
     * of this object. <br>
     * 3. Set the denominator of the result Mixed Fraction to the passed
     * Mixed Fraction instance's numerator (param). <br>
     * 4. Set the numerator of the result Mixed  Fraction equal to the temporary int
     * variable that holds the old denominator variable of this object. <br>
     * 5. Return the modified Mixed Fraction object (result). <br><br>
     *
     * @param param receives the passed Mixed Fraction instance.
     * @return the reciprocal of a Mixed Fraction object
     */
    public MixedFraction reciprocal(MixedFraction param) {
        var result = new MixedFraction();
        int temporaryDenominator = getDenominator();
        result.setDenominator(param.getNumerator());
        result.setNumerator(temporaryDenominator);
        return result;
    }
}
