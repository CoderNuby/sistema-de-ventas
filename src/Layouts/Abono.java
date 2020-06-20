package Layouts;

import Clases.Start;
import Desvanecimiento.Desvanecimiento;
import Models.Cliente;
import Models.Pago;
import Services.ClienteCRUD;
import Services.PagosCRUD;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Abono extends javax.swing.JFrame {

    public Abono() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private Cliente cliente;
    
    private float pago = 0;
    private String pagoString = "";
    
    
    Desvanecimiento animacion;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitulo = new javax.swing.JLabel();
        LabelNombreCliente = new javax.swing.JLabel();
        LabelD = new javax.swing.JLabel();
        LabelDeuda = new javax.swing.JLabel();
        LabelCantidadAbonar = new javax.swing.JLabel();
        TextFieldAbono = new javax.swing.JTextField();
        ButFinAbono = new javax.swing.JButton();
        LabelReturn = new javax.swing.JLabel();
        mensageValoreNumericos = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(350, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTitulo.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("ABONO");
        getContentPane().add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 350, 40));

        LabelNombreCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        LabelNombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNombreCliente.setText("Nombre del cliente");
        getContentPane().add(LabelNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 350, -1));

        LabelD.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelD.setForeground(new java.awt.Color(255, 255, 255));
        LabelD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelD.setText("Deuda");
        getContentPane().add(LabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 350, -1));

        LabelDeuda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelDeuda.setForeground(new java.awt.Color(200, 200, 200));
        LabelDeuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDeuda.setText("5000$");
        getContentPane().add(LabelDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 350, -1));

        LabelCantidadAbonar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelCantidadAbonar.setForeground(new java.awt.Color(255, 255, 255));
        LabelCantidadAbonar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCantidadAbonar.setText("Cantidad para abonar");
        getContentPane().add(LabelCantidadAbonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 270, 360, -1));

        TextFieldAbono.setBackground(new java.awt.Color(41, 41, 41));
        TextFieldAbono.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TextFieldAbono.setForeground(new java.awt.Color(200, 200, 200));
        TextFieldAbono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldAbono.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TextFieldAbonoCaretUpdate(evt);
            }
        });
        TextFieldAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldAbonoActionPerformed(evt);
            }
        });
        getContentPane().add(TextFieldAbono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 190, -1));

        ButFinAbono.setBackground(new java.awt.Color(41, 41, 41));
        ButFinAbono.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ButFinAbono.setForeground(new java.awt.Color(255, 255, 255));
        ButFinAbono.setText("Realizar abono");
        ButFinAbono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButFinAbono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButFinAbonoMouseClicked(evt);
            }
        });
        getContentPane().add(ButFinAbono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 387, 150, 50));

        LabelReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Return.png"))); // NOI18N
        LabelReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelReturnMouseClicked(evt);
            }
        });
        getContentPane().add(LabelReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        mensageValoreNumericos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(mensageValoreNumericos, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 340, 190, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo log&Reg.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldAbonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldAbonoActionPerformed

    private void ButFinAbonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButFinAbonoMouseClicked
        if(pago == 0){
            this.dispose();
            return;
        }
        
        Pago pg = new Pago(0, cliente.getId(), pago, Start.getMenu().getFecha());
        
        new PagosCRUD().realizarPago(pg);
        
        Start.getMenu().setearDatosPuntoVenta();
        pago = 0;
        pagoString = "";
        Start.getMenu().clientePuntoVenta = null;
        Start.getMenu().tablaMostrarCliente.updateClientesTableAllColumns(new ClienteCRUD().getClientes());
        Start.getMenu().tablaPuntoVentas.updateClientesTable(new ClienteCRUD().getClientes());
        
        this.dispose();
        
        this.dispose();
    }//GEN-LAST:event_ButFinAbonoMouseClicked

    private void LabelReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelReturnMouseClicked

        this.dispose();
    }//GEN-LAST:event_LabelReturnMouseClicked

    private void TextFieldAbonoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TextFieldAbonoCaretUpdate
        // TODO add your handling code here:
        if(TextFieldAbono.getText().isEmpty()){
            LabelDeuda.setText("$"+cliente.getDeuda());
            return;
        }
        pagoString = TextFieldAbono.getText();
        pago = Float.parseFloat(pagoString);
        LabelDeuda.setText("$"+(cliente.getDeuda() - pago));
    }//GEN-LAST:event_TextFieldAbonoCaretUpdate


     ///////////////////////////////////////////////////////////////
    
    public void setCliente(Cliente cli){
        this.cliente = cli;
        LabelDeuda.setText("$"+Float.toString(cliente.getDeuda()));
        TextFieldAbono.setText("");
        LabelNombreCliente.setText(cliente.getNombreCliente());
        verificarValoreNumericos();
    }
    
    public void verificarValoreNumericos() {
        mensageValoreNumericos.setForeground(Color.red);
        TextFieldAbono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = TextFieldAbono.getText();
                int a = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')||ke.getKeyCode() == 8) {
                    String valor = value + ke.getKeyChar();
                    if((Float.parseFloat(valor) <= cliente.getDeuda()) && pagoString.length() < 37){
                        TextFieldAbono.setEditable(true);
                        mensageValoreNumericos.setText("");
                        System.out.println(1);
                        return;
                    }
                }
                TextFieldAbono.setEditable(false);
                mensageValoreNumericos.setText("* Transaccion no valida");
            }
        });
        setVisible(true);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButFinAbono;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LabelCantidadAbonar;
    private javax.swing.JLabel LabelD;
    private javax.swing.JLabel LabelDeuda;
    private javax.swing.JLabel LabelNombreCliente;
    private javax.swing.JLabel LabelReturn;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JTextField TextFieldAbono;
    private javax.swing.JLabel mensageValoreNumericos;
    // End of variables declaration//GEN-END:variables
}
