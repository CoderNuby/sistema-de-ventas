package Layouts;

import Services.UsuarioCRUD;
import Clases.Start;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import Desvanecimiento.Desvanecimiento;
import Models.Usuario;

public class Login extends javax.swing.JFrame {

    
    UsuarioCRUD usuarioService;
    Desvanecimiento animacion;
    Registrar reg;
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        usuarioService = new UsuarioCRUD();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitulo = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUserName = new javax.swing.JTextField();
        LabelContraseña = new javax.swing.JLabel();
        LabelUserName = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        LabelOff = new javax.swing.JLabel();
        LabelRestaurarContraseña = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTitulo.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("LOGIN");
        getContentPane().add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 350, 47));

        txtPassword.setBackground(new java.awt.Color(41, 41, 41));
        txtPassword.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setText("jPasswordF");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 230, -1));

        txtUserName.setBackground(new java.awt.Color(41, 41, 41));
        txtUserName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(153, 153, 153));
        txtUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUserName.setText("Usuario");
        txtUserName.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 230, -1));

        LabelContraseña.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        LabelContraseña.setForeground(new java.awt.Color(255, 255, 255));
        LabelContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelContraseña.setText("Contraseña");
        getContentPane().add(LabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 350, -1));

        LabelUserName.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        LabelUserName.setForeground(new java.awt.Color(255, 255, 255));
        LabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelUserName.setText("Nombre de usuario");
        getContentPane().add(LabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 350, -1));

        btnRegistrarse.setBackground(new java.awt.Color(41, 41, 41));
        btnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 136, 45));

        btnIngresar.setBackground(new java.awt.Color(41, 41, 41));
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Entrar");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 119, 45));

        LabelOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon off.png"))); // NOI18N
        LabelOff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelOffMouseClicked(evt);
            }
        });
        getContentPane().add(LabelOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        LabelRestaurarContraseña.setForeground(new java.awt.Color(200, 200, 200));
        LabelRestaurarContraseña.setText("¿Olvido su contraseña? Restablecer");
        LabelRestaurarContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelRestaurarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelRestaurarContraseñaMouseClicked(evt);
            }
        });
        getContentPane().add(LabelRestaurarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo log&Reg.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        Timer reloj = new Timer(); //Contador de tiempo
        TimerTask iniciador = new TimerTask() {
            
            //Tarea a ejecutar
            public void run() {
                animacion = new Desvanecimiento();
                animacion.Abrir(Start.getRegistrar(), 15);
                
                Timer reloj = new Timer(); //Contador de tiempo
                TimerTask iniciador = new TimerTask() {

                    //Tarea a ejecutar
                    @Override
                    public void run() {
                        Start.getLogin().setVisible(false);
                    }
                };

                //(Tarea a ejecutar, tiempo de espera)
                reloj.schedule(iniciador, 500); 
                
            }
        };
        
        //(Tarea a ejecutar, tiempo de espera)
        reloj.schedule(iniciador, 500); 
        
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        if(txtUserName.getText().isEmpty()||txtPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo vacio");
            return;
        }
        
        boolean result = usuarioService.login(txtUserName.getText(), txtPassword.getText());
        
        if(result){
            Start.getMenu().setVisible(true);
            Start.getLogin().setVisible(false);
            Start.getMenu().getLblNameUser().setText(usuarioService.usuarioRegistrado.getUserName());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        
    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        if(txtUserName.getText().equalsIgnoreCase("")){
            txtUserName.setForeground(Color.gray);
            txtUserName.setText("Usuario");
        }
    }//GEN-LAST:event_txtUserNameFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if(txtPassword.getText().equalsIgnoreCase("jPasswordF")){
            txtPassword.setForeground(Color.white);
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if(txtPassword.getText().equalsIgnoreCase("")){
            txtPassword.setForeground(Color.gray);
            txtPassword.setText("jPasswordF");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        if(txtUserName.getText().equalsIgnoreCase("Usuario")){
            txtUserName.setForeground(Color.white);
            txtUserName.setText("");
        }
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void LabelOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelOffMouseClicked
        System.exit(0);
    }//GEN-LAST:event_LabelOffMouseClicked

    private void LabelRestaurarContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelRestaurarContraseñaMouseClicked
        
        String nameUser = JOptionPane.showInputDialog(null, "Escriba el nombre de usuario");
        if(nameUser == null)return;
        
        Usuario user = usuarioService.buscarUsuarioByUserName(nameUser);
        
        if(user == null)return;
        
        
        usuarioService.generarCodigoRecuperacion();
        
        
        
        String codigo = JOptionPane.showInputDialog(null, "Inserte el codigo de recuperacion: ");
        
        
        boolean respuesta = usuarioService.compararCodigoRecuperacion(codigo);
        
        if(respuesta){
            String newPassword = JOptionPane.showInputDialog(null, "Nueva contraseña: ");
            if(newPassword == null){
                JOptionPane.showConfirmDialog(null, "Accion cancelada");
            }
            usuarioService.actualizarPassword(user.getId(), newPassword);   
        }else{
            System.err.println("Codigo incorrecto");
        }
        
        
        
    }//GEN-LAST:event_LabelRestaurarContraseñaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LabelContraseña;
    private javax.swing.JLabel LabelOff;
    private javax.swing.JLabel LabelRestaurarContraseña;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelUserName;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
