package Layouts;

import Services.UsuarioCRUD;
import Clases.Start;
import Desvanecimiento.Desvanecimiento;
import Models.Usuario;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Registrar extends javax.swing.JFrame {

    UsuarioCRUD usuarioServices;
    Desvanecimiento animacion;
    public Registrar() throws NoSuchAlgorithmException {
        initComponents();
        setLocationRelativeTo(null);
        usuarioServices = new UsuarioCRUD();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitulo = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        lUsuario = new javax.swing.JLabel();
        lContraseña = new javax.swing.JLabel();
        LabelReturn = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTitulo.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("REGISTRAR");
        getContentPane().add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 350, -1));

        txtUserName.setBackground(new java.awt.Color(41, 41, 41));
        txtUserName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(153, 153, 153));
        txtUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUserName.setText("Usuario");
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 230, -1));

        txtPassword.setBackground(new java.awt.Color(41, 41, 41));
        txtPassword.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setText("0000000000");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 230, -1));

        btnRegistrar.setBackground(new java.awt.Color(41, 41, 41));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 230, 40));

        lUsuario.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lUsuario.setText("Nombre de usuario");
        getContentPane().add(lUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 350, -1));

        lContraseña.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lContraseña.setText("Contraseña");
        getContentPane().add(lContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 350, -1));

        LabelReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Return.png"))); // NOI18N
        LabelReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelReturnMouseClicked(evt);
            }
        });
        getContentPane().add(LabelReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo log&Reg.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        boolean result = false;
        if(txtUserName.getText().isEmpty()||txtPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo vacio");
            return;
        }
        
        try {
            Usuario usuario = new Usuario(0, txtUserName.getText(), txtPassword.getText());
            
            if(usuarioServices.crearUsuario(usuario)){
                result = true;
                JOptionPane.showMessageDialog(null, "Usuario registrado");
            }
        } catch (Exception e) {
        }
        
        if(result){
            animacion = new Desvanecimiento();
            animacion.Abrir(Start.getLogin(), 20);
            
            Timer reloj = new Timer(); //Contador de tiempo
            TimerTask iniciador = new TimerTask() {
            
            //Tarea a ejecutar
            @Override
            public void run() {
                Start.getRegistrar().setVisible(false);
            }
        };
        
            //(Tarea a ejecutar, tiempo de espera)
            System.out.println("aqui toy");
            reloj.schedule(iniciador, 500); 
        }
            
       
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        if(txtUserName.getText().equalsIgnoreCase("Usuario")){
            txtUserName.setForeground(Color.white);
            txtUserName.setText("");
        }
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        if(txtUserName.getText().equalsIgnoreCase("")){
            txtUserName.setForeground(Color.gray);
            txtUserName.setText("Usuario");
        }
    }//GEN-LAST:event_txtUserNameFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if(txtPassword.getText().equalsIgnoreCase("0000000000")){
            txtPassword.setForeground(Color.white);
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if(txtPassword.getText().equalsIgnoreCase("")){
            txtPassword.setForeground(Color.gray);
            txtPassword.setText("0000000000");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void LabelReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelReturnMouseClicked
        animacion = new Desvanecimiento();
        animacion.Abrir(Start.getLogin(), 20);
            
        Timer reloj = new Timer(); //Contador de tiempo
        TimerTask iniciador = new TimerTask() {
            
        //Tarea a ejecutar
        @Override
        public void run() {
            Start.getRegistrar().setVisible(false);
        }
    };
        
        //(Tarea a ejecutar, tiempo de espera)
        reloj.schedule(iniciador, 500); 
    }//GEN-LAST:event_LabelReturnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LabelReturn;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lContraseña;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
