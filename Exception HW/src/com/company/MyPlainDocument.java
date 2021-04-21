package com.company;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MyPlainDocument extends PlainDocument {
    private JTextArea textArea;
    private int MAX_LENGTH;

    MyPlainDocument(JTextArea textArea, int MAX_LENGTH) {
        this.textArea = textArea;
        this.MAX_LENGTH = MAX_LENGTH;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        if (str == null || textArea.getText().length() >= MAX_LENGTH) {
            return;
        }
        super.insertString( offs, str, a );
    }
}
