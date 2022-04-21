/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Vinicius
 */
public class CentralizarCelula extends DefaultTableCellRenderer {

    public CentralizarCelula() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable tabela, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        this.setHorizontalAlignment(CENTER);
        return super.getTableCellRendererComponent(tabela, value, isSelected,
                hasFocus, row, column);
    }
}
