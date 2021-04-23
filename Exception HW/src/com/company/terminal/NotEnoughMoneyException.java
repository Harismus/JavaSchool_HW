package com.company.terminal;

/**
 * Exception throws when there are less money on the account then user wants to withdraw.
 */
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException ( String message ) {
        super(message);
    }
}
