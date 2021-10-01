package elaprendiz.autorizacion;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author programadorbipolar
 */
public class PermisosCellRenderer implements TreeCellRenderer{

    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        JLabel regresarLabel=null;
        if ((value != null) && (value instanceof DefaultMutableTreeNode))
        {
            Object userObject = ((DefaultMutableTreeNode)value).getUserObject();
            if(userObject instanceof Autorizacion)
            {
                Autorizacion auth = (Autorizacion)userObject;
                regresarLabel = new JLabel(auth.getDescription());
                String urlResource="";
                switch(auth.getType())
                {
                    case Autorizacion.TYPE_ROLE:
                        urlResource="/elaprendiz/resources/rol.png";
                        break;
                    case Autorizacion.TYPE_TASK:
                        urlResource="/elaprendiz/resources/tarea.png";
                        break;
                    case Autorizacion.TYPE_OPERATION:    
                        urlResource="/elaprendiz/resources/operacion.png";
                        break;
                }
                regresarLabel.setIcon(new ImageIcon(tree.getClass().getResource(urlResource)));
            }else
            {
                regresarLabel = new JLabel(userObject.toString());
            }
        }
        
        if(selected)
        {
            regresarLabel.setForeground(Color.BLUE);
        }else
        {
            regresarLabel.setForeground(Color.BLACK);
        }
        return regresarLabel;
    }
    
}
