package Layouts;

import Clases.Start;
import Services.ClienteCRUD;
import Clases.TablaClientes;
import Desvanecimiento.Desvanecimiento;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import Models.Cliente;
import Models.Pago;
import Models.Venta;
import Services.PagosCRUD;
import Services.UsuarioCRUD;
import Services.VentasCRUD;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//Clase menu
public class Menu extends javax.swing.JFrame {
    
    CardLayout cardLayout;
    
    //Variables de asignacion.
    String LNombre = "Nombres y apellidos";
    String LApellidos = "Apellidos";
    String LNumeroCel = "Numero celular";
    String LNombreCom = "Nombre de la compañia";
    String LCiudad = "Ciudad";
    String LDireccion = "Direccion";
    String LValVentas = "Precio de venta";
    
    Cliente clienteEditable = null;
    Cliente clientePuntoVenta;//Cliente temporal para punto de venta
    
    ClienteCRUD clienteServices;
    VentasCRUD ventasServices;
    PagosCRUD pagosServices;
    
    /*TABLAS*/
    TablaClientes tablaMostrarCliente;
    TablaClientes tablaPuntoVentas;
    
    Venta preventa = null;
    Pago prepago = null;
    
    
    //Datos de pagos y venta
    float montoPagarTon = 0;
    float montoPagarSaco = 0;
    float cambio = 0;
    float deudaTotal = 0;
    float pago = 0;
    
    //Ventana de abono
    Abono abono = new Abono();
    
    
    //Constructor
    public Menu() {
        initComponents();
        setTitle("Gestor apache v1.0.0"); 
        setLocationRelativeTo(null);
        
        //(Referencia al panel princial)(Nombre Card)
        cardLayout = (CardLayout)(panel.getLayout());
        
        clienteServices = new ClienteCRUD();
        ventasServices = new VentasCRUD();
        pagosServices = new PagosCRUD();
        
        
        
        /*TABLAS*/
        tablaMostrarCliente = new TablaClientes(tblClientes);
        tablaMostrarCliente.cargarClientesTableAllColumns(clienteServices.getClientes());
        
        tablaPuntoVentas = new TablaClientes(tblPuntoVentas);
        tablaPuntoVentas.cargarClientesTable(clienteServices.getClientes());
        
        
        //Setear los datos de la tabla al iniciar el programa
        setearDatosPuntoVenta();
    }
    
    public String getFecha(){
        
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    
    public JLabel getLblNameUser(){
        return lblNameUser;
    }
    
    
    
        
    //Inicio de los componentes graficos
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Toggle = new javax.swing.JPanel();
        iInfo = new javax.swing.JLabel();
        iAddUser = new javax.swing.JLabel();
        iShowUser = new javax.swing.JLabel();
        lShowUser = new javax.swing.JLabel();
        lAddUser = new javax.swing.JLabel();
        iHome = new javax.swing.JLabel();
        lHome = new javax.swing.JLabel();
        iEditUser = new javax.swing.JLabel();
        lEditUser = new javax.swing.JLabel();
        lTitulo1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        pHome = new javax.swing.JPanel();
        TablaClientes = new javax.swing.JScrollPane();
        tblPuntoVentas = new javax.swing.JTable();
        sacoIncrementador = new javax.swing.JSpinner();
        lblNameUser = new javax.swing.JLabel();
        pv_Info = new javax.swing.JLabel();
        pv_lblNombreCliente = new javax.swing.JLabel();
        pv_lblAdeudoCliente = new javax.swing.JLabel();
        pv_lblDeudaTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pv_lblMontoPagar = new javax.swing.JLabel();
        pv_lblVentaSaco = new javax.swing.JLabel();
        LabelNumeroSacos = new javax.swing.JLabel();
        LabelMontoApagar = new javax.swing.JLabel();
        pv_btnRealizarTransaccion = new javax.swing.JButton();
        pv_btnCancelarTransaccion = new javax.swing.JButton();
        pv_lblCompañia = new javax.swing.JLabel();
        pv_ButModVen = new javax.swing.JButton();
        ButAbonar = new javax.swing.JButton();
        LabelNumToneladas = new javax.swing.JLabel();
        sacoIncrementadorTon = new javax.swing.JSpinner();
        pAddUser = new javax.swing.JPanel();
        lTituloAddUser = new javax.swing.JLabel();
        textFieldNombreCliente = new javax.swing.JTextField();
        textFieldCiudad = new javax.swing.JTextField();
        textFieldPrecioVentaSaco = new javax.swing.JTextField();
        textFieldNombreEmpresa = new javax.swing.JTextField();
        ButTerminarRegistro = new javax.swing.JToggleButton();
        lFondoAddUser = new javax.swing.JLabel();
        pShowUser = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnEditarCliente = new javax.swing.JButton();
        btnBorrarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lTitulo = new javax.swing.JLabel();
        pEditUser = new javax.swing.JPanel();
        lNombreEdit = new javax.swing.JLabel();
        lFondoAddUser2 = new javax.swing.JLabel();
        lContraseñaEdit = new javax.swing.JLabel();
        TextFieldNewName = new javax.swing.JTextField();
        ButFinishEdition = new javax.swing.JButton();
        lTituloAddUser2 = new javax.swing.JLabel();
        TextFieldNewPassword = new javax.swing.JPasswordField();
        pEditClient = new javax.swing.JPanel();
        textFieldNombreClienteActualizar = new javax.swing.JTextField();
        textFieldCiudadActualizar = new javax.swing.JTextField();
        textFieldPrecioVentaSacoActualizar = new javax.swing.JTextField();
        textFieldNombreEmpresaActualizar = new javax.swing.JTextField();
        btnActualizarCliente = new javax.swing.JToggleButton();
        lTituloAddUser1 = new javax.swing.JLabel();
        lFondoAddUser1 = new javax.swing.JLabel();
        pInfo = new javax.swing.JPanel();
        lTituloInfo = new javax.swing.JLabel();
        lIcon = new javax.swing.JLabel();
        lTituloInfo4 = new javax.swing.JLabel();
        lTituloInfo7 = new javax.swing.JLabel();
        lTituloInfo8 = new javax.swing.JLabel();
        lTituloInfo9 = new javax.swing.JLabel();
        lTituloInfo10 = new javax.swing.JLabel();
        lTituloInfo11 = new javax.swing.JLabel();
        lTituloInfo12 = new javax.swing.JLabel();
        lTituloInfo13 = new javax.swing.JLabel();
        lTituloInfo14 = new javax.swing.JLabel();
        lTituloInfo15 = new javax.swing.JLabel();
        lTituloInfo16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Toggle.setBackground(new java.awt.Color(246, 94, 45));
        Toggle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon info.png"))); // NOI18N
        iInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iInfoMouseClicked(evt);
            }
        });
        Toggle.add(iInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        iAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon add user.png"))); // NOI18N
        iAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iAddUserMouseClicked(evt);
            }
        });
        Toggle.add(iAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        iShowUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon show user.png"))); // NOI18N
        iShowUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iShowUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iShowUserMouseClicked(evt);
            }
        });
        Toggle.add(iShowUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        lShowUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lShowUser.setForeground(new java.awt.Color(255, 255, 255));
        lShowUser.setText("Mostrar cliente");
        lShowUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lShowUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lShowUserMouseClicked(evt);
            }
        });
        Toggle.add(lShowUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 130, 50));

        lAddUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lAddUser.setForeground(new java.awt.Color(255, 255, 255));
        lAddUser.setText("Nuevo cliente");
        lAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAddUserMouseClicked(evt);
            }
        });
        Toggle.add(lAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 140, 40));

        iHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon shop.png"))); // NOI18N
        iHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iHomeMouseClicked(evt);
            }
        });
        Toggle.add(iHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lHome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lHome.setForeground(new java.awt.Color(255, 255, 255));
        lHome.setText("Punto de venta");
        lHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lHomeMouseClicked(evt);
            }
        });
        Toggle.add(lHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 140, 40));

        iEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon editUser.png"))); // NOI18N
        iEditUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iEditUserMouseClicked(evt);
            }
        });
        Toggle.add(iEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        lEditUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lEditUser.setForeground(new java.awt.Color(255, 255, 255));
        lEditUser.setText("Editar usuario");
        lEditUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEditUserMouseClicked(evt);
            }
        });
        Toggle.add(lEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 130, 50));

        lTitulo1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lTitulo1.setText("GESTOR APACHE");
        Toggle.add(lTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 170, 40));

        getContentPane().add(Toggle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 600));

        panel.setMinimumSize(new java.awt.Dimension(0, 0));
        panel.setLayout(new java.awt.CardLayout());

        pHome.setBackground(new java.awt.Color(51, 51, 51));
        pHome.setForeground(new java.awt.Color(51, 51, 51));
        pHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPuntoVentas.setForeground(new java.awt.Color(51, 51, 51));
        tblPuntoVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPuntoVentas.setToolTipText("");
        tblPuntoVentas.setGridColor(new java.awt.Color(51, 51, 51));
        tblPuntoVentas.getTableHeader().setReorderingAllowed(false);
        tblPuntoVentas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblPuntoVentasFocusLost(evt);
            }
        });
        tblPuntoVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPuntoVentasMouseClicked(evt);
            }
        });
        TablaClientes.setViewportView(tblPuntoVentas);

        pHome.add(TablaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 560, 160));

        sacoIncrementador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sacoIncrementador.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sacoIncrementadorStateChanged(evt);
            }
        });
        sacoIncrementador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sacoIncrementadorMouseClicked(evt);
            }
        });
        pHome.add(sacoIncrementador, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 120, 30));

        lblNameUser.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNameUser.setForeground(new java.awt.Color(255, 255, 255));
        lblNameUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameUser.setText("Name User");
        lblNameUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNameUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNameUserMouseClicked(evt);
            }
        });
        pHome.add(lblNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 580, 40));

        pv_Info.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pv_Info.setForeground(new java.awt.Color(255, 255, 255));
        pv_Info.setText("Informacion del cliente");
        pv_Info.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pv_Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pv_InfoMouseClicked(evt);
            }
        });
        pHome.add(pv_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 220, 60));

        pv_lblNombreCliente.setBackground(new java.awt.Color(41, 41, 41));
        pv_lblNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pv_lblNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        pv_lblNombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pv_lblNombreCliente.setText("Nombre:");
        pv_lblNombreCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pv_lblNombreCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pv_lblNombreClienteMouseClicked(evt);
            }
        });
        pHome.add(pv_lblNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 320, 30));

        pv_lblAdeudoCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pv_lblAdeudoCliente.setForeground(new java.awt.Color(255, 255, 255));
        pv_lblAdeudoCliente.setText("Adeudo:");
        pv_lblAdeudoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pv_lblAdeudoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pv_lblAdeudoClienteMouseClicked(evt);
            }
        });
        pHome.add(pv_lblAdeudoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 310, 30));

        pv_lblDeudaTotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        pv_lblDeudaTotal.setForeground(new java.awt.Color(255, 255, 255));
        pv_lblDeudaTotal.setText("$0.0");
        pHome.add(pv_lblDeudaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  Deuda total ");
        pHome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 500, 80, -1));

        pv_lblMontoPagar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        pv_lblMontoPagar.setForeground(new java.awt.Color(255, 255, 255));
        pv_lblMontoPagar.setText("$0.0");
        pHome.add(pv_lblMontoPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, -1));

        pv_lblVentaSaco.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pv_lblVentaSaco.setForeground(new java.awt.Color(255, 255, 255));
        pv_lblVentaSaco.setText("Venta saco:");
        pv_lblVentaSaco.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pv_lblVentaSaco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pv_lblVentaSacoMouseClicked(evt);
            }
        });
        pHome.add(pv_lblVentaSaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 310, 30));

        LabelNumeroSacos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LabelNumeroSacos.setForeground(new java.awt.Color(255, 255, 255));
        LabelNumeroSacos.setText("Numero de sacos");
        pHome.add(LabelNumeroSacos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, -1, -1));

        LabelMontoApagar.setForeground(new java.awt.Color(255, 255, 255));
        LabelMontoApagar.setText("Monto a pagar");
        pHome.add(LabelMontoApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        pv_btnRealizarTransaccion.setBackground(new java.awt.Color(41, 41, 41));
        pv_btnRealizarTransaccion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pv_btnRealizarTransaccion.setForeground(new java.awt.Color(255, 255, 255));
        pv_btnRealizarTransaccion.setText("Realizar compa");
        pv_btnRealizarTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pv_btnRealizarTransaccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pv_btnRealizarTransaccionMouseClicked(evt);
            }
        });
        pv_btnRealizarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pv_btnRealizarTransaccionActionPerformed(evt);
            }
        });
        pHome.add(pv_btnRealizarTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, -1, -1));

        pv_btnCancelarTransaccion.setBackground(new java.awt.Color(41, 41, 41));
        pv_btnCancelarTransaccion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pv_btnCancelarTransaccion.setForeground(new java.awt.Color(255, 255, 255));
        pv_btnCancelarTransaccion.setText("Limpiar campos");
        pv_btnCancelarTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pv_btnCancelarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pv_btnCancelarTransaccionActionPerformed(evt);
            }
        });
        pHome.add(pv_btnCancelarTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        pv_lblCompañia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pv_lblCompañia.setForeground(new java.awt.Color(255, 255, 255));
        pv_lblCompañia.setText("Compañia:");
        pv_lblCompañia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pHome.add(pv_lblCompañia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 320, 20));

        pv_ButModVen.setBackground(new java.awt.Color(41, 41, 41));
        pv_ButModVen.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pv_ButModVen.setForeground(new java.awt.Color(255, 255, 255));
        pv_ButModVen.setText("Modificar precio de venta");
        pv_ButModVen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pv_ButModVen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pv_ButModVenMouseClicked(evt);
            }
        });
        pHome.add(pv_ButModVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        ButAbonar.setBackground(new java.awt.Color(41, 41, 41));
        ButAbonar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ButAbonar.setForeground(new java.awt.Color(255, 255, 255));
        ButAbonar.setText("Abonar a cuenta");
        ButAbonar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButAbonar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButAbonarMouseClicked(evt);
            }
        });
        pHome.add(ButAbonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 150, -1));

        LabelNumToneladas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LabelNumToneladas.setForeground(new java.awt.Color(255, 255, 255));
        LabelNumToneladas.setText("Numero de toneladas");
        pHome.add(LabelNumToneladas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        sacoIncrementadorTon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sacoIncrementadorTon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sacoIncrementadorTonStateChanged(evt);
            }
        });
        sacoIncrementadorTon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sacoIncrementadorTonMouseClicked(evt);
            }
        });
        pHome.add(sacoIncrementadorTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 120, 30));

        panel.add(pHome, "cHome");

        pAddUser.setBackground(new java.awt.Color(51, 51, 51));
        pAddUser.setForeground(new java.awt.Color(51, 51, 51));
        pAddUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lTituloAddUser.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lTituloAddUser.setForeground(new java.awt.Color(255, 255, 255));
        lTituloAddUser.setText("Crear cliente ");
        pAddUser.add(lTituloAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        textFieldNombreCliente.setBackground(new java.awt.Color(41, 41, 41));
        textFieldNombreCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldNombreCliente.setForeground(new java.awt.Color(153, 153, 153));
        textFieldNombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldNombreCliente.setText("Nombres y apellidos");
        textFieldNombreCliente.setToolTipText("");
        textFieldNombreCliente.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldNombreCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldNombreCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldNombreClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldNombreClienteFocusLost(evt);
            }
        });
        textFieldNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreClienteActionPerformed(evt);
            }
        });
        pAddUser.add(textFieldNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 250, 50));

        textFieldCiudad.setBackground(new java.awt.Color(41, 41, 41));
        textFieldCiudad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldCiudad.setForeground(new java.awt.Color(153, 153, 153));
        textFieldCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCiudad.setText("Ciudad");
        textFieldCiudad.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldCiudad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldCiudadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldCiudadFocusLost(evt);
            }
        });
        pAddUser.add(textFieldCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 520, 50));

        textFieldPrecioVentaSaco.setBackground(new java.awt.Color(41, 41, 41));
        textFieldPrecioVentaSaco.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldPrecioVentaSaco.setForeground(new java.awt.Color(153, 153, 153));
        textFieldPrecioVentaSaco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldPrecioVentaSaco.setText("Precio de venta");
        textFieldPrecioVentaSaco.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldPrecioVentaSaco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldPrecioVentaSacoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldPrecioVentaSacoFocusLost(evt);
            }
        });
        pAddUser.add(textFieldPrecioVentaSaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 520, 50));

        textFieldNombreEmpresa.setBackground(new java.awt.Color(41, 41, 41));
        textFieldNombreEmpresa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldNombreEmpresa.setForeground(new java.awt.Color(153, 153, 153));
        textFieldNombreEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldNombreEmpresa.setText("Nombre de la compañia");
        textFieldNombreEmpresa.setToolTipText("");
        textFieldNombreEmpresa.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldNombreEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldNombreEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldNombreEmpresaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldNombreEmpresaFocusLost(evt);
            }
        });
        textFieldNombreEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreEmpresaActionPerformed(evt);
            }
        });
        pAddUser.add(textFieldNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 260, 50));

        ButTerminarRegistro.setBackground(new java.awt.Color(41, 41, 41));
        ButTerminarRegistro.setForeground(new java.awt.Color(255, 255, 255));
        ButTerminarRegistro.setText("Registrar");
        ButTerminarRegistro.setToolTipText("");
        ButTerminarRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButTerminarRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButTerminarRegistroMouseClicked(evt);
            }
        });
        ButTerminarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButTerminarRegistroActionPerformed(evt);
            }
        });
        pAddUser.add(ButTerminarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 230, 40));

        lFondoAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        pAddUser.add(lFondoAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 340, 100));

        panel.add(pAddUser, "cAddUser");

        pShowUser.setBackground(new java.awt.Color(51, 51, 51));
        pShowUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblClientes.setRowHeight(30);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblClientes);

        pShowUser.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 580, 330));

        btnEditarCliente.setBackground(new java.awt.Color(41, 41, 41));
        btnEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setText("Editar");
        btnEditarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarClienteMouseClicked(evt);
            }
        });
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        pShowUser.add(btnEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 230, 40));

        btnBorrarCliente.setBackground(new java.awt.Color(41, 41, 41));
        btnBorrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarCliente.setText("Borrar");
        btnBorrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarClienteActionPerformed(evt);
            }
        });
        pShowUser.add(btnBorrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 250, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Control de clientes");
        pShowUser.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 580, -1));

        lTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitulo.setText("Clientes registrados");
        pShowUser.add(lTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 580, 40));

        panel.add(pShowUser, "cShowUser");

        pEditUser.setBackground(new java.awt.Color(51, 51, 51));
        pEditUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lNombreEdit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lNombreEdit.setForeground(new java.awt.Color(255, 255, 255));
        lNombreEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lNombreEdit.setText("Nombre nuevo");
        pEditUser.add(lNombreEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 600, -1));

        lFondoAddUser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        pEditUser.add(lFondoAddUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 340, 100));

        lContraseñaEdit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lContraseñaEdit.setForeground(new java.awt.Color(255, 255, 255));
        lContraseñaEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lContraseñaEdit.setText("Contraseña nueva");
        pEditUser.add(lContraseñaEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 600, -1));

        TextFieldNewName.setBackground(new java.awt.Color(41, 41, 41));
        TextFieldNewName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldNewName.setForeground(new java.awt.Color(153, 153, 153));
        TextFieldNewName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldNewName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldNewNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFieldNewNameFocusLost(evt);
            }
        });
        pEditUser.add(TextFieldNewName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 410, -1));

        ButFinishEdition.setBackground(new java.awt.Color(41, 41, 41));
        ButFinishEdition.setForeground(new java.awt.Color(255, 255, 255));
        ButFinishEdition.setText("Finalizar edición");
        ButFinishEdition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButFinishEdition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButFinishEditionMouseClicked(evt);
            }
        });
        ButFinishEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButFinishEditionActionPerformed(evt);
            }
        });
        pEditUser.add(ButFinishEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 350, -1));

        lTituloAddUser2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lTituloAddUser2.setForeground(new java.awt.Color(255, 255, 255));
        lTituloAddUser2.setText("Editar usuario");
        pEditUser.add(lTituloAddUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        TextFieldNewPassword.setBackground(new java.awt.Color(41, 41, 41));
        TextFieldNewPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldNewPassword.setForeground(new java.awt.Color(153, 153, 153));
        TextFieldNewPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pEditUser.add(TextFieldNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 410, -1));

        panel.add(pEditUser, "cEditUser");

        pEditClient.setBackground(new java.awt.Color(51, 51, 51));
        pEditClient.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textFieldNombreClienteActualizar.setBackground(new java.awt.Color(41, 41, 41));
        textFieldNombreClienteActualizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldNombreClienteActualizar.setForeground(new java.awt.Color(255, 255, 255));
        textFieldNombreClienteActualizar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldNombreClienteActualizar.setText("Nombres y apellidos");
        textFieldNombreClienteActualizar.setToolTipText("");
        textFieldNombreClienteActualizar.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldNombreClienteActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldNombreClienteActualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldNombreClienteActualizarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldNombreClienteActualizarFocusLost(evt);
            }
        });
        pEditClient.add(textFieldNombreClienteActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 250, 50));

        textFieldCiudadActualizar.setBackground(new java.awt.Color(41, 41, 41));
        textFieldCiudadActualizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldCiudadActualizar.setForeground(new java.awt.Color(255, 255, 255));
        textFieldCiudadActualizar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCiudadActualizar.setText("Ciudad");
        textFieldCiudadActualizar.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldCiudadActualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldCiudadActualizarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldCiudadActualizarFocusLost(evt);
            }
        });
        pEditClient.add(textFieldCiudadActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 520, 50));

        textFieldPrecioVentaSacoActualizar.setBackground(new java.awt.Color(41, 41, 41));
        textFieldPrecioVentaSacoActualizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldPrecioVentaSacoActualizar.setForeground(new java.awt.Color(255, 255, 255));
        textFieldPrecioVentaSacoActualizar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldPrecioVentaSacoActualizar.setText("Precio de venta");
        textFieldPrecioVentaSacoActualizar.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldPrecioVentaSacoActualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldPrecioVentaSacoActualizarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldPrecioVentaSacoActualizarFocusLost(evt);
            }
        });
        pEditClient.add(textFieldPrecioVentaSacoActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 520, 50));

        textFieldNombreEmpresaActualizar.setBackground(new java.awt.Color(41, 41, 41));
        textFieldNombreEmpresaActualizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldNombreEmpresaActualizar.setForeground(new java.awt.Color(255, 255, 255));
        textFieldNombreEmpresaActualizar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldNombreEmpresaActualizar.setText("Nombre de la compañia");
        textFieldNombreEmpresaActualizar.setToolTipText("");
        textFieldNombreEmpresaActualizar.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldNombreEmpresaActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldNombreEmpresaActualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldNombreEmpresaActualizarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldNombreEmpresaActualizarFocusLost(evt);
            }
        });
        textFieldNombreEmpresaActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreEmpresaActualizarActionPerformed(evt);
            }
        });
        pEditClient.add(textFieldNombreEmpresaActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 260, 50));

        btnActualizarCliente.setBackground(new java.awt.Color(41, 41, 41));
        btnActualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCliente.setText("Actualizar cliente");
        btnActualizarCliente.setToolTipText("");
        btnActualizarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarClienteMouseClicked(evt);
            }
        });
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });
        pEditClient.add(btnActualizarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 230, 40));

        lTituloAddUser1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lTituloAddUser1.setForeground(new java.awt.Color(255, 255, 255));
        lTituloAddUser1.setText("Actualizar Cliente");
        pEditClient.add(lTituloAddUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        lFondoAddUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        pEditClient.add(lFondoAddUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 340, 100));

        panel.add(pEditClient, "cShop");

        pInfo.setBackground(new java.awt.Color(51, 51, 51));
        pInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lTituloInfo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo.setForeground(new java.awt.Color(255, 255, 255));
        lTituloInfo.setText("Version actual: v1.0.0.");
        pInfo.add(lTituloInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        lIcon.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lIcon.setForeground(new java.awt.Color(255, 255, 255));
        lIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono gestor apache.png"))); // NOI18N
        pInfo.add(lIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lTituloInfo4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lTituloInfo4.setForeground(new java.awt.Color(255, 255, 255));
        lTituloInfo4.setText("Informacion de Gestor apache");
        pInfo.add(lTituloInfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 50));

        lTituloInfo7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lTituloInfo7.setForeground(new java.awt.Color(255, 255, 255));
        lTituloInfo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo7.setText("Informacion del equipo desarrollador");
        pInfo.add(lTituloInfo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 600, -1));

        lTituloInfo8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo8.setForeground(new java.awt.Color(200, 200, 200));
        lTituloInfo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo8.setText("Moreno Moreno Luis Carlos.");
        pInfo.add(lTituloInfo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 600, -1));

        lTituloInfo9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo9.setForeground(new java.awt.Color(255, 255, 255));
        lTituloInfo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo9.setText("Interfaz grafica");
        pInfo.add(lTituloInfo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 600, -1));

        lTituloInfo10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo10.setForeground(new java.awt.Color(255, 255, 255));
        lTituloInfo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo10.setText("Base de datos");
        pInfo.add(lTituloInfo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 600, -1));

        lTituloInfo11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo11.setForeground(new java.awt.Color(255, 255, 255));
        lTituloInfo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo11.setText("Nombre del equipo: SonTech");
        pInfo.add(lTituloInfo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 600, -1));

        lTituloInfo12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo12.setForeground(new java.awt.Color(200, 200, 200));
        lTituloInfo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo12.setText("Estrella Soto Nelson Javier.");
        pInfo.add(lTituloInfo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 600, -1));

        lTituloInfo13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo13.setForeground(new java.awt.Color(255, 255, 255));
        lTituloInfo13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo13.setText("Codigo fuente");
        pInfo.add(lTituloInfo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 600, -1));

        lTituloInfo14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo14.setForeground(new java.awt.Color(255, 255, 255));
        lTituloInfo14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo14.setText("Estudio y logistica");
        pInfo.add(lTituloInfo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 600, -1));

        lTituloInfo15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo15.setForeground(new java.awt.Color(200, 200, 200));
        lTituloInfo15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo15.setText("Rodríguez carrillo Luis armando.");
        pInfo.add(lTituloInfo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 600, -1));

        lTituloInfo16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lTituloInfo16.setForeground(new java.awt.Color(200, 200, 200));
        lTituloInfo16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloInfo16.setText("Leyva Castelo Heriberto.");
        pInfo.add(lTituloInfo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 600, -1));

        panel.add(pInfo, "cInfo");

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iAddUserMouseClicked
        cardLayout.show(panel, "cAddUser");
    }//GEN-LAST:event_iAddUserMouseClicked
    
    private void iHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iHomeMouseClicked
        cardLayout.show(panel, "cHome");
    }//GEN-LAST:event_iHomeMouseClicked

    private void iShowUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iShowUserMouseClicked
        cardLayout.show(panel, "cShowUser");
    }//GEN-LAST:event_iShowUserMouseClicked

    private void lHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lHomeMouseClicked
        cardLayout.show(panel, "cHome");
    }//GEN-LAST:event_lHomeMouseClicked

    private void lShowUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lShowUserMouseClicked
        cardLayout.show(panel, "cShowUser");
    }//GEN-LAST:event_lShowUserMouseClicked

    private void lAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAddUserMouseClicked
        cardLayout.show(panel, "cAddUser");
    }//GEN-LAST:event_lAddUserMouseClicked

    private void iInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iInfoMouseClicked
        cardLayout.show(panel, "cInfo");
    }//GEN-LAST:event_iInfoMouseClicked

    private void textFieldNombreClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNombreClienteFocusLost
        if(textFieldNombreCliente.getText().equalsIgnoreCase("")){
            textFieldNombreCliente.setForeground(Color.gray);
            textFieldNombreCliente.setText(LNombre);
        }
    }//GEN-LAST:event_textFieldNombreClienteFocusLost

    private void textFieldCiudadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldCiudadFocusGained
        if(textFieldCiudad.getText().equalsIgnoreCase(LCiudad)){
            textFieldCiudad.setForeground(Color.white);
            textFieldCiudad.setText("");
        }
    }//GEN-LAST:event_textFieldCiudadFocusGained

    private void textFieldCiudadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldCiudadFocusLost
        if(textFieldCiudad.getText().equalsIgnoreCase("")){
            textFieldCiudad.setForeground(Color.gray);
            textFieldCiudad.setText(LCiudad);
        }
    }//GEN-LAST:event_textFieldCiudadFocusLost

    private void textFieldPrecioVentaSacoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPrecioVentaSacoFocusGained
        if(textFieldPrecioVentaSaco.getText().equalsIgnoreCase(LValVentas)){
            textFieldPrecioVentaSaco.setForeground(Color.white);
            textFieldPrecioVentaSaco.setText("");
        }
    }//GEN-LAST:event_textFieldPrecioVentaSacoFocusGained

    private void textFieldPrecioVentaSacoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPrecioVentaSacoFocusLost
        if(textFieldPrecioVentaSaco.getText().equalsIgnoreCase("")){
            textFieldPrecioVentaSaco.setForeground(Color.gray);
            textFieldPrecioVentaSaco.setText(LValVentas);
        }
    }//GEN-LAST:event_textFieldPrecioVentaSacoFocusLost

    //Registrar cliente
    private void ButTerminarRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButTerminarRegistroMouseClicked
        
        
        try {
            
            Cliente cliente = new Cliente(
                0,
                textFieldNombreCliente.getText(),
                textFieldNombreEmpresa.getText(),
                textFieldCiudad.getText(),
                0,
                Float.parseFloat(textFieldPrecioVentaSaco.getText())
            );
            
            clienteServices.crearCliente(cliente);
            
            JOptionPane.showMessageDialog(null, "¡Cliente registrado!");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al crear cliente");
        
        }
        tablaMostrarCliente.updateClientesTableAllColumns(clienteServices.getClientes());
        tablaPuntoVentas.updateClientesTable(clienteServices.getClientes());
        
        
        textFieldNombreCliente.setForeground(Color.GRAY);
        textFieldNombreCliente.setText(LNombre);
        textFieldNombreEmpresa.setForeground(Color.GRAY);
        textFieldNombreEmpresa.setText(LNombreCom);
        textFieldCiudad.setForeground(Color.GRAY);
        textFieldCiudad.setText(LCiudad);
        textFieldPrecioVentaSaco.setForeground(Color.GRAY);
        textFieldPrecioVentaSaco.setText(LValVentas);
        
        
    }//GEN-LAST:event_ButTerminarRegistroMouseClicked
    //Registrar cliente
    
    private void textFieldNombreEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNombreEmpresaFocusLost
        if(textFieldNombreEmpresa.getText().equalsIgnoreCase("")){
            textFieldNombreEmpresa.setForeground(Color.gray);
            textFieldNombreEmpresa.setText(LNombreCom);
        }
    }//GEN-LAST:event_textFieldNombreEmpresaFocusLost

    private void textFieldNombreEmpresaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNombreEmpresaFocusGained
        if(textFieldNombreEmpresa.getText().equalsIgnoreCase(LNombreCom)){
            textFieldNombreEmpresa.setForeground(Color.white);
            textFieldNombreEmpresa.setText("");
        }
    }//GEN-LAST:event_textFieldNombreEmpresaFocusGained

    private void textFieldNombreClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNombreClienteFocusGained
        if(textFieldNombreCliente.getText().equalsIgnoreCase(LNombre)){
            textFieldNombreCliente.setForeground(Color.white);
            textFieldNombreCliente.setText("");
        }
    }//GEN-LAST:event_textFieldNombreClienteFocusGained

    private void ButTerminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButTerminarRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButTerminarRegistroActionPerformed

    private void btnBorrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarClienteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        
        try {
            int SelectedRowIndex = tblClientes.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(SelectedRowIndex, 0).toString());
            if(SelectedRowIndex == -1){
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
                return;
            }
            int eleccion = clienteServices.borrarClienteByClave(id);
            if(eleccion == 0)model.removeRow(SelectedRowIndex);
            tablaPuntoVentas.updateClientesTable(clienteServices.getClientes());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
    }//GEN-LAST:event_btnBorrarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        
        try {
            int SelectedRowIndex = tblClientes.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(SelectedRowIndex, 0).toString());
            System.out.println(id);
            if(SelectedRowIndex == -1){
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
                return;
            }
            clienteEditable = clienteServices.buscarClienteByClave(id);

            textFieldNombreClienteActualizar.setText(clienteEditable.getNombreCliente());
            textFieldNombreEmpresaActualizar.setText(clienteEditable.getNombreEmpresa());
            textFieldPrecioVentaSacoActualizar.setText(Float.toString(clienteEditable.getPrecioVentaSaco()));
            textFieldCiudadActualizar.setText(clienteEditable.getCiudad());
            cardLayout.show(panel, "cShop");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void textFieldNombreEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreEmpresaActionPerformed

    private void textFieldNombreClienteActualizarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNombreClienteActualizarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreClienteActualizarFocusGained

    private void textFieldNombreClienteActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNombreClienteActualizarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreClienteActualizarFocusLost

    private void textFieldCiudadActualizarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldCiudadActualizarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCiudadActualizarFocusGained

    private void textFieldCiudadActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldCiudadActualizarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCiudadActualizarFocusLost

    private void textFieldPrecioVentaSacoActualizarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPrecioVentaSacoActualizarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPrecioVentaSacoActualizarFocusGained

    private void textFieldPrecioVentaSacoActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPrecioVentaSacoActualizarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPrecioVentaSacoActualizarFocusLost

    private void btnActualizarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarClienteMouseClicked

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        // TODO add your handling code here:
        
        try {
            clienteEditable.actualizarCliente(
                textFieldNombreClienteActualizar.getText(),
                textFieldNombreEmpresaActualizar.getText(),
                textFieldCiudadActualizar.getText(),
                Float.parseFloat(textFieldPrecioVentaSacoActualizar.getText())
            );
            clienteServices.actualizarClienteById(clienteEditable);
            clienteEditable = null;
            cardLayout.show(panel, "cHome");
        } catch (Exception e) {
        }
        tablaMostrarCliente.updateClientesTableAllColumns(clienteServices.getClientes());
        
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void textFieldNombreEmpresaActualizarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNombreEmpresaActualizarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreEmpresaActualizarFocusGained

    private void textFieldNombreEmpresaActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNombreEmpresaActualizarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreEmpresaActualizarFocusLost

    private void textFieldNombreEmpresaActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreEmpresaActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreEmpresaActualizarActionPerformed

    private void lblNameUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNameUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNameUserMouseClicked

    private void pv_InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pv_InfoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pv_InfoMouseClicked

    private void tblPuntoVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPuntoVentasMouseClicked
        // TODO add your handling code here:
        setearDatosPuntoVenta();
        
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        int SelectedRowIndex = tblPuntoVentas.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(SelectedRowIndex, 0).toString());
        System.out.println(id);
        if(SelectedRowIndex == -1){
            JOptionPane.showMessageDialog(null, "Valor no valido");
            return;
        }
        clientePuntoVenta = clienteServices.buscarClienteByClave(id);
        
        
        deudaTotal = clientePuntoVenta.getDeuda();
        
        pv_lblNombreCliente.setText("Nombre: "+clientePuntoVenta.getNombreCliente());
        pv_lblAdeudoCliente.setText("Adeudo: "+clientePuntoVenta.getDeuda());
        pv_lblVentaSaco.setText("Venta saco: "+clientePuntoVenta.getPrecioVentaSaco());
        pv_lblCompañia.setText("Compañia: "+clientePuntoVenta.getNombreEmpresa());
        
    }//GEN-LAST:event_tblPuntoVentasMouseClicked

    private void tblPuntoVentasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblPuntoVentasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPuntoVentasFocusLost

    private void sacoIncrementadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sacoIncrementadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sacoIncrementadorMouseClicked

    private void sacoIncrementadorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sacoIncrementadorStateChanged
        // TODO add your handling code here:
        if(clientePuntoVenta == null){
            sacoIncrementador.setValue(0);
            return;
        }
        
        String saco = sacoIncrementador.getValue().toString();
        if((Integer.parseInt(saco)) < 0){
            sacoIncrementador.setValue(0);
            return;
        }
        
        System.out.println("Saco counter: " + saco);
        
        
        montoPagarSaco = clientePuntoVenta.GetInfoCompra(Integer.parseInt(saco));
        deudaTotal = clientePuntoVenta.getDeuda() + montoPagar();
        
        
        pv_lblDeudaTotal.setText("$"+deudaTotal);
        pv_lblMontoPagar.setText("$"+Float.toString(montoPagar()));
    }//GEN-LAST:event_sacoIncrementadorStateChanged

    private void pv_btnRealizarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pv_btnRealizarTransaccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pv_btnRealizarTransaccionActionPerformed

    private void pv_btnCancelarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pv_btnCancelarTransaccionActionPerformed
        // TODO add your handling code here:
        clientePuntoVenta = null;
        
        setearDatosPuntoVenta();
        
        tablaPuntoVentas.updateClientesTable(clienteServices.getClientes());
    }//GEN-LAST:event_pv_btnCancelarTransaccionActionPerformed

    private void sacoIncrementadorTonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sacoIncrementadorTonStateChanged
        // TODO add your handling code here:
        
        if(clientePuntoVenta == null){
            sacoIncrementadorTon.setValue(0);
            return;
        }
        
        String ton = sacoIncrementadorTon.getValue().toString();
        if((Integer.parseInt(ton)) < 0){
            sacoIncrementadorTon.setValue(0);
            return;
        }
        
        int sacos = Integer.parseInt(ton) * 27;
        
        System.out.println("Saco counter: " + sacos);
        
        
        montoPagarTon = clientePuntoVenta.GetInfoCompra(sacos);
        deudaTotal = clientePuntoVenta.getDeuda() + montoPagar();
        
        
        pv_lblDeudaTotal.setText("$"+deudaTotal);
        pv_lblMontoPagar.setText("$"+Float.toString(montoPagar()));
  
        
    }//GEN-LAST:event_sacoIncrementadorTonStateChanged

    private void sacoIncrementadorTonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sacoIncrementadorTonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sacoIncrementadorTonMouseClicked

    private void pv_lblVentaSacoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pv_lblVentaSacoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pv_lblVentaSacoMouseClicked

    private void pv_lblAdeudoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pv_lblAdeudoClienteMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_pv_lblAdeudoClienteMouseClicked

    private void pv_lblNombreClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pv_lblNombreClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pv_lblNombreClienteMouseClicked

    private void pv_ButModVenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pv_ButModVenMouseClicked

        if(clientePuntoVenta == null)return;
        
        String precio;
        do{
            precio = JOptionPane.showInputDialog(null, "Actualizar precio de venta/saco: ");
            System.out.println(precio);
            if(precio == null)return;
            if(tryParseFloat(precio)){
                clientePuntoVenta.setPrecioVentaSaco(Float.parseFloat(precio));
                clienteServices.actualizarClienteById(clientePuntoVenta);
                System.out.println(precio);
                break;
            }
        }while(true);
        
        String ton = sacoIncrementadorTon.getValue().toString();
        String saco = sacoIncrementador.getValue().toString();
        
        int sacos = Integer.parseInt(ton) * 27;
        
        System.out.println("Saco counter: " + sacos);
        
        montoPagarSaco = clientePuntoVenta.GetInfoCompra(Integer.parseInt(saco));
        montoPagarTon = clientePuntoVenta.GetInfoCompra(sacos);
        deudaTotal = clientePuntoVenta.getDeuda() + montoPagar();
        
        
        pv_lblDeudaTotal.setText("$"+deudaTotal);
        pv_lblMontoPagar.setText("$"+Float.toString(montoPagar()));
        pv_lblVentaSaco.setText("Venta saco: "+clientePuntoVenta.getPrecioVentaSaco());
  
        
    }//GEN-LAST:event_pv_ButModVenMouseClicked
    
    
    Desvanecimiento animacion;
    private void ButAbonarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButAbonarMouseClicked
        if(clientePuntoVenta == null)return;
        if(clientePuntoVenta.getDeuda() == 0)return;
        
        abono.setCliente(clientePuntoVenta);
        
        animacion = new Desvanecimiento();
        animacion.Abrir(abono, 15);
    }//GEN-LAST:event_ButAbonarMouseClicked

    private void pv_btnRealizarTransaccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pv_btnRealizarTransaccionMouseClicked
        /*int Res = JOptionPane.showConfirmDialog(null,"¿Desea añadir un costo extra?");
        
        if(Res == 0){
            JOptionPane.showInputDialog(null, "Cantidad:");
        }*/
        System.out.println(calcularSacos());
        
        if(montoPagar() > 0){
            preventa = new Venta(0, clientePuntoVenta.getId(), calcularSacos(), montoPagar(), getFecha());
            ventasServices.registrarVenta(preventa);
        }
        
        
        preventa = null;
        prepago = null;
        
        
        tablaPuntoVentas.updateClientesTable(clienteServices.getClientes());
        tablaMostrarCliente.updateClientesTable(clienteServices.getClientes());
        
        setearDatosPuntoVenta();
    }//GEN-LAST:event_pv_btnRealizarTransaccionMouseClicked

    private void textFieldNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreClienteActionPerformed

    private void btnEditarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarClienteMouseClicked
        
    }//GEN-LAST:event_btnEditarClienteMouseClicked

    private void iEditUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iEditUserMouseClicked
        cardLayout.show(panel, "cEditUser");
    }//GEN-LAST:event_iEditUserMouseClicked

    private void lEditUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEditUserMouseClicked
        cardLayout.show(panel, "cEditUser");
    }//GEN-LAST:event_lEditUserMouseClicked

    private void TextFieldNewNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldNewNameFocusGained

        TextFieldNewName.setForeground(Color.white);
        TextFieldNewName.setText("");
    }//GEN-LAST:event_TextFieldNewNameFocusGained

    private void TextFieldNewNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldNewNameFocusLost
        TextFieldNewName.setForeground(Color.gray);
    }//GEN-LAST:event_TextFieldNewNameFocusLost

    private void ButFinishEditionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButFinishEditionMouseClicked
        // TODO add your handling code here:
        
        if(TextFieldNewName.getText().isEmpty() && TextFieldNewPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Detos vacios", "Error Actualizar", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        UsuarioCRUD service = Start.getLogin().usuarioService;
        
        if(!TextFieldNewName.getText().isEmpty()){
            service.actualizarUserName(service.usuarioRegistrado.getId(), TextFieldNewName.getText());
            lblNameUser.setText(service.usuarioRegistrado.getUserName());
        }
        if(!TextFieldNewPassword.getText().isEmpty()){
            service.actualizarPassword(service.usuarioRegistrado.getId(), TextFieldNewPassword.getText());
            lblNameUser.setText(service.usuarioRegistrado.getUserName());
        }
        
        TextFieldNewName.setText("");
        TextFieldNewPassword.setText("");
    }//GEN-LAST:event_ButFinishEditionMouseClicked

    private void ButFinishEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButFinishEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButFinishEditionActionPerformed
    //Fin del bloque grafico.
    
     private int calcularSacos(){
        String saco = sacoIncrementador.getValue().toString();
        String ton = sacoIncrementadorTon.getValue().toString();
        
        int sacos = Integer.parseInt(saco) + (Integer.parseInt(ton) * 27);
        
        return sacos;
    }
    
    public void setearDatosPuntoVenta(){
        pv_lblNombreCliente.setText("Nombre: ");
        pv_lblAdeudoCliente.setText("Adeudo: ");
        pv_lblVentaSaco.setText("Venta saco: ");
        pv_lblCompañia.setText("Compañia: ");
        pv_lblMontoPagar.setText("$0.0");
        pv_lblDeudaTotal.setText("$0.0");
        sacoIncrementador.setValue(0);
        sacoIncrementadorTon.setValue(0);
        
        montoPagarTon = 0;
        montoPagarSaco = 0;
        cambio = 0;
        deudaTotal = 0;
        pago = 0;
        clientePuntoVenta = null;
    }
    
    private boolean tryParseFloat(String value) {  
        try {  
            Float.parseFloat(value);
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
    }
    
    private float montoPagar(){
       return montoPagarSaco + montoPagarTon;
    }
    
   
    //Set&Get.
    public JTextField getLabelNombreCom() {
        return textFieldPrecioVentaSaco;
    }

    public void setLabelNombreCom(JTextField LabelNombreCom) {
        this.textFieldPrecioVentaSaco = LabelNombreCom;
    }

    public JTextField getLabelNumeroCel() {
        return textFieldCiudad;
    }

    public void setLabelNumeroCel(JTextField LabelNumeroCel) {
        this.textFieldCiudad = LabelNumeroCel;
    }
/*
    public JTextField getLabelSector() {
        return textFieldSector;
    }

    public void setLabelSector(JTextField LabelSector) {
        this.textFieldSector = LabelSector;
    }*/

    public JTextField getTextFieldApellidos() {
        return textFieldNombreEmpresa;
    }

    public void setTextFieldApellidos(JTextField textFieldApellidos) {
        this.textFieldNombreEmpresa = textFieldApellidos;
    }
/*
    public JTextField getTextFieldDireccion() {
        return textFieldDireccion;
    }

    public void setTextFieldDireccion(JTextField textFieldDireccion) {
        this.textFieldDireccion = textFieldDireccion;
    }
*/
    public JTextField getTextFieldNombre() {
        return textFieldNombreCliente;
    }

    public void setTextFieldNombre(JTextField textFieldNombre) {
        this.textFieldNombreCliente = textFieldNombre;
    }
    //Set&Get.
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButAbonar;
    private javax.swing.JButton ButFinishEdition;
    private javax.swing.JToggleButton ButTerminarRegistro;
    private javax.swing.JLabel LabelMontoApagar;
    private javax.swing.JLabel LabelNumToneladas;
    private javax.swing.JLabel LabelNumeroSacos;
    private javax.swing.JScrollPane TablaClientes;
    private javax.swing.JTextField TextFieldNewName;
    private javax.swing.JPasswordField TextFieldNewPassword;
    private javax.swing.JPanel Toggle;
    private javax.swing.JToggleButton btnActualizarCliente;
    private javax.swing.JButton btnBorrarCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JLabel iAddUser;
    private javax.swing.JLabel iEditUser;
    private javax.swing.JLabel iHome;
    private javax.swing.JLabel iInfo;
    private javax.swing.JLabel iShowUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAddUser;
    private javax.swing.JLabel lContraseñaEdit;
    private javax.swing.JLabel lEditUser;
    private javax.swing.JLabel lFondoAddUser;
    private javax.swing.JLabel lFondoAddUser1;
    private javax.swing.JLabel lFondoAddUser2;
    private javax.swing.JLabel lHome;
    private javax.swing.JLabel lIcon;
    private javax.swing.JLabel lNombreEdit;
    private javax.swing.JLabel lShowUser;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel lTitulo1;
    private javax.swing.JLabel lTituloAddUser;
    private javax.swing.JLabel lTituloAddUser1;
    private javax.swing.JLabel lTituloAddUser2;
    private javax.swing.JLabel lTituloInfo;
    private javax.swing.JLabel lTituloInfo10;
    private javax.swing.JLabel lTituloInfo11;
    private javax.swing.JLabel lTituloInfo12;
    private javax.swing.JLabel lTituloInfo13;
    private javax.swing.JLabel lTituloInfo14;
    private javax.swing.JLabel lTituloInfo15;
    private javax.swing.JLabel lTituloInfo16;
    private javax.swing.JLabel lTituloInfo4;
    private javax.swing.JLabel lTituloInfo7;
    private javax.swing.JLabel lTituloInfo8;
    private javax.swing.JLabel lTituloInfo9;
    private javax.swing.JLabel lblNameUser;
    private javax.swing.JPanel pAddUser;
    private javax.swing.JPanel pEditClient;
    private javax.swing.JPanel pEditUser;
    private javax.swing.JPanel pHome;
    private javax.swing.JPanel pInfo;
    private javax.swing.JPanel pShowUser;
    private javax.swing.JPanel panel;
    private javax.swing.JButton pv_ButModVen;
    private javax.swing.JLabel pv_Info;
    private javax.swing.JButton pv_btnCancelarTransaccion;
    private javax.swing.JButton pv_btnRealizarTransaccion;
    private javax.swing.JLabel pv_lblAdeudoCliente;
    private javax.swing.JLabel pv_lblCompañia;
    private javax.swing.JLabel pv_lblDeudaTotal;
    private javax.swing.JLabel pv_lblMontoPagar;
    private javax.swing.JLabel pv_lblNombreCliente;
    private javax.swing.JLabel pv_lblVentaSaco;
    private javax.swing.JSpinner sacoIncrementador;
    private javax.swing.JSpinner sacoIncrementadorTon;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblPuntoVentas;
    public javax.swing.JTextField textFieldCiudad;
    public javax.swing.JTextField textFieldCiudadActualizar;
    public static javax.swing.JTextField textFieldNombreCliente;
    public static javax.swing.JTextField textFieldNombreClienteActualizar;
    public javax.swing.JTextField textFieldNombreEmpresa;
    public javax.swing.JTextField textFieldNombreEmpresaActualizar;
    public javax.swing.JTextField textFieldPrecioVentaSaco;
    public javax.swing.JTextField textFieldPrecioVentaSacoActualizar;
    // End of variables declaration//GEN-END:variables
}
