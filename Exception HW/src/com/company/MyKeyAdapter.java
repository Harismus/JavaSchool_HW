package com.company;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class MyKeyAdapter extends KeyAdapter {

    private java.util.Timer times = new Timer();
    private JTextArea textArea;
    private JLabel label;
    private ITerminal terminal = new TerminalImpl();
    private int MAX_LENGTH;

    private enum MENU {
        AUTHORIZING,
        MAIN,
        WITHDRAW,
        DEPOSIT,
        LOADING
    }

    MENU menu = MENU.AUTHORIZING;

    MyKeyAdapter(JTextArea textArea, JLabel label, int MAX_LENGTH) {
        this.textArea = textArea;
        this.label = label;
        this.MAX_LENGTH = MAX_LENGTH;

    }

    public void keyReleased(KeyEvent e) {

        try {
            System.out.println( "terminal.isAuthorized() = " + terminal.isAuthorized() );
            if (menu == MENU.AUTHORIZING) { //!< пока не вошли в аккаунт
                String text = textArea.getText();

                if (!DigitValidator.isMatch( text )) {//
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
                        String countMoney = String.valueOf( terminal.checkAccount() );

                        times.schedule( WrapTimerTask.wrap( () -> {

                            label.setText( "Amount of money left: " + countMoney + "\n " );
                            textArea.setEditable( false );
                            textArea.setText(
                                    "Select a command:\n" +
                                            "1) Withdraw money\n" +
                                            "2) Deposit money\n" +

                                            "---------------\n" +
                                            "3) Exit\n"
                            );

                            menu = MENU.MAIN;

                        } ), 3000 );
                        menu = MENU.LOADING;
                    }
                }
            } else if (menu == MENU.MAIN) { //!< если вошли в аккаунт

                int key = Integer.parseInt( String.valueOf( e.getKeyChar() ) );

                switch (key) {
                    case 1: {
                        String countMoney = String.valueOf( terminal.checkAccount() );
                        label.setText( "Amount of money left: " + countMoney + " Type amount of money and Press enter: " );
                        menu = MENU.WITHDRAW;
                        textArea.setEditable( true );
                        textArea.setText( "" );
                        break;
                    }
                    case 2: {
                        String countMoney = String.valueOf( terminal.checkAccount() );
                        label.setText( "Amount of money left: " + countMoney + " Type amount of money and Press enter: " );
                        menu = MENU.DEPOSIT;
                        textArea.setEditable( true );
                        textArea.setText( "" );
                        break;
                    }
                    case 3: {
                        terminal.exitFromAccount();
                        label.setText( "Exit from Account. Please Wait..." );

                        times.schedule( WrapTimerTask.wrap( () ->
                                {
                                    label.setText( "Press pin-code:" );
                                    menu = MENU.AUTHORIZING;
                                }
                        ), 3000 );

                        textArea.setText( "" );
                        textArea.setEditable( true );
                        menu = MENU.LOADING;
                        break;
                    }
                }
            } else if (menu == MENU.WITHDRAW) {

                System.out.println( "e.getKeyCode() = " + e.getKeyCode() );
                if (e.getKeyCode() == 10) { //!< enter = 10
                    String text = textArea.getText().replaceAll( "\n", "" );

                    textArea.setText( text );

                    System.out.println( "text = " + text );

                    terminal.withdraw( Integer.parseInt( textArea.getText() ) );
                    String countMoney = String.valueOf( terminal.checkAccount() );
                    label.setText( "Amount of money left: " + countMoney + "\n " );
                } else if (e.getKeyCode() == 27) {

                    String countMoney = String.valueOf( terminal.checkAccount() );
                    label.setText( "Amount of money left: " + countMoney + "\n " );
                    textArea.setEditable( false );
                    textArea.setText(
                            "Select a command:\n" +
                                    "1) Withdraw money\n" +
                                    "2) Deposit money\n" +
                                    "---------------\n" +
                                    "3) Exit\n"
                    );

                    menu = MENU.MAIN;
                }

            } else if (menu == MENU.DEPOSIT) {

                System.out.println( "e.getKeyCode() = " + e.getKeyCode() );
                if (e.getKeyCode() == 10) { //!< enter = 10

                    String text = textArea.getText().replaceAll( "\n", "" );

                    textArea.setText( text );

                    System.out.println( "text = " + text );

                    terminal.deposit( Integer.parseInt( textArea.getText() ) );
                    String countMoney = String.valueOf( terminal.checkAccount() );
                    label.setText( "Amount of money left: " + countMoney + "\n " );
                } else if (e.getKeyCode() == 27) {
                    String countMoney = String.valueOf( terminal.checkAccount() );
                    label.setText( "Amount of money left: " + countMoney + "\n " );
                    textArea.setEditable( false );
                    textArea.setText(
                            "Select a command:\n" +
                                    "1) Withdraw money\n" +
                                    "2) Deposit money\n" +
                                    "---------------\n" +
                                    "3) Exit\n"
                    );

                    menu = MENU.MAIN;
                }
            }
        } catch (
                IncorrectPinExceprion incorrectPinExceprion) {
            label.setText( incorrectPinExceprion.getMessage() );
        } catch (
                AccountIsLockedException accountIsLockedException) {
            System.out.println( "accountIsLockedException.getMessage() = " + accountIsLockedException.getMessage() );
            label.setText( accountIsLockedException.getMessage() );
        } catch (
                IsNotAuthorizedExeption isNotAuthorizedExeption) {
            isNotAuthorizedExeption.getMessage();
            label.setText( isNotAuthorizedExeption.getMessage() );
        } catch (NotEnoughMoneyException notEnoughMoneyException) {
            notEnoughMoneyException.printStackTrace();
        } catch (IsNotValidValueException isNotValidValueException) {
            isNotValidValueException.printStackTrace();
        }
    }
}