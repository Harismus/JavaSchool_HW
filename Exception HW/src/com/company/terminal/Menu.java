//package com.company;
//
//import java.awt.event.KeyEvent;
//
//public class Menu {
//    private enum  CURRENT {
//        AUTHORIZED,
//        MAIN,
//        WITHDRAW,
//        DEPOSIT
//    }
//
//    public void keyReleased(KeyEvent e) {
//
//        try {
//            System.out.println( "terminal.isAuthorized() = " + terminal.isAuthorized() );
//            if (!terminal.isAuthorized()) { //!< пока не вошли в аккаунт
//                String text = textArea.getText();
//
//                if (!DigitValidator.isMatch(text)) {//
//                    label.setText( "Warning: you must press just numbers." );
//
//                    times.schedule( WrapTimerTask.wrap( () -> label.setText( "Press pin-code:" ) ), 3000 );
//
//                    textArea.setText( "" );
//
//                    for (int i = 0; i < text.length(); ++i) {
//                        if (!Character.isAlphabetic( text.charAt( i ) ))
//                            textArea.append( String.valueOf( text.charAt( i ) ) );
//                    }
//                    return;
//
//                } else if (text.length() == MAX_LENGTH) {
//
//                    int pinCode = Integer.parseInt( text );
//
//                    if (terminal.inputPinCode( pinCode ) == true) {
//                        textArea.setText( "" );
//                        label.setText( "Entering to account... Please Wait..." );
//
//                        times.schedule( WrapTimerTask.wrap( () -> {
//                            label.setText( "Select a command:" );
//                            textArea.setEditable( false );
//                            textArea.setText(
//                                    "1) Withdraw money\n" +
//                                            "2) Deposit money\n" +
//                                            "3) Check account\n" +
//                                            "---------------\n" +
//                                            "4) Exit\n"
//                            );
//
//                        } ), 3000 );
//                    }
//                }
//            } else { //!< если вошли в аккаунт
//
//                int key = Integer.parseInt( String.valueOf( e.getKeyChar() ) );
//
//
//
//                switch (key) {
//                    case 1: {
//
//
//                        textArea.setText( "\n" +
//                                "---------------\n" +
//                                "1) Exit\n");
//
//                        break;
//                    }
//                    case 2: {
//
//
//                        textArea.setText( " \n" +
//                                "---------------\n" +
//                                "1) Exit\n");
//
//                        break;
//                    }
//                    case 3: {
//                        String countMoney = String.valueOf( terminal.checkAccount() );
//
//                        textArea.setText( "Amount of money left: " + countMoney + "\n" +
//                                "---------------\n" +
//                                "1) Exit\n");
//                        break;
//                    }
//                    case 4: {
//                        terminal.exitFromAccount();
//                        label.setText( "Exit from Account. Please Wait..." );
//
//                        times.schedule( WrapTimerTask.wrap( () -> label.setText( "Press pin-code:" ) ), 3000 );
//
//                        textArea.setText( "" );
//                        textArea.setEditable( true );
//                        break;
//                    }
//                }
//
//            }
//
//        } catch (IncorrectPinExceprion incorrectPinExceprion) {
//            label.setText( incorrectPinExceprion.getMessage() );
//        } catch (AccountIsLockedException accountIsLockedException) {
//            System.out.println( "accountIsLockedException.getMessage() = " + accountIsLockedException.getMessage() );
//            label.setText( accountIsLockedException.getMessage() );
//        } catch (IsNotAuthorizedExeption isNotAuthorizedExeption) {
//            isNotAuthorizedExeption.getMessage();
//            label.setText( isNotAuthorizedExeption.getMessage() );
//        }
//    }
//
//}
