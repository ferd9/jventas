/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elaprendiz.util;

import elaprendiz.ventanas.paneles.PanelAccion;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author elaprendiz <http://www.elaprendiz.net63.net>
 */
public class AccionTableCellRenderer implements TableCellRenderer{
    private PanelAccion test;

    public AccionTableCellRenderer(final JInternalFrame ifr) {
       test = new PanelAccion(ifr);
    }
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        test.setTabla(table);        
        return test;
    }
    
}
