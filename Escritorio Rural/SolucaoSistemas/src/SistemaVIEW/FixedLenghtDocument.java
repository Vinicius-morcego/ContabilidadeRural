/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Vinicius
 */
public class FixedLenghtDocument extends PlainDocument {

    private int maxLenght;

    public FixedLenghtDocument(int maxlen) {
        super();
        if (maxlen <= 0) {
            throw new IllegalArgumentException("Você usou argumento ilegal!");
        }
        maxLenght = maxlen;

    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null || getLength() == maxLenght) {
            return;
        }
        int totalLenght = (getLength() + str.length());
        if (totalLenght <= maxLenght) {
            super.insertString(offset, str, attr);
            return;
        }
        String newStr = str.substring(0, (maxLenght - getLength()));
        super.insertString(offset, newStr, attr);

    }

}
