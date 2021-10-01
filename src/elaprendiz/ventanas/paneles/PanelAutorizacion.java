package elaprendiz.ventanas.paneles;

import elaprendiz.autorizacion.Autorizacion;
import elaprendiz.autorizacion.HeredarPermisos;
import elaprendiz.autorizacion.PermisosCellRenderer;
import elaprendiz.autorizacion.TransferirPermisos;
import elaprendiz.config.AppConfig;
import elaprendiz.modelbd.Usuario;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DropMode;
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
public class PanelAutorizacion extends javax.swing.JPanel {

    /**
     * Creates new form PanelAutorizacion
     */
    private Usuario usuario;
    public PanelAutorizacion(Usuario usuario) {
        initComponents();
        this.usuario = usuario;   
        DefaultMutableTreeNode permisos = this.usuario.getPermisos();       
        this.jtpermisosDeUsuario.setModel(new javax.swing.tree.DefaultTreeModel(permisos));
        expandirNodos(this.jtpermisosDeUsuario);
        this.txtUsuario.setText(this.usuario.getLogin());
        loadData();
        jtpermisosDeUsuario.setTransferHandler(new TransferirPermisos(usuario)); 
        this.lstRol.setTransferHandler(new TransferirPermisos(usuario)); 
        this.lstOperacion.setTransferHandler(new TransferirPermisos(usuario)); 
        this.lstTarea.setTransferHandler(new TransferirPermisos(usuario));
        PermisosCellRenderer render = new PermisosCellRenderer();
        jtpermisosDeUsuario.setCellRenderer(render);
        this.jtPermisos.setCellRenderer(render);
    }

    public PanelAutorizacion() {
        initComponents();
        loadData();
        this.remove(this.pnlPermisosUsuario);
        this.add(this.pnlHerenciaPermisos, BorderLayout.BEFORE_LINE_BEGINS);
        this.pnlPermisosUsuario.setVisible(false);
        this.btnAsginar.setVisible(false);
        this.btnRevocar1.setVisible(false);
        PermisosCellRenderer render = new PermisosCellRenderer();       
        this.jtPermisos.setCellRenderer(render);
        jtPrmisosHerencia.setTransferHandler(new HeredarPermisos());
        jtPrmisosHerencia.setCellRenderer(render);
        this.lstRol.setTransferHandler(new HeredarPermisos()); 
        this.lstOperacion.setTransferHandler(new HeredarPermisos()); 
        this.lstTarea.setTransferHandler(new HeredarPermisos());
        
    }
    private void loadData()
    {
        List<Autorizacion> roles = AppConfig.getUsuario().getAuth().getRoles();
        List<Autorizacion> tasks = AppConfig.getUsuario().getAuth().getTasks();
        List<Autorizacion> operations = AppConfig.getUsuario().getAuth().getOperations();
        
        llenarListas(this.lstRol, roles);
        llenarListas(this.lstTarea, tasks);
        llenarListas(this.lstOperacion, operations);
    }
    
    private void llenarListas(JList list, List<Autorizacion> items)
    {
//        Autorizacion[] auths=new Autorizacion[items.size()];items.toArray()
//        int i=0;
//        for(Autorizacion item:items)
//        {
//            auths[i]=item.getName();
//            i++;
//        }
        list.setListData(items.toArray());
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
        if(arbol.getRowCount()==1)
            return;         

        for (int i = 0; i<arbol.getRowCount();i++) {
             arbol.expandRow(i);
             arbol.setSelectionRow(i);
             arbol.setExpandsSelectedPaths(true);
        }    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlHerenciaPermisos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtPrmisosHerencia = new javax.swing.JTree();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        miEliminarHijo = new javax.swing.JMenuItem();
        panelImage1 = new elaprendiz.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new elaprendiz.gui.textField.TextField();
        btnAsginar = new elaprendiz.gui.button.ButtonRect();
        btnRevocar1 = new elaprendiz.gui.button.ButtonRect();
        buttonRect3 = new elaprendiz.gui.button.ButtonRect();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombrePermiso = new elaprendiz.gui.textField.TextField();
        btnCrear = new elaprendiz.gui.button.ButtonRect();
        btnAsignarHijo = new elaprendiz.gui.button.ButtonRect();
        rbRol = new javax.swing.JRadioButton();
        rbTarea = new javax.swing.JRadioButton();
        btnElminar = new elaprendiz.gui.button.ButtonRect();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRol = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTarea = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstOperacion = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtPermisos = new javax.swing.JTree();
        pnlPermisosUsuario = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtpermisosDeUsuario = new javax.swing.JTree();
        btnRevocar = new elaprendiz.gui.button.ButtonRect();

        pnlHerenciaPermisos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asignar Permisos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        pnlHerenciaPermisos.setPreferredSize(new java.awt.Dimension(220, 380));
        pnlHerenciaPermisos.setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Permisos Heredados");
        jtPrmisosHerencia.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jtPrmisosHerencia.setComponentPopupMenu(jPopupMenu1);
        jScrollPane4.setViewportView(jtPrmisosHerencia);

        pnlHerenciaPermisos.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        miEliminarHijo.setText("Eliminar");
        miEliminarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEliminarHijoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miEliminarHijo);

        setPreferredSize(new java.awt.Dimension(800, 520));
        setLayout(new java.awt.BorderLayout());

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elaprendiz/resources/fondoazulceleste.jpg"))); // NOI18N
        panelImage1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), java.awt.Color.white)); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        txtUsuario.setEditable(false);
        txtUsuario.setPreferredSize(new java.awt.Dimension(180, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtUsuario, gridBagConstraints);

        btnAsginar.setBackground(new java.awt.Color(51, 153, 255));
        btnAsginar.setText("ASIGNAR");
        btnAsginar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsginarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel1.add(btnAsginar, gridBagConstraints);

        btnRevocar1.setBackground(new java.awt.Color(51, 153, 255));
        btnRevocar1.setText("REVOCAR");
        btnRevocar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevocar1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel1.add(btnRevocar1, gridBagConstraints);

        buttonRect3.setBackground(new java.awt.Color(102, 204, 0));
        buttonRect3.setText("BUSCAR");
        jPanel1.add(buttonRect3, new java.awt.GridBagConstraints());

        panelImage1.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Crear Nuevos Permisos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), java.awt.Color.white)); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel6.add(jLabel2, new java.awt.GridBagConstraints());

        txtNombrePermiso.setPreferredSize(new java.awt.Dimension(120, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel6.add(txtNombrePermiso, gridBagConstraints);

        btnCrear.setBackground(new java.awt.Color(51, 153, 255));
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel6.add(btnCrear, gridBagConstraints);

        btnAsignarHijo.setBackground(new java.awt.Color(51, 153, 255));
        btnAsignarHijo.setText("ASIGNAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        jPanel6.add(btnAsignarHijo, gridBagConstraints);

        buttonGroup1.add(rbRol);
        rbRol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbRol.setForeground(new java.awt.Color(255, 255, 255));
        rbRol.setSelected(true);
        rbRol.setText("ROL");
        rbRol.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel6.add(rbRol, gridBagConstraints);

        buttonGroup1.add(rbTarea);
        rbTarea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbTarea.setForeground(new java.awt.Color(255, 255, 255));
        rbTarea.setText("TAREA");
        rbTarea.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel6.add(rbTarea, gridBagConstraints);

        btnElminar.setBackground(new java.awt.Color(51, 153, 255));
        btnElminar.setText("ELIMINAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel6.add(btnElminar, gridBagConstraints);

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        panelImage1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Roles | Tarea | Operaciones Por Defecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), java.awt.Color.white)); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        lstRol.setBorder(javax.swing.BorderFactory.createTitledBorder("Roles Por Defecto"));
        lstRol.setDragEnabled(true);
        lstRol.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstRolValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstRol);

        jPanel3.add(jScrollPane1);

        lstTarea.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas Por Defecto"));
        lstTarea.setDragEnabled(true);
        lstTarea.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTareaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstTarea);

        jPanel3.add(jScrollPane2);

        lstOperacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));
        lstOperacion.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstOperacion.setDragEnabled(true);
        lstOperacion.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOperacionValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstOperacion);

        jPanel3.add(jScrollPane3);

        panelImage1.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(panelImage1, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("PERMISOS EXISTENTES"));
        jPanel4.setMinimumSize(new java.awt.Dimension(200, 23));
        jPanel4.setPreferredSize(new java.awt.Dimension(220, 380));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane7.setMinimumSize(new java.awt.Dimension(150, 23));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(200, 322));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("---------");
        jtPermisos.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jtPermisos.setMaximumSize(new java.awt.Dimension(150, 64));
        jScrollPane7.setViewportView(jtPermisos);

        jPanel4.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.LINE_END);

        pnlPermisosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("PERMISOS DEL USUARIO"));
        pnlPermisosUsuario.setPreferredSize(new java.awt.Dimension(220, 380));
        pnlPermisosUsuario.setLayout(new java.awt.BorderLayout());

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("--------");
        jtpermisosDeUsuario.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane8.setViewportView(jtpermisosDeUsuario);

        pnlPermisosUsuario.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        btnRevocar.setBackground(new java.awt.Color(51, 153, 255));
        btnRevocar.setText("Revocar Permiso");
        btnRevocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevocarActionPerformed(evt);
            }
        });
        pnlPermisosUsuario.add(btnRevocar, java.awt.BorderLayout.PAGE_START);

        add(pnlPermisosUsuario, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void lstRolValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstRolValueChanged
        if(lstRol.getSelectedIndex()==-1)
            return;
        Autorizacion selectedValue = (Autorizacion)lstRol.getSelectedValue();                     
        if(selectedValue == null)
            return;
        this.lstTarea.clearSelection();
        this.lstOperacion.clearSelection();
        
        DefaultMutableTreeNode permisos = new DefaultMutableTreeNode("Permisos");
        this.getPermisosHijos(selectedValue, permisos);
        this.jtPermisos.setModel(new javax.swing.tree.DefaultTreeModel(permisos));
        expandirNodos(this.jtPermisos);
    }//GEN-LAST:event_lstRolValueChanged

    private void lstTareaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTareaValueChanged
        if(this.lstTarea.getSelectedIndex() == -1)
            return;
        Autorizacion selectedValue = (Autorizacion) this.lstTarea.getSelectedValue();
        if(selectedValue == null)
            return;      
        
        this.lstOperacion.clearSelection();
        this.lstRol.clearSelection();
           
        DefaultMutableTreeNode permisos = new DefaultMutableTreeNode("Permisos");
        this.getPermisosHijos(selectedValue, permisos);
        this.jtPermisos.setModel(new javax.swing.tree.DefaultTreeModel(permisos));
        expandirNodos(this.jtPermisos);
    }//GEN-LAST:event_lstTareaValueChanged

    private void btnAsginarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsginarActionPerformed
       asginarPermiso(true);
    }//GEN-LAST:event_btnAsginarActionPerformed

    private void lstOperacionValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOperacionValueChanged
       if(lstOperacion.getSelectedIndex()==-1)
           return;
        this.lstTarea.clearSelection();
        this.lstRol.clearSelection();
    }//GEN-LAST:event_lstOperacionValueChanged

    private void btnRevocar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevocar1ActionPerformed
        asginarPermiso(false);
    }//GEN-LAST:event_btnRevocar1ActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        Autorizacion authItem = AppConfig.getUsuario().getAuth().getAuthItem(this.txtNombrePermiso.getText());
        int tipo = Autorizacion.TYPE_ROLE;
        if(authItem == null)
        {
            if(this.rbTarea.isSelected())
            {
                tipo = Autorizacion.TYPE_TASK;
            }
            
            Autorizacion createAuthItem = AppConfig.getUsuario().getAuth().createAuthItem(this.txtNombrePermiso.getText().trim(), tipo,this.txtNombrePermiso.getText());
            if(createAuthItem != null)
            {
                JOptionPane.showMessageDialog(panelImage1, "El permiso "+createAuthItem.getName()+" fue creado correctamente. ");
            }else{
                JOptionPane.showMessageDialog(panelImage1, "El permiso "+this.txtNombrePermiso.getText()+" no pudo ser creado. ");
            }
        }else
        {
            JOptionPane.showMessageDialog(panelImage1, "El permiso "+this.txtNombrePermiso.getText()+" ya existe. ");
            this.txtNombrePermiso.setText("");
        }
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnRevocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevocarActionPerformed
        if(this.jtpermisosDeUsuario.getRowCount()>0)
        {
            TreePath selectionPath = this.jtpermisosDeUsuario.getSelectionPath();
            if(selectionPath==null)
            {
                JOptionPane.showMessageDialog(this, "Primero debe seleccionar Permiso del arbol");
                return;
            }
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
            Object dato = nodo.getUserObject();
            Autorizacion userObject=null;
            if(dato instanceof Autorizacion)
            {
                userObject = (Autorizacion)dato;
                this.usuario.getAuth().revoke(userObject.getName(), this.usuario.getLogin());
                this.jtpermisosDeUsuario.removeSelectionPath(selectionPath);
                DefaultMutableTreeNode permisos = this.usuario.getPermisos();       
                this.jtpermisosDeUsuario.setModel(new javax.swing.tree.DefaultTreeModel(permisos));
                
            }
        }
    }//GEN-LAST:event_btnRevocarActionPerformed

    private void miEliminarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEliminarHijoActionPerformed
        if(this.jtPrmisosHerencia.getRowCount()==1)
            return;
        TreePath selectionPath = this.jtPrmisosHerencia.getSelectionPath();
        if(selectionPath==null)
            return;
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
        DefaultMutableTreeNode padre = (DefaultMutableTreeNode)nodo.getParent();
        int index = this.jtPrmisosHerencia.getRowForPath(selectionPath); 
        DefaultTreeModel model = (DefaultTreeModel)this.jtPrmisosHerencia.getModel();
        Autorizacion authSeleccionado = (Autorizacion)nodo.getUserObject();
        if(index>1)
        {
            Autorizacion authPadre = (Autorizacion)padre.getUserObject();
            authPadre.removeChild(authSeleccionado.getName());
        }
        model.removeNodeFromParent(nodo);
        System.out.println(index);
    }//GEN-LAST:event_miEliminarHijoActionPerformed

private boolean asginarPermiso(boolean opcion)
{
    String pemiso="";
       
        if(this.lstRol.getSelectedIndex()!=-1)
        {
            Autorizacion selectedValue = (Autorizacion) this.lstRol.getSelectedValue();
            pemiso = selectedValue.getName();
            if(opcion)
                return verificarPermiso(pemiso);
            else
                return revocarPermiso(pemiso);
            

        }
      
       if(this.lstTarea.getSelectedIndex()!=-1)
       {
           Autorizacion selectedValue = (Autorizacion) this.lstRol.getSelectedValue();
            pemiso = selectedValue.getName();
           if(opcion)
                return verificarPermiso(pemiso);
            else
                return revocarPermiso(pemiso);

       }
            
       
       if(this.lstOperacion.getSelectedIndex()!=-1)
       {
           Autorizacion selectedValue = (Autorizacion) this.lstRol.getSelectedValue();
            pemiso = selectedValue.getName();
           if(opcion)
                return verificarPermiso(pemiso);
            else
                return revocarPermiso(pemiso);
       }
       
       return false;
}

private boolean verificarPermiso(String pemiso)
{
    if(pemiso.isEmpty())
           return false;
       
       if(this.usuario.verificarAcceso(pemiso))
       {
           JOptionPane.showMessageDialog(panelImage1, "El permiso "+pemiso+" ya fue asinado a este usuario");
           return false;
       }else
       {
           this.usuario.getAuth().assign(pemiso, usuario.getLogin());
           return true;
       }
}

public boolean revocarPermiso(String pemiso)
{
    if(this.usuario.verificarAcceso(pemiso))
    {
        this.usuario.getAuth().revoke(pemiso, usuario.getLogin());
        return true;
    }else
        return false;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.button.ButtonRect btnAsginar;
    private elaprendiz.gui.button.ButtonRect btnAsignarHijo;
    private elaprendiz.gui.button.ButtonRect btnCrear;
    private elaprendiz.gui.button.ButtonRect btnElminar;
    private elaprendiz.gui.button.ButtonRect btnRevocar;
    private elaprendiz.gui.button.ButtonRect btnRevocar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private elaprendiz.gui.button.ButtonRect buttonRect3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTree jtPermisos;
    private javax.swing.JTree jtPrmisosHerencia;
    private javax.swing.JTree jtpermisosDeUsuario;
    private javax.swing.JList lstOperacion;
    private javax.swing.JList lstRol;
    private javax.swing.JList lstTarea;
    private javax.swing.JMenuItem miEliminarHijo;
    private elaprendiz.gui.panel.PanelImage panelImage1;
    private javax.swing.JPanel pnlHerenciaPermisos;
    private javax.swing.JPanel pnlPermisosUsuario;
    private javax.swing.JRadioButton rbRol;
    private javax.swing.JRadioButton rbTarea;
    private elaprendiz.gui.textField.TextField txtNombrePermiso;
    private elaprendiz.gui.textField.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
