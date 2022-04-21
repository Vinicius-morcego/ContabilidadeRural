/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author VINICIUS
 */
public class CellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        Component result = super.getTableCellRendererComponent(
                table,
                value,
                isSelected,
                hasFocus,
                row,
                column);

        Object ref = table.getValueAt(row, 3);

        
        if (ref != null && ref.toString().equals("DÉBITO")) {
            //result.setFont(new Font("arial", Font.PLAIN, 12));  
            result.setForeground(Color.red);
        } else {
            //result.setFont(new Font("arial", Font.PLAIN, 12));  
            result.setForeground(Color.black);

        }

        return result;

    }
}
