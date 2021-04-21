package com.company;

/**
 * Exception throws when user is not authorized and wants to use terminal.
 * To avoid this exception authorize to terminal.
 */
public class IsNotAuthorizedExeption extends Exception{
    public IsNotAuthorizedExeption ( String message ) {
        super(message);
    }
}
