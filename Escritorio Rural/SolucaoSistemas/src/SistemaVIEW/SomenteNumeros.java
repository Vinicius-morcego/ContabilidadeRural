/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Vinicius
 */
public class SomenteNumeros extends FixedLenghtDocument {

    public SomenteNumeros(int maxLen) {
        super(maxLen);
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) {
            return;
        }
        try {
            Integer.parseInt(str);

        } catch (NumberFormatException e) {
            return;
        }
        super.insertString(offset, str, attr);
    }
}
