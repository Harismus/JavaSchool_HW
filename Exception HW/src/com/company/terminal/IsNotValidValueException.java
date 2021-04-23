package com.company.terminal;

/**
 * Exception throws when value to deposit or to withdraw is not multiple to 100.
 */
public class IsNotValidValueException extends Exception {
    public IsNotValidValueException ( String message ) {
        super(message);
    }
}
