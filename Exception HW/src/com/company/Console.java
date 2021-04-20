package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Console extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JPanel panel = new JPanel();
    final JLabel label = new JLabel( "Press pin-code:" );
    Timer times = new Timer();
    final int MAX_LENGTH = 4;
    ITerminal terminal = new TerminalImpl();

    public Console() {
        super( "Terminal" );
        createGUI();
        JFrame.setDefaultLookAndFeelDecorated( true );
        pack();
        setLocationRelativeTo( null );
        setVisible( true );
    }

//    private static TimerTask wrap(Runnable r) {
//        return new TimerTask() {
//
//            @Override
//            public void run() {
//                r.run();
//            }
//        };
//    }

    public void createGUI() {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        panel.setLayout( new BorderLayout() );
        panel.setFocusable( true );

        add( label, BorderLayout.NORTH );

        textArea.setFont( new Font( "Calibri", Font.PLAIN, 20 ) );
        textArea.setBackground( Color.BLACK );
        textArea.setForeground( Color.GREEN );

        textArea.addKeyListener( new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = textArea.getText();
                Pattern p = Pattern.compile( "(([0-9]){0,}([\\.]){0,})+" );
                Matcher m = p.matcher( text );

                if (!m.matches()) {//
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
                    try {
                        terminal.inputPinCode( pinCode );
                    } catch (IncorrectPinExceprion incorrectPinExceprion) {

                        times.schedule( WrapTimerTask.wrap( () -> label.setText( incorrectPinExceprion.getMessage() ) ), 3000 );
                        //incorrectPinExceprion.printStackTrace();
                    } catch (AccountIsLockedException accountIsLockedException) {

                        times.schedule( WrapTimerTask.wrap( () -> label.setText( accountIsLockedException.getMessage() ) ), 10000 );
                        //accountIsLockedException.printStackTrace();
                    }
                }
            }
        } );

        textArea.setDocument( new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

                if (str == null || textArea.getText().length() >= MAX_LENGTH) {
                    System.out.println( "str = " + str );
                    return;
                }
                super.insertString( offs, str, a );
            }
        } );

        panel.add( textArea, BorderLayout.CENTER );

        setPreferredSize( new Dimension( 640, 480 ) );
        getContentPane().add( panel );
    }
}
