package com.company;

public interface ITerminal {
    void inputPinCode(int code) throws IncorrectPinExceprion, AccountIsLockedException;
}
