package elaprendiz.modelgui;

import elaprendiz.controllers.CMoneda;
import elaprendiz.modelbd.Moneda;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ferz
 */
public class ListModelMoneda extends DefaultListModel{

    private CMoneda cm;
    private Moneda predeterminado;
    public ListModelMoneda() {
        cm = new CMoneda();
       ArrayList<Moneda> lm = cm.getRegistros();
       predeterminado = cm.getPredeterminado();
       for(Moneda md:lm)
       {
           this.addElement(md);
       }
        
    }

    public Moneda getPredeterminado() {
        return predeterminado;
    }
    
    
}
