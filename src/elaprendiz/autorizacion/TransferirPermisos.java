package elaprendiz.autorizacion;

import elaprendiz.modelbd.Usuario;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author programadorbipolar
 */
public class TransferirPermisos extends TransferHandler implements Transferable{
    
    public static final DataFlavor LIST_ITEM_DATA_FLAVOR = new DataFlavor(Autorizacion.class, "java/Autorizacion");
    private Autorizacion listItem;
    
    
    
    private Autorizacion texto;
    
    private Usuario user;
    
    public TransferirPermisos(Autorizacion listItem) {
            this.listItem = listItem;
    }
    public TransferirPermisos(Usuario user) {
        this.user = user;
    }
    
    @Override
    public int getSourceActions(JComponent c) {
        return DnDConstants.ACTION_COPY_OR_MOVE;
    }
    
    @Override
    public boolean canImport(TransferSupport support) {        
        return (support.getComponent() instanceof JList || support.getComponent() instanceof JTree) && support.isDataFlavorSupported(TransferirPermisos.LIST_ITEM_DATA_FLAVOR);
        
    }
    
    @Override
    public Transferable createTransferable(JComponent c) {
        // Clear
        texto = null;
        Transferable t = null;
            if (c instanceof JList) {
                JList list = (JList) c;
                Object value = list.getSelectedValue();
                if (value instanceof Autorizacion) {
                    Autorizacion li = (Autorizacion) value;
                    t = new TransferirPermisos(li);
                }
            }
            return t;
    }
    
    @Override
    public boolean importData(TransferSupport support) {
        boolean accept = false;
        if (canImport(support)) {
            try {
                Transferable t = support.getTransferable();
                Object value = t.getTransferData(TransferirPermisos.LIST_ITEM_DATA_FLAVOR);
                if (value instanceof Autorizacion) {
                        Component component = support.getComponent();
                        if (component instanceof JTree) {
                            JTree arbol = (JTree)component;
                            TreePath selectionPath = arbol.getSelectionPath();
                            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
                            Object dato = nodo.getUserObject();
                            Autorizacion userObject=null;
                            if(dato instanceof Autorizacion)
                            {
                               userObject = (Autorizacion)nodo.getUserObject();
                               if(userObject.getType() == Autorizacion.TYPE_OPERATION)
                                {
                                    JOptionPane.showMessageDialog(null, "No puede asignar hijos a "+userObject.getName());
                                    return false; 
                                }
                            }else
                            {
                               nodo.setUserObject("Permisos"); 
                            }
                            
                            texto = (Autorizacion)value;
                            if(this.user.verificarAcceso(texto.getName()))
                            {
                                JOptionPane.showMessageDialog(null, "El usuario: "+user.getLogin()+" ya tiene el permiso "+texto);
                                return false;
                            }
                            this.user.getAuth().assign(texto.getName(), user.getLogin());
                            nodo.add(new DefaultMutableTreeNode(texto));
                            DefaultMutableTreeNode permisos = this.user.getPermisos();
                            arbol.setModel(new javax.swing.tree.DefaultTreeModel(permisos));
                            arbol.updateUI();
                            expandirNodos(arbol);
                            //asignar valor
                            System.out.println(texto);
                            return true;
                        }
                    }
            } catch (Exception exp) {
                    exp.printStackTrace();
                }
        } 
        return false;
    }
    
    private void expandirNodos(JTree arbol)
    {
              

        for (int i = 0; i<arbol.getRowCount();i++) {
             arbol.expandRow(i);
             arbol.setSelectionRow(i);
             arbol.setExpandsSelectedPaths(true);
        }    
    }
    
        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{LIST_ITEM_DATA_FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(LIST_ITEM_DATA_FLAVOR);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            return listItem;
        }
}
