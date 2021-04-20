package com.company;

import java.util.Date;

/**
 * Exception throws when users account is locked. To avoid this try to write pin correctly.
 */
public class AccountIsLockedException extends Exception {
    public AccountIsLockedException ( String message, long timeToUnlock ) {
        super(message + "До разблокировки: " + timeToUnlock + " сек.");
    }
}