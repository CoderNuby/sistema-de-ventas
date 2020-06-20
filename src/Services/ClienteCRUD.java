package Services;

import Models.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ClienteCRUD {

    public ClienteCRUD() {
        File archivo = new File("src/Archivo/archivo.txt");
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

    public void crearCliente(Cliente cliente) {//METODO REVISADO: FUNCIONANDO, FALTA ARREGLAR ALGUNOS ERRORES
        File db = new File("src/Archivo/archivo.txt");
        File tempDB = new File("src/Archivo/archivo_temp.txt");
        try {
            if (cliente.getNombreCliente().isEmpty()) {
                cliente.setNombreCliente("undefined");
            }
            if (cliente.getNombreEmpresa().isEmpty()) {
                cliente.setNombreEmpresa("undefined");
            }
            if (cliente.getCiudad().isEmpty()) {
                cliente.setCiudad("undefined");
            }
            List<Cliente> newClientes = añadirClienteToList(cliente);
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
            for(Cliente cli:newClientes) {
                bw.write(
                    Integer.toString(cli.getId())+","+
                    cli.getNombreCliente()+","+
                    cli.getNombreEmpresa()+","+
                    cli.getCiudad()+","+
                    cli.getDeuda()+","+
                    cli.getPrecioVentaSaco()
                );
                bw.flush();
                bw.newLine();
            }
            bw.close();
            db.delete();
        } catch (Exception e) {
            System.err.println("Method-actualizarUsuarioById: " + e);
        }

        boolean success = tempDB.renameTo(db);
        System.out.println(success);
    }

    public List<Cliente> getClientes() {//METODO REVISADO: FUNCIONANDO BIEN
        List<Cliente> cli = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Archivo/archivo.txt"));
            String record;

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                
                String id = st.nextToken();
                String nombreCliente = st.nextToken();
                String nombreEmpresa = st.nextToken();
                String ciudad = st.nextToken();
                String deuda = st.nextToken();
                String precioVentaSaco = st.nextToken();

                Cliente cliente = new Cliente(
                    Integer.parseInt(id),
                    nombreCliente,
                    nombreEmpresa,
                    ciudad,
                    Float.parseFloat(deuda),
                    Float.parseFloat(precioVentaSaco)
                );

                cli.add(cliente);
            }

            br.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        return cli;
    }

    public int borrarClienteByClave(int Id) {//METODO REVISADO: FUNCIONANDO
        String record;
        int eleccion = 1;
        File newFile = new File("src/Archivo/archivo_temp.txt");
        File file = new File("src/Archivo/archivo.txt");
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
                 */
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
            BufferedReader br = new BufferedReader(new FileReader("src/Archivo/archivo.txt"));
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
        File db = new File("src/Archivo/archivo.txt");
        File tempDB = new File("src/Archivo/archivo_temp.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
            while ((record = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(record, ",");
                String id = st.nextToken();
                if (Integer.parseInt(id) == cliente.getId()) {
                    System.out.println("usuario encontrado");
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

    public int generarId() {

        int count = 0;

        if (getClientes().isEmpty()) {
            return count;
        }

        for (Cliente cliente : getClientes()) {
            if (cliente.getId() != count) {
                return count;
            }
            count++;
        }

        return getClientes().size();
    }

    private List<Cliente> añadirClienteToList(Cliente cliente) {
        List<Cliente> clientes = getClientes();
        int id = generarId();

        Cliente cli = new Cliente(
            id,
            cliente.getNombreCliente(),
            cliente.getNombreEmpresa(),
            cliente.getCiudad(),
            cliente.getDeuda(),
            cliente.getPrecioVentaSaco()
        );

        clientes.add(id, cli);

        return clientes;
    }
    
}
