package Layouts;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
        setVisible(true);
        setTitle("Registro. v1.0.0");
        setLocationRelativeTo(null);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JLabel();
        FondoColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 360, 150));

        FondoColor.setBackground(new java.awt.Color(255, 102, 102));
        FondoColor.setForeground(new java.awt.Color(255, 137, 30));
        FondoColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Background white.jpg"))); // NOI18N
        getContentPane().add(FondoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel FondoColor;
    // End of variables declaration//GEN-END:variables
}
