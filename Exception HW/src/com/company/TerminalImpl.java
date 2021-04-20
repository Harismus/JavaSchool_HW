package com.company;


public class TerminalImpl implements ITerminal {
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();

    @Override
    public void inputPinCode(int pinCode) throws IncorrectPinExceprion, AccountIsLockedException {
        pinValidator.inputPinCode( pinCode );
    }
}
