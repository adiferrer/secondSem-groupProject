package edu.slu.prog2;

/**
 * The NoWholeNumberException class <br>
 * Exception for when the user doesn't input a whole number
 */
public class NoWholeNumberException extends RuntimeException{
    public NoWholeNumberException() {
        System.out.println("Whole number part automatically set to 0.");
    }
}
