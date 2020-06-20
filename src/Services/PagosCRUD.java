package Services;

import Models.Cliente;
import Models.Pago;
import Models.Venta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class PagosCRUD {
    public PagosCRUD() {
        File archivo = new File("src/Archivo/pagos/pagos.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println("Archivo creado");

            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Archivo ya existente");
        }
    }

    public void realizarPago(Pago pago) {//METODO REVISADO: FUNCIONANDO, FALTA ARREGLAR ALGUNOS ERRORES
        
        File db = new File("src/Archivo/pagos/pagos.txt");
        File tempDB = new File("src/Archivo/pagos/pagos_temp.txt");

        try {
            
            List<Pago> newPagos = añadirPagoToList(pago);

            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));



            for(Pago pgs:newPagos) {
                bw.write(
                    pgs.getId()+","+
                    pgs.getIdCliente()+","+
                    pgs.getPago()+","+
                    pgs.getFecha()
                );
                bw.flush();
                bw.newLine();
            }
            bw.close();
            db.delete();
        } catch (Exception e) {
            System.err.println("Method-PagosCRUD.realizarPago(): " + e);
        }

        boolean success = tempDB.renameTo(db);
        System.out.println(success);
    }

    public List<Pago> getPagos() {//METODO REVISADO: FUNCIONANDO BIEN
        List<Pago> pgs = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Archivo/pagos/pagos.txt"));
            String record;

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                
                String id = st.nextToken();
                String idCliente = st.nextToken();
                String pago = st.nextToken();
                String fecha = st.nextToken();


                Pago importe = new Pago(
                    Integer.parseInt(id),
                    Integer.parseInt(idCliente),
                    Float.parseFloat(pago),
                    fecha
                );

                pgs.add(importe);
            }

            br.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        return pgs;
    }
/*
    public int borrarClienteByClave(int Id) {//METODO REVISADO: FUNCIONANDO

        String record;

        int eleccion = 1;

        File newFile = new File("src/Archivo/ventas/ventas.txt");
        File file = new File("src/Archivo/ventas/ventas.txt");
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

            while ((record = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(record, ",");
                String id;

                id = st.nextToken();

                /*
                Probar el panel que este funcionando bien
                solo borrar el usuario si el usuario da aceptar
                 *//*
                if (Integer.parseInt(id) == Id) {
                    eleccion = JOptionPane.showConfirmDialog(null, ("Seguro que desea borrar el reguistro:" + "\n"
                            + "Nombre Cliente: " + st.nextToken() + "\n"
                            + "Nombre Empresa: " + st.nextToken() + "\n"
                            + "Ciudad: " + st.nextToken()), "Borra Cliente", 1);
                    if (eleccion == 0) {
                        System.out.println("Cliente borrado");
                        continue;
                    }
                }
                /*/////////////////////////////////////////*/
/*
                bw.write(record);
                bw.flush();
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        //delete file
        if (file.delete()) {
            System.out.println("Archivo borrado");
        } else {
            System.err.println("Error al borrar usuario");
        }
        boolean success = newFile.renameTo(file);

        if (!success) {
            System.err.println("File was not renamed");
        }
        return eleccion;
    }

    public Cliente buscarClienteByClave(int Id) {//MOETODO REVISADO: FUNCIONANDO
        String record;
        Cliente cliente = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Archivo/ventas/ventas.txt"));
            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                String id = st.nextToken();
                if (Integer.parseInt(id) == Id) {

                    String nombreCliente = st.nextToken();
                    String nombreEmpresa = st.nextToken();
                    String ciudad = st.nextToken();
                    String deuda = st.nextToken();
                    String precioVentaSaco = st.nextToken();

                    cliente = new Cliente(
                        Integer.parseInt(id),
                        nombreCliente,
                        nombreEmpresa,
                        ciudad,
                        Float.parseFloat(deuda),
                        Float.parseFloat(precioVentaSaco)
                    );

                }
            }
            br.close();
        } catch (NoSuchElementException e) {
            System.err.println("Method-buscarProductoByClave: " + e.toString());
            return null;
        } catch (Exception e) {
            System.err.println("Method-buscarProductoByClave: " + e);
        }
        if (cliente == null) {
            System.err.println("Cliente no encontrado");
        }
        return cliente;
    }

    public void actualizarClienteById(Cliente cliente) {//METODO REVISADO
        String record, record2;

        File db = new File("src/Archivo/ventas/ventas.txt");
        File tempDB = new File("src/Archivo/ventas/ventas.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                String id = st.nextToken();
                if (Integer.parseInt(id) == cliente.getId()) {
                    /*
                    Confirmar 
                    Si = int 0
                    no = int 1
                    clacel = int 2
                     *//*
                    int eleccion = JOptionPane.showConfirmDialog(null,
                            "Deseea Actualizar los datos del cliente", "Actualizar", 1);
                    if (eleccion != 0) {
                        br.close();
                        bw.close();
                        tempDB.delete();
                        System.out.println("Actualizacion cancelada");
                        return;
                    }
                }

            }

            BufferedReader br2 = new BufferedReader(new FileReader(db));
          
            while ((record2 = br2.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(record2, ",");
                String id = st.nextToken();
                if (Integer.parseInt(id) == cliente.getId()) {
                    if (cliente.getNombreCliente().isEmpty()) {
                        cliente.setNombreCliente("undefined");
                    }
                    if (cliente.getNombreEmpresa().isEmpty()) {
                        cliente.setNombreEmpresa("undefined");
                    }
                    if (cliente.getCiudad().isEmpty()) {
                        cliente.setCiudad("undefined");
                    }

                    bw.write(
                        Integer.toString(cliente.getId())+","+
                        cliente.getNombreCliente()+","+
                        cliente.getNombreEmpresa()+","+
                        cliente.getCiudad()+","+
                        cliente.getDeuda()+","+
                        cliente.getPrecioVentaSaco()
                    );
                } else {
                    bw.write(record2);
                }
                bw.flush();
                bw.newLine();
            }

            br.close();
            bw.close();
            br2.close();
            db.delete();
        } catch (Exception e) {
            System.err.println("Method-actualizarClienteById: " + e);
        }

        boolean success = tempDB.renameTo(db);
        System.out.println(success);
    }
*/
    private int generarId() {

        int count = 0;

        if (getPagos().isEmpty()) {
            return count;
        }

        for (Pago pago : getPagos()) {
            if (pago.getId() != count) {
                return count;
            }
            count++;
        }

        return getPagos().size();
    }

    private List<Pago> añadirPagoToList(Pago pago) {
        List<Pago> pagos = getPagos();
        int id = generarId();
        
        ClienteCRUD service = new ClienteCRUD();
        
        Cliente cliente = service.buscarClienteByClave(pago.getIdCliente());
        
        if(!cliente.pago(pago.getPago())){
            System.err.println("El pago no puede ser mayor a la deuda");
            return pagos;
        }
        
        service.actualizarClienteById(cliente);
        
        

        Pago pgs = new Pago(
            id,
            pago.getIdCliente(),
            pago.getPago(),
            pago.getFecha()
        );
        
        pagos.add(id, pgs);
        
        System.out.println("Pago realizado correctamente");

        return pagos;
    }
}
