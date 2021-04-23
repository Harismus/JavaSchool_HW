package com.company.terminal;

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
            if (menu == MENU.AUTHORIZING) { //!< пока не вошли в аккаунт
                String text = textArea.getText();

                if (!DigitValidator.isMatch( text )) {//
                    label.setText( "Предупреждение: нужно вводить только числа." );

                    times.schedule( WrapTimerTask.wrap( () -> label.setText( "Введите пин-код:" ) ), 3000 );

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
                        label.setText( "Вход в аккаунт. Пожалуйста подождите..." );
                        String countMoney = String.valueOf( terminal.checkAccount() );

                        times.schedule( WrapTimerTask.wrap( () -> {

                            label.setText( "Сумма: " + countMoney + "\n " );
                            textArea.setEditable( false );
                            textArea.setText(
                                    "Введите номер команды:\n" +
                                            "1) Снять деньги\n" +
                                            "2) Положить деньги\n" +
                                            "---------------\n" +
                                            "3) Выход\n"
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
                        label.setText( "Введите сумму и нажмите enter. Для возврата в главное меню нажмите Esc "  + "\tСумма: " + countMoney  );
                        menu = MENU.WITHDRAW;
                        textArea.setEditable( true );
                        textArea.setText( "" );
                        break;
                    }
                    case 2: {
                        String countMoney = String.valueOf( terminal.checkAccount() );
                        label.setText( "Введите сумму и нажмите enter. Для возврата в главное меню нажмите Esc "  + "\tСумма: " + countMoney  );
                        menu = MENU.DEPOSIT;
                        textArea.setEditable( true );
                        textArea.setText( "" );
                        break;
                    }
                    case 3: {
                        terminal.exitFromAccount();
                        label.setText( "Выход из аккаунта. Пожалуйста ждите..." );

                        times.schedule( WrapTimerTask.wrap( () ->
                                {
                                    label.setText( "Введите пин-код:" );
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

                if (e.getKeyCode() == 10) { //!< enter = 10
                    String text = textArea.getText().replaceAll( "\n", "" );

                    textArea.setText( text );

                    System.out.println( "text = " + text );

                    terminal.withdraw( Integer.parseInt( textArea.getText() ) );
                    String countMoney = String.valueOf( terminal.checkAccount() );
                    label.setText( "Введите сумму и нажмите enter. Для возврата в главное меню нажмите Esc "  + "\tСумма: " + countMoney  );
                } else if (e.getKeyCode() == 27) {

                    String countMoney = String.valueOf( terminal.checkAccount() );
                    label.setText( "Сумма: " + countMoney + "\n " );
                    textArea.setEditable( false );
                    textArea.setText(
                            "Введите номер команды:\n" +
                                    "1) Снять деньги\n" +
                                    "2) Положить деньги\n" +
                                    "---------------\n" +
                                    "3) Выход\n"
                    );

                    menu = MENU.MAIN;
                }
            } else if (menu == MENU.DEPOSIT) {

                if (e.getKeyCode() == 10) { //!< enter = 10

                    String text = textArea.getText().replaceAll( "\n", "" );

                    textArea.setText( text );

                    System.out.println( "text = " + text );

                    terminal.deposit( Integer.parseInt( textArea.getText() ) );
                    String countMoney = String.valueOf( terminal.checkAccount() );
                    label.setText( "Введите сумму и нажмите enter. Для возврата в главное меню нажмите Esc "  + "\tСумма: " + countMoney  );
                } else if (e.getKeyCode() == 27) {
                    String countMoney = String.valueOf( terminal.checkAccount() );
                    label.setText( "Сумма: " + countMoney + "\n " );
                    textArea.setEditable( false );
                    textArea.setText(
                            "Введите номер команды:\n" +
                                    "1) Снять деньги\n" +
                                    "2) Положить деньги\n" +
                                    "---------------\n" +
                                    "3) Выход\n"
                    );

                    menu = MENU.MAIN;
                }
            }
        } catch (IncorrectPinExceprion incorrectPinExceprion) {
            label.setText( incorrectPinExceprion.getMessage() );
        } catch (AccountIsLockedException accountIsLockedException) {
            label.setText( accountIsLockedException.getMessage() );
        } catch (IsNotAuthorizedExeption isNotAuthorizedExeption) {
            isNotAuthorizedExeption.getMessage();
            label.setText( isNotAuthorizedExeption.getMessage() );
        } catch (NotEnoughMoneyException notEnoughMoneyException) {
            label.setText( notEnoughMoneyException.getMessage() );
        } catch (IsNotValidValueException isNotValidValueException) {
            label.setText( isNotValidValueException.getMessage() );
        }
    }
}