package com.company;



public class TerminalImpl implements ITerminal  {
    private final TerminalServer server = new TerminalServer ();
    private final PinValidator pinValidator = new PinValidator ();

    public void inputPinCode(int [] code) {

    }

}
