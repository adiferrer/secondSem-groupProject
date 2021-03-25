package edu.slu.prog2;

/**
 * The NoNumeratorException class <br>
 * Exception for when the user doesn't input a numerator
 */
public class NoNumeratorException extends RuntimeException {
    public NoNumeratorException() {
        System.out.println("Fraction part set to 0/1." );
    }
}
