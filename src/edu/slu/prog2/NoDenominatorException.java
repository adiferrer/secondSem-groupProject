package edu.slu.prog2;

/**
 * The NoDenominatorException class <br>
 * Exception for when the user doesn't input a denominator
 */
public class NoDenominatorException extends RuntimeException {
    public NoDenominatorException() {
        System.out.println("Denominator automatically set to 1.");
    }
}