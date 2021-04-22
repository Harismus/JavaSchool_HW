package com.company;

import java.awt.*;

import javax.swing.*;

public class Console extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel( "Press pin-code:" );
    final int MAX_LENGTH = 4;



    public Console() {
        super( "Terminal" );
        createGUI();
        JFrame.setDefaultLookAndFeelDecorated( true );
        pack();
        setLocationRelativeTo( null );
        setVisible( true );
    }

    public void createGUI() {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        panel.setLayout( new BorderLayout() );
        panel.setFocusable( true );

        add( label, BorderLayout.NORTH );

        textArea.setFont( new Font( "Calibri", Font.PLAIN, 20 ) );
        textArea.setBackground( Color.BLACK );
        textArea.setForeground( Color.GREEN );
        textArea.addKeyListener( new MyKeyAdapter( textArea, label, MAX_LENGTH ) );
        textArea.setDocument( new MyPlainDocument( textArea, MAX_LENGTH ) );

        panel.add( textArea, BorderLayout.CENTER );

        setPreferredSize( new Dimension( 640, 480 ) );
        getContentPane().add( panel );
    }
}
