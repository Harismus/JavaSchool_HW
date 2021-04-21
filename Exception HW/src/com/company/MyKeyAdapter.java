package com.company;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyKeyAdapter extends KeyAdapter {

    private java.util.Timer times = new Timer();
    private JTextArea textArea;
    private JLabel label;
    private ITerminal terminal = new TerminalImpl();
    private int MAX_LENGTH;

    MyKeyAdapter(JTextArea textArea, JLabel label, int MAX_LENGTH) {
        this.textArea = textArea;
        this.label = label;
        this.MAX_LENGTH = MAX_LENGTH;
    }



    public void keyReleased(KeyEvent e) {

        try {
            System.out.println( "terminal.isAuthorized() = " + terminal.isAuthorized() );
            if (!terminal.isAuthorized()) { //!< пока не вошли в аккаунт
                String text = textArea.getText();

                if (!DigitValidator.isMatch(text)) {//
                    label.setText( "Warning: you must press just numbers." );

                    times.schedule( WrapTimerTask.wrap( () -> label.setText( "Press pin-code:" ) ), 3000 );

                    textArea.setText( "" );

                    for (int i = 0; i < text.length(); ++i) {
                        if (!Character.isAlphabetic( text.charAt( i ) ))
                            textArea.append( String.valueOf( text.charAt( i ) ) );
                    }
                    return;

                } else if (text.length() == MAX_LENGTH) {

                    int pinCode = Integer.parseInt( text );

                    if (terminal.inputPinCode( pinCode ) == true) {
                        textArea.setText( "" );
                        label.setText( "Entering to account... Please Wait..." );

                        times.schedule( WrapTimerTask.wrap( () -> {
                            label.setText( "Select a command:" );
                            textArea.setEditable( false );
                            textArea.setText(
                                    "1. Withdraw money\n" +
                                    "2. Deposit money\n" +
                                    "3. Check account\n" +
                                    "---------------\n" +
                                    "4. Exit\n"
                                  );

                        } ), 3000 );
                    }
                }
            } else { //!< если вошли в аккаунт

                int key = Integer.parseInt( String.valueOf( e.getKeyChar() ) );
               
                switch (key) {
                    case 1: {

                        break;
                    }
                    case 2: {

                        break;
                    }
                    case 3: {
                        String countMoney = String.valueOf( terminal.checkAccount() );
                        System.out.println( "countMoney = " + countMoney );
                        textArea.setText( "Amount of money left: " + countMoney + "" );
                        break;
                    }
                    case 4: {
                        terminal.exitFromAccount();
                        label.setText( "Exit from Account. Please Wait..." );

                        times.schedule( WrapTimerTask.wrap( () -> label.setText( "Press pin-code:" ) ), 3000 );

                        textArea.setText( "" );
                        textArea.setEditable( true );
                        break;
                    }
                }

            }

        } catch (IncorrectPinExceprion incorrectPinExceprion) {
            label.setText( incorrectPinExceprion.getMessage() );
        } catch (AccountIsLockedException accountIsLockedException) {
            System.out.println( "accountIsLockedException.getMessage() = " + accountIsLockedException.getMessage() );
            label.setText( accountIsLockedException.getMessage() );
        } catch (IsNotAuthorizedExeption isNotAuthorizedExeption) {
            isNotAuthorizedExeption.getMessage();
            label.setText( isNotAuthorizedExeption.getMessage() );
        }
    }
}