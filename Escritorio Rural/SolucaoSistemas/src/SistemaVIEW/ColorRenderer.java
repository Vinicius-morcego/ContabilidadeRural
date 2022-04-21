/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Vinicius
 */
public class ColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable tabela, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component comp = super.getTableCellRendererComponent(tabela, value, isSelected, hasFocus, row, column);
        if(isSelected == true){
             comp.setBackground(new Color(204, 204, 255));

            comp.setForeground(Color.black);
        }else if (row % 2 == 0) {
            comp.setBackground(Color.WHITE);
            comp.setForeground(Color.black);
        } else {
            comp.setBackground(new Color(204, 255, 255));

            comp.setForeground(Color.black);
        }
        tabela.setShowGrid(false);
        comp.setFont(new Font("Arial", Font.PLAIN, 12));
        return comp;
    }
}
