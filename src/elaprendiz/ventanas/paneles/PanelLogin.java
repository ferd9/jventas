/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elaprendiz.ventanas.paneles;

import elaprendiz.config.AppConfig;
import elaprendiz.controllers.CAlmacen;
import elaprendiz.controllers.CMoneda;
import elaprendiz.util.text.FormatoDecimal;
import java.awt.Component;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

//panel que puede ser usado dentro de un JOptionPane. pero provoca errores en la posicion de
// componentes.
/**
 *
 * @author elaprendiz <http://www.elaprendiz.net63.net>
 */
public class PanelLogin extends javax.swing.JPanel {

    /**
     * Creates new form PanelLogin
     */
    private DefaultComboBoxModel mMoneda;
    private DefaultComboBoxModel mAlmacen;
    private JOptionPane op;
    private boolean accesoConcedido = false;
    public PanelLogin() {
        initComponents();
        //this.setSize(533, 233);
        CMoneda controllerMoneda = new CMoneda();        
        mMoneda = new DefaultComboBoxModel(controllerMoneda.getRegistros().toArray());
        this.cmbMoneda.setModel(mMoneda);
        this.cmbMoneda.setSelectedItem(controllerMoneda.getPredeterminado());
        
        CAlmacen controllerAlmacen = new CAlmacen();
        mAlmacen = new DefaultComboBoxModel(controllerAlmacen.getRegistros(new Object[]{1}).toArray());
        this.cmbAlmacen.setModel(mAlmacen);
        this.bntAceptar.setVisible(false);
        this.bntContinuar.setVisible(false);
        this.txtUsuario.requestFocus();        
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

        panelImage1 = new elaprendiz.gui.panel.PanelImage();
        panelCurves1 = new elaprendiz.gui.panel.PanelCurves();
        pnlConfig = new elaprendiz.gui.panel.PanelTranslucido();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clockDigital1 = new elaprendiz.gui.varios.ClockDigital();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tftTipoCambio = new javax.swing.JFormattedTextField();
        dcFecha = new com.toedter.calendar.JDateChooser();
        cmbMoneda = new javax.swing.JComboBox();
        cmbAlmacen = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        bntAceptar = new elaprendiz.gui.button.ButtonRect();
        bntContinuar = new elaprendiz.gui.button.ButtonRect();
        pnlLogin = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new elaprendiz.gui.textField.TextFieldRectIcon();
        ptxtPass = new elaprendiz.gui.passwordField.PasswordFieldRectIcon();
        bntCancelar = new javax.swing.JButton();
        bntIngresar = new javax.swing.JButton();
        panelImage2 = new elaprendiz.gui.panel.PanelImage();
        lblLogo = new elaprendiz.gui.label.LabelHeader();

        setLayout(new java.awt.BorderLayout());

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elaprendiz/resources/fondoazulceleste.jpg"))); // NOI18N
        panelImage1.setLayout(new java.awt.BorderLayout());

        pnlConfig.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuración Predeterminada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), java.awt.Color.white)); // NOI18N
        pnlConfig.setColorPrimario(new java.awt.Color(0, 0, 153));
        pnlConfig.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Tipo de Cambio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 8, 0, 0);
        pnlConfig.add(jLabel3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Fecha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 0);
        pnlConfig.add(jLabel1, gridBagConstraints);

        clockDigital1.setForeground(new java.awt.Color(255, 255, 255));
        clockDigital1.setPreferredSize(new java.awt.Dimension(120, 45));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 0, 10);
        pnlConfig.add(clockDigital1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Hora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 8, 0, 0);
        pnlConfig.add(jLabel2, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Almacen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 8, 0, 0);
        pnlConfig.add(jLabel4, gridBagConstraints);

        tftTipoCambio.setEditable(false);
        tftTipoCambio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new FormatoDecimal("#,##0.00",true))));
        tftTipoCambio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tftTipoCambio.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 0, 10);
        pnlConfig.add(tftTipoCambio, gridBagConstraints);

        dcFecha.setDate(Calendar.getInstance().getTime());
        dcFecha.setDateFormatString("dd/MM/yyyy");
        dcFecha.setEnabled(false);
        dcFecha.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 0, 10);
        pnlConfig.add(dcFecha, gridBagConstraints);

        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMoneda.setEnabled(false);
        cmbMoneda.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 8, 10);
        pnlConfig.add(cmbMoneda, gridBagConstraints);

        cmbAlmacen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAlmacen.setEnabled(false);
        cmbAlmacen.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 0, 10);
        pnlConfig.add(cmbAlmacen, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Moneda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 8, 8, 0);
        pnlConfig.add(jLabel5, gridBagConstraints);

        bntAceptar.setBackground(new java.awt.Color(51, 153, 255));
        bntAceptar.setText("Aceptar");
        bntAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        pnlConfig.add(bntAceptar, gridBagConstraints);

        bntContinuar.setBackground(new java.awt.Color(51, 153, 255));
        bntContinuar.setText("Continuar");
        bntContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntContinuarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        pnlConfig.add(bntContinuar, gridBagConstraints);

        panelCurves1.add(pnlConfig, java.awt.BorderLayout.WEST);

        pnlLogin.setOpaque(false);
        pnlLogin.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 1, 0);
        pnlLogin.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 4, 0);
        pnlLogin.add(jLabel7, gridBagConstraints);

        txtUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elaprendiz/resources/user_blue_32.png"))); // NOI18N
        txtUsuario.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 1, 7);
        pnlLogin.add(txtUsuario, gridBagConstraints);

        ptxtPass.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 4, 7);
        pnlLogin.add(ptxtPass, gridBagConstraints);

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        pnlLogin.add(bntCancelar, gridBagConstraints);

        bntIngresar.setText("Ingresar");
        bntIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlLogin.add(bntIngresar, gridBagConstraints);

        panelCurves1.add(pnlLogin, java.awt.BorderLayout.CENTER);

        panelImage2.setLayout(new java.awt.BorderLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("JVENTAS - SOFTWARE DE ALMACÉN Y FACTURACIÓN");
        lblLogo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        panelImage2.add(lblLogo, java.awt.BorderLayout.CENTER);

        panelCurves1.add(panelImage2, java.awt.BorderLayout.PAGE_START);

        panelImage1.add(panelCurves1, java.awt.BorderLayout.CENTER);

        add(panelImage1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bntIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresarActionPerformed
        getOptionPane();
        if(!this.txtUsuario.getText().isEmpty() && !String.copyValueOf(this.ptxtPass.getPassword()).isEmpty())
        {
            String msg = "";
            AppConfig.Estado configUsuario = AppConfig.configUsuario(this.txtUsuario.getText(), String.copyValueOf(this.ptxtPass.getPassword()));
            if(configUsuario == AppConfig.Estado.NO_EXISTE)
            {
                msg = "El usuario: "+this.txtUsuario.getText()+" no existe.";
            }else if(configUsuario == AppConfig.Estado.ERROR_CLAVE)
            {
                msg = "Contraseña Incorrecta!";
            }else{
                int ops = JOptionPane.showConfirmDialog(null, "¿Desea cambiar la configuración actual?",
                    "Actualizar Configuración.",JOptionPane.YES_NO_OPTION);
                if(ops == JOptionPane.OK_OPTION)
                {
                    this.pnlLogin.setVisible(false);
                    this.dcFecha.setEnabled(true);
                    this.tftTipoCambio.setEditable(true);
                    this.cmbAlmacen.setEnabled(true);
                    this.cmbMoneda.setEnabled(true);
                    lblLogo.setText("JVENTAS");
                    this.setSize(pnlConfig.getWidth(), this.getHeight()+bntAceptar.getHeight());
                    op.setSize(200, this.getHeight()+bntAceptar.getHeight());
                    op.updateUI();
                    this.bntAceptar.setVisible(true);
                    this.bntContinuar.setVisible(true);                    
                }else{
                    this.op.setValue(1);
                }
                accesoConcedido = true;
                return;
            }
            JOptionPane.showMessageDialog(null, msg, "Error: no se pudo conectar.", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese un nombre de usuario y su contraseña", "Error: Datos vacios.", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bntIngresarActionPerformed

    private void bntContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntContinuarActionPerformed
        getOptionPane();
        op.setValue(1);
        accesoConcedido = true;
    }//GEN-LAST:event_bntContinuarActionPerformed

    private void bntAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAceptarActionPerformed
        getOptionPane();
        op.setValue(1);
        accesoConcedido = true;
    }//GEN-LAST:event_bntAceptarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        getOptionPane();
        op.setValue(2);        
    }//GEN-LAST:event_bntCancelarActionPerformed

    
    
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

    public boolean isAccesoConcedido() {
        return accesoConcedido;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.button.ButtonRect bntAceptar;
    private javax.swing.JButton bntCancelar;
    private elaprendiz.gui.button.ButtonRect bntContinuar;
    private javax.swing.JButton bntIngresar;
    private elaprendiz.gui.varios.ClockDigital clockDigital1;
    private javax.swing.JComboBox cmbAlmacen;
    private javax.swing.JComboBox cmbMoneda;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private elaprendiz.gui.label.LabelHeader lblLogo;
    private elaprendiz.gui.panel.PanelCurves panelCurves1;
    private elaprendiz.gui.panel.PanelImage panelImage1;
    private elaprendiz.gui.panel.PanelImage panelImage2;
    private elaprendiz.gui.panel.PanelTranslucido pnlConfig;
    private javax.swing.JPanel pnlLogin;
    private elaprendiz.gui.passwordField.PasswordFieldRectIcon ptxtPass;
    private javax.swing.JFormattedTextField tftTipoCambio;
    private elaprendiz.gui.textField.TextFieldRectIcon txtUsuario;
    // End of variables declaration//GEN-END:variables
}
