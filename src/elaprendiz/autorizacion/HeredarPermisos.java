package elaprendiz.autorizacion;

import elaprendiz.config.AppConfig;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.io.IOException;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author programadorbipolar
 */
public class HeredarPermisos extends TransferHandler implements Transferable{
    public static final DataFlavor LIST_ITEM_DATA_FLAVOR = new DataFlavor(Autorizacion.class, "java/Autorizacion");
    private Autorizacion listItem;
    private Autorizacion padreRaiz;
     public HeredarPermisos(Autorizacion listItem) {
            this.listItem = listItem;
    }

    public HeredarPermisos() {
    }
     
     @Override
    public int getSourceActions(JComponent c) {
        return DnDConstants.ACTION_COPY_OR_MOVE;
    }
    
    @Override
    public Transferable createTransferable(JComponent c) {
       Transferable t = null;
            if (c instanceof JList) {
                JList list = (JList) c;
                Object value = list.getSelectedValue();
                if (value instanceof Autorizacion) {
                    Autorizacion li = (Autorizacion) value;
                    t = new HeredarPermisos(li);
                }
            }
            return t;
    }
    
    @Override
    public boolean canImport(TransferSupport support) {        
        return (support.getComponent() instanceof JList || support.getComponent() instanceof JTree) && support.isDataFlavorSupported(HeredarPermisos.LIST_ITEM_DATA_FLAVOR);
    }
    
    
    @Override
    public boolean importData(TransferSupport support) {
        //corregir logica
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
                            if(selectionPath == null)
                                return false;
                            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
                            Object dato = nodo.getUserObject();
                            Autorizacion userObject=null;                           
                            if(arbol.getRowCount()==1)
                            {
                                padreRaiz = (Autorizacion)value;                                
                                if(padreRaiz.getType()== Autorizacion.TYPE_ROLE || padreRaiz.getType()== Autorizacion.TYPE_TASK)
                                {
                                    DefaultMutableTreeNode nhijo =  new DefaultMutableTreeNode(padreRaiz);
                                    nodo.add(nhijo);
                                    this.getPermisosHijos(value, nhijo);
                                }else
                                {
                                    DefaultMutableTreeNode nhijo =  new DefaultMutableTreeNode(padreRaiz);
                                    nodo.add(nhijo);
                                }
                                arbol.updateUI();
                                expandirNodos(arbol);
                                return true;
                            }
                            
                            if(arbol.getRowCount()>1 && arbol.getRowForPath(selectionPath)==0)
                            {
                                JOptionPane.showMessageDialog(null, "Solo puede agregar permisos a "+padreRaiz.getDescription());                                                                  
                                return false;
                            }
                            
                            if(dato instanceof Autorizacion)
                            {
                                if(((Autorizacion)value).equals(padreRaiz))
                                {
                                   JOptionPane.showMessageDialog(null, "El Permiso "+padreRaiz.getDescription()+" no puede auto asignarse.. gracioso!!");                                   
                                   return false;
                                }
                               userObject = (Autorizacion)nodo.getUserObject();                              
                               if(tieneHijo((Autorizacion)value,padreRaiz))
                               {
                                   JOptionPane.showMessageDialog(null, "El Permiso "+padreRaiz.getDescription()+" ya tiene "+((Autorizacion)value).getDescription());                                   
                                   return false;
                               }
                               DefaultMutableTreeNode parent = (DefaultMutableTreeNode)nodo.getParent();
                               if(parent.getUserObject() instanceof String && userObject.getType() == Autorizacion.TYPE_OPERATION)
                               {
                                   JOptionPane.showMessageDialog(null, "No puede asignar hijos a "+userObject.getName());                                   
                                   return false;
                               }else if(userObject.getType() == Autorizacion.TYPE_OPERATION)
                               {
                                   JOptionPane.showMessageDialog(null, "No puede asignar hijos a "+userObject.getName());                                   
                                   return false;                                   
                               }else{                                   
                                   nodo.add(new DefaultMutableTreeNode(value));
                                   
                                   if(parent.getUserObject() instanceof Autorizacion)
                                   {
                                       Autorizacion padre = (Autorizacion)parent.getUserObject();
                                       padre.addChild(((Autorizacion)value).getName());
                                   }else{
                                       userObject.addChild(((Autorizacion)value).getName());                                       
                                   }
                               }
                                
                            }
                            arbol.updateUI();
                            DefaultMutableTreeNode per = new DefaultMutableTreeNode(padreRaiz);
                            getPermisosHijos(padreRaiz,per);
                            DefaultMutableTreeNode nodor = new DefaultMutableTreeNode("Permisos Heredados");
                            nodor.add(per);
                            arbol.setModel(new DefaultTreeModel(nodor));
                            expandirNodos(arbol);
                            //asignar valor
                            System.out.println(userObject);
                            return true;
                        }
                    }
            } catch (Exception exp) {
                    exp.printStackTrace();
                }
        } 
        return false;
    }
    
    public boolean tieneHijo(Autorizacion hijo,Autorizacion padre)
    {
        List<Autorizacion> children = padre.getChildren();
        if(children.contains(hijo))
            return true;
        for(Autorizacion encontrado:children)
        {
            if(encontrado.getType()==Autorizacion.TYPE_TASK || encontrado.getType()==Autorizacion.TYPE_ROLE)
            {
                if(encontrado.equals(hijo))
                {
                    return true;
                }else
                {
                   if(tieneHijo(hijo,encontrado))
                   {
                       return true;                      
                   }
                }
            }else
            {
                if(encontrado.equals(hijo))
                    return true;
            }
        }
        return false;
    }
    
    public void getPermisosHijos(Object auth1,DefaultMutableTreeNode raiz)
    {
        Autorizacion auth=null;
        if(auth1 instanceof String)
            auth = AppConfig.getUsuario().getAuth().getAuthItem(auth1.toString());
        else if(auth1 instanceof Autorizacion)
        {
            auth = (Autorizacion)auth1;
        }
        
        if(auth==null)
            throw new RuntimeException("Objeto vacio");
        
        List<Autorizacion> children = auth.getChildren();  
        for(Autorizacion hijo: children)
        {
            findChild(hijo, raiz);
        }
        
    }
    
    private void findChild(Autorizacion au, DefaultMutableTreeNode padre)
    {
        if(au.getType()==Autorizacion.TYPE_ROLE || au.getType()==Autorizacion.TYPE_TASK)
        {   
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(au);
            padre.add(hijo);
            List<Autorizacion> children = au.getChildren();
            for(Autorizacion ch: children)
            {
                findChild(ch,hijo);
            }
        } 
        
        if(au.getType()==Autorizacion.TYPE_OPERATION)
        {
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(au);
            padre.add(hijo);
        }
        
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
