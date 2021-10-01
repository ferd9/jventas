
/*
 * BuscarUsuario.java
 *
 * Created on 31/01/2013, 05:08:15 PM
 */
package elaprendiz.ventanas.buscar;

import elaprendiz.gui.label.LabelRect;
import elaprendiz.modelbd.Usuario;
import elaprendiz.modelgui.ModeloTablaUsuario;
import elaprendiz.util.Helper;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Ferz elaprendiz - www.elaprendiz.net63.net
 */
public class BuscarUsuario extends javax.swing.JPanel {

    /** Creates new form BuscarUsuario */
    JOptionPane op;
    ModeloTablaUsuario mtu;
    public int finalPag = 6;//cont
    public int tmpFp = finalPag;
    public int inicioPag = 0;
    public int numRegistros = 0;
    private int tipoSeleccion = -1; //-1 todo,1 activos, 0 No activos
    private Usuario seleccionado;
    public BuscarUsuario() {
        initComponents();
        lbAviso.setVisible(false);
        mtu =  new ModeloTablaUsuario(tipoSeleccion,this.inicioPag,finalPag);
        numRegistros = mtu.getCantidadRegistros();
        if(finalPag > numRegistros)
       {
           finalPag = numRegistros;
           bntUltimo.setEnabled(false);
           bntSiguiente.setEnabled(false);
           bntAnterior.setEnabled(true);
            bntPrimero.setEnabled(true);
       }
        tblUsuarios.setModel(mtu);
        Helper.ajustarAnchoColumnas(tblUsuarios);
        setEventSelectionModel(tblUsuarios.getSelectionModel());
        this.setSize(820, 300);
        
    }
    
    private void setEventSelectionModel(ListSelectionModel lsm)
    {
        ListSelectionListener lsl = new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectionEvent(e);
            }
        };
        
        lsm.addListSelectionListener(lsl);
    }
    
    private void selectionEvent(ListSelectionEvent e)
    {
        if(tblUsuarios.getSelectedRow() != -1)
       {
           seleccionado = (Usuario)mtu.getFila(tblUsuarios.getSelectedRow());             
            DefaultMutableTreeNode permisos = seleccionado.getPermisos();
            this.jtPermisos.setModel(new javax.swing.tree.DefaultTreeModel(permisos)); 
       }
    }
    
    
    
    private void getOptionPane()
    {
        if(op != null)
        {
            return;
        }
        Component pdr =this.getParent(); 
        while(pdr.getParent() != null)
        {
            if(pdr instanceof JOptionPane)
            {
                op = (JOptionPane)pdr;
                break;
            }            
            pdr = pdr.getParent();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbAviso = new elaprendiz.gui.label.LabelRect();
        panelImage1 = new elaprendiz.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbTipoCargo = new elaprendiz.gui.comboBox.ComboBoxRect();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDato = new elaprendiz.gui.textField.TextField();
        rbDni = new javax.swing.JRadioButton();
        rbCodigo = new javax.swing.JRadioButton();
        rbLogin = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        bntPrimero = new elaprendiz.gui.button.ButtonRect();
        bntAnterior = new elaprendiz.gui.button.ButtonRect();
        bntSiguiente = new elaprendiz.gui.button.ButtonRect();
        bntUltimo = new elaprendiz.gui.button.ButtonRect();
        tbntOpcion = new javax.swing.JToggleButton();
        bntBuscar = new elaprendiz.gui.button.ButtonRect();
        jPanel4 = new javax.swing.JPanel();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        dcFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bntBuscarFechas = new elaprendiz.gui.button.ButtonRect();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        panelCurves1 = new elaprendiz.gui.panel.PanelCurves();
        buttonRect5 = new elaprendiz.gui.button.ButtonRect();
        buttonRect6 = new elaprendiz.gui.button.ButtonRect();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPermisos = new javax.swing.JTree();

        lbAviso.setBackground(new java.awt.Color(153, 0, 0));
        lbAviso.setText("Seleccione una fila");

        setLayout(new java.awt.BorderLayout());

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elaprendiz/resources/fondoazulceleste.jpg"))); // NOI18N
        panelImage1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Cargo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Seleccionar Cargo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(jLabel4, gridBagConstraints);

        cbTipoCargo.setModel(new DefaultComboBoxModel(Usuario.tCargos));
        cbTipoCargo.setPreferredSize(new java.awt.Dimension(120, 20));
        cbTipoCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoCargoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        jPanel5.add(cbTipoCargo, gridBagConstraints);

        jPanel1.add(jPanel5);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Buscar Por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 1, 0);
        jPanel3.add(jLabel1, gridBagConstraints);

        txtDato.setPreferredSize(new java.awt.Dimension(250, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 1, 5);
        jPanel3.add(txtDato, gridBagConstraints);

        buttonGroup1.add(rbDni);
        rbDni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbDni.setSelected(true);
        rbDni.setText("DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 1, 28);
        jPanel3.add(rbDni, gridBagConstraints);

        buttonGroup1.add(rbCodigo);
        rbCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbCodigo.setText("Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 1, 28);
        jPanel3.add(rbCodigo, gridBagConstraints);

        buttonGroup1.add(rbLogin);
        rbLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbLogin.setText("Login");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 1, 28);
        jPanel3.add(rbLogin, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setOpaque(false);

        bntPrimero.setBackground(new java.awt.Color(102, 204, 0));
        bntPrimero.setText("<<");
        bntPrimero.setEnabled(false);
        bntPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPrimeroActionPerformed(evt);
            }
        });
        jPanel6.add(bntPrimero);

        bntAnterior.setBackground(new java.awt.Color(102, 204, 0));
        bntAnterior.setText("<");
        bntAnterior.setEnabled(false);
        bntAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAnteriorActionPerformed(evt);
            }
        });
        jPanel6.add(bntAnterior);

        bntSiguiente.setBackground(new java.awt.Color(102, 204, 0));
        bntSiguiente.setText(">");
        bntSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSiguienteActionPerformed(evt);
            }
        });
        jPanel6.add(bntSiguiente);

        bntUltimo.setBackground(new java.awt.Color(102, 204, 0));
        bntUltimo.setText(">>");
        bntUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUltimoActionPerformed(evt);
            }
        });
        jPanel6.add(bntUltimo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 1, 36);
        jPanel3.add(jPanel6, gridBagConstraints);

        tbntOpcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbntOpcion.setSelected(true);
        tbntOpcion.setText("Mostrando solo Activos");
        tbntOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbntOpcionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 32);
        jPanel3.add(tbntOpcion, gridBagConstraints);

        bntBuscar.setBackground(new java.awt.Color(51, 153, 255));
        bntBuscar.setText("Buscar");
        bntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 3);
        jPanel3.add(bntBuscar, gridBagConstraints);

        jPanel1.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        dcFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dcFechaInicio.setPreferredSize(new java.awt.Dimension(130, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel4.add(dcFechaInicio, gridBagConstraints);

        dcFechaFinal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dcFechaFinal.setPreferredSize(new java.awt.Dimension(130, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel4.add(dcFechaFinal, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Desde:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Hasta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel4.add(jLabel3, gridBagConstraints);

        bntBuscarFechas.setBackground(new java.awt.Color(51, 153, 255));
        bntBuscarFechas.setText("Buscar");
        bntBuscarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarFechasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        jPanel4.add(bntBuscarFechas, gridBagConstraints);

        jPanel1.add(jPanel4);

        panelImage1.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 150));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelImage1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        panelCurves1.setLayout(new java.awt.FlowLayout());

        buttonRect5.setBackground(new java.awt.Color(51, 153, 255));
        buttonRect5.setText("Seleccionar");
        buttonRect5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRect5ActionPerformed(evt);
            }
        });
        panelCurves1.add(buttonRect5);

        buttonRect6.setBackground(new java.awt.Color(51, 153, 255));
        buttonRect6.setText("Cancelar");
        buttonRect6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRect6ActionPerformed(evt);
            }
        });
        panelCurves1.add(buttonRect6);

        jPanel7.add(panelCurves1, java.awt.BorderLayout.CENTER);

        panelImage1.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        add(panelImage1, java.awt.BorderLayout.CENTER);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(180, 322));

        jtPermisos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permisos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), java.awt.Color.black)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("-------");
        jtPermisos.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jtPermisos);

        add(jScrollPane2, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

private void buttonRect6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRect6ActionPerformed
    getOptionPane();
    op.setValue(1);
}//GEN-LAST:event_buttonRect6ActionPerformed

private void cbTipoCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoCargoItemStateChanged
 if(cbTipoCargo.getSelectedIndex() != -1)
 {     
     if(evt.getStateChange() == ItemEvent.SELECTED)
     {
         System.out.println(evt.getItem());
         if(cbTipoCargo.getSelectedIndex() > 0)
         { 
             this.mtu = new ModeloTablaUsuario(ModeloTablaUsuario.POR_TIPO_CARGO,evt.getItem().toString());             
         }else
         {
             this.mtu = new ModeloTablaUsuario();             
         }         
         this.tblUsuarios.setModel(mtu);
         
     }
 }
}//GEN-LAST:event_cbTipoCargoItemStateChanged

private void bntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarActionPerformed

   if(this.txtDato.getText().isEmpty())
   {
      this.mtu = new ModeloTablaUsuario();  
   }else{
       if(this.rbDni.isSelected())
       {
          this.mtu = new ModeloTablaUsuario(ModeloTablaUsuario.POR_DNI,this.txtDato.getText());              
       }else if(this.rbCodigo.isSelected())
       {
           this.mtu = new ModeloTablaUsuario(ModeloTablaUsuario.POR_CODIGO,this.txtDato.getText());              
       }else if(this.rbLogin.isSelected())
       {
           this.mtu = new ModeloTablaUsuario(ModeloTablaUsuario.POR_LOGIN,this.txtDato.getText());              
       }
   }
  this.tblUsuarios.setModel(mtu);
}//GEN-LAST:event_bntBuscarActionPerformed

private void bntBuscarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarFechasActionPerformed
 if(this.dcFechaInicio.getCalendar() != null)
 {
     
     long hr = this.dcFechaInicio.getCalendar().get(Calendar.HOUR_OF_DAY)*3600;
     hr *=1000;
     System.out.println("Horas: "+hr);
     long time = this.dcFechaInicio.getDate().getTime()-hr;
     long timeFin = 0;
     if(this.dcFechaFinal.getCalendar() != null)
     {
         timeFin = this.dcFechaFinal.getDate().getTime();
         if(timeFin < time)
         {
             JOptionPane.showInternalMessageDialog(this, "La fecha final debe ser mayor que la fecha inicio", "Error: rango de fecha",JOptionPane.ERROR_MESSAGE);
         }else
         {
            hr = this.dcFechaFinal.getCalendar().get(Calendar.HOUR_OF_DAY)*3600;
            hr *=1000; 
            timeFin +=hr;
            this.mtu = new ModeloTablaUsuario(time,timeFin); 
         }
     }else{
         this.mtu = new ModeloTablaUsuario(time); 
     }
     
     this.tblUsuarios.setModel(mtu);
 }
}//GEN-LAST:event_bntBuscarFechasActionPerformed

private void bntAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAnteriorActionPerformed
 inicioPag -= finalPag;  
    System.out.println(inicioPag+" > "+this.numRegistros);
    if(inicioPag<0)
    {
        inicioPag = 0;
        bntAnterior.setEnabled(false);
        bntPrimero.setEnabled(false);
        bntUltimo.setEnabled(true);
        bntSiguiente.setEnabled(true);
        return;

    }
    mtu =  new ModeloTablaUsuario(-1,inicioPag,finalPag);
    this.tblUsuarios.setModel(mtu);
    bntUltimo.setEnabled(true);
    bntSiguiente.setEnabled(true);
    bntPrimero.setEnabled(true);
    if((inicioPag-finalPag)<0)
    {

        inicioPag = 0;
        bntAnterior.setEnabled(false);
        bntPrimero.setEnabled(false);
    }
}//GEN-LAST:event_bntAnteriorActionPerformed

private void bntPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPrimeroActionPerformed
    inicioPag =0;
    mtu =  new ModeloTablaUsuario(-1,inicioPag,finalPag);
    
    this.tblUsuarios.setModel(mtu);
    bntPrimero.setEnabled(false);
    bntSiguiente.setEnabled(true);
    bntAnterior.setEnabled(false);
    bntUltimo.setEnabled(true);
}//GEN-LAST:event_bntPrimeroActionPerformed

private void bntSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSiguienteActionPerformed
    inicioPag += finalPag; 
    if(finalPag>=this.numRegistros)
    {
        bntSiguiente.setEnabled(false);
        bntUltimo.setEnabled(false);
        bntAnterior.setEnabled(true);
        bntPrimero.setEnabled(true);
        return;
    }
    mtu =  new ModeloTablaUsuario(-1,inicioPag,finalPag);
    this.tblUsuarios.setModel(mtu);
   bntAnterior.setEnabled(true);
   bntPrimero.setEnabled(true);
   if((inicioPag+finalPag)>=this.numRegistros)
    {                
         bntSiguiente.setEnabled(false);
         bntUltimo.setEnabled(false);
    }
}//GEN-LAST:event_bntSiguienteActionPerformed

private void bntUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUltimoActionPerformed
    inicioPag = this.numRegistros - finalPag;
    if(finalPag>=this.numRegistros)
    {
        bntSiguiente.setEnabled(false);
        bntUltimo.setEnabled(false);
        bntAnterior.setEnabled(true);
        bntPrimero.setEnabled(true);
        return;
    }
    if(inicioPag-finalPag<0)
    {
       inicioPag = finalPag; 
    }
    mtu =  new ModeloTablaUsuario(-1,inicioPag,finalPag);
    this.tblUsuarios.setModel(mtu);
    bntUltimo.setEnabled(false);
    bntSiguiente.setEnabled(false);
    bntAnterior.setEnabled(true);
    bntPrimero.setEnabled(true);
}//GEN-LAST:event_bntUltimoActionPerformed

private void tbntOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbntOpcionActionPerformed
    if(tbntOpcion.isSelected())
    {
        this.tipoSeleccion = 1;
        this.mtu = new ModeloTablaUsuario(tipoSeleccion,this.inicioPag,finalPag);   
        tbntOpcion.setText("Usuarios Activos");
    }else{
        tipoSeleccion = 0;
        this.mtu = new ModeloTablaUsuario(tipoSeleccion,this.inicioPag,finalPag); 
        tbntOpcion.setText("Usuarios Eliminador");
    }
    this.tblUsuarios.setModel(mtu);
}//GEN-LAST:event_tbntOpcionActionPerformed

private void buttonRect5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRect5ActionPerformed
    if(tblUsuarios.getSelectedRow() != -1)
   {
       seleccionado = (Usuario)mtu.getFila(tblUsuarios.getSelectedRow());
       getOptionPane();
       op.setValue(1);
   }else
    {
        JOptionPane.showInternalMessageDialog(this, "Seleccione una fila de la tabla", "Selecciona una fila", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_buttonRect5ActionPerformed

    public LabelRect getLbAviso() {
        return lbAviso;
    }

    public Usuario getSeleccionado() {
        return seleccionado;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.button.ButtonRect bntAnterior;
    private elaprendiz.gui.button.ButtonRect bntBuscar;
    private elaprendiz.gui.button.ButtonRect bntBuscarFechas;
    private elaprendiz.gui.button.ButtonRect bntPrimero;
    private elaprendiz.gui.button.ButtonRect bntSiguiente;
    private elaprendiz.gui.button.ButtonRect bntUltimo;
    private javax.swing.ButtonGroup buttonGroup1;
    private elaprendiz.gui.button.ButtonRect buttonRect5;
    private elaprendiz.gui.button.ButtonRect buttonRect6;
    private elaprendiz.gui.comboBox.ComboBoxRect cbTipoCargo;
    private com.toedter.calendar.JDateChooser dcFechaFinal;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jtPermisos;
    private elaprendiz.gui.label.LabelRect lbAviso;
    private elaprendiz.gui.panel.PanelCurves panelCurves1;
    private elaprendiz.gui.panel.PanelImage panelImage1;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbDni;
    private javax.swing.JRadioButton rbLogin;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JToggleButton tbntOpcion;
    private elaprendiz.gui.textField.TextField txtDato;
    // End of variables declaration//GEN-END:variables
}
