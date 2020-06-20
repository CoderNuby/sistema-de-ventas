package Services;

import Bcrypt.bcrypt;
import Models.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class UsuarioCRUD {
    
    public Usuario usuarioRegistrado = null;
    bcrypt auth;

    public UsuarioCRUD() {
        File archivo = new File("src/Archivo/usuarios.txt");
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
        
        auth = new bcrypt();
    }
    
    public boolean login(String userName, String password) {//MOETODO REVISADO: FUNCIONANDO
        String record;
        boolean login = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Archivo/usuarios.txt"));
            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                String id = st.nextToken();
                String user = st.nextToken();
                if (user.equals(userName)) {

                    String hash = st.nextToken();
                    if(auth.validatePassword(password, hash)){
                        login = true;
                        this.usuarioRegistrado = new Usuario(
                                Integer.parseInt(id),
                                user,
                                "**********"
                        );
                    }
                }
            }
            br.close();
        } catch (NoSuchElementException e) {
            System.err.println("Method-buscarProductoByClave: " + e.toString());
            return false;
        } catch (Exception e) {
            System.err.println("Method-buscarProductoByClave: " + e);
            return false;
        }
        if(!login)JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        return login;
    }

    public boolean crearUsuario(Usuario usuario) {//METODO REVISADO: FUNCIONANDO, FALTA ARREGLAR ALGUNOS ERRORES
        
        if(usuarioExite(usuario))return false;
        
        if(usuario.getPassword().isEmpty()){
            JOptionPane.showMessageDialog(null, "Esta casilla no puede estar vacia: PassWord");
            return false;
        }
        
        if(usuario.getUserName().isEmpty()){
            JOptionPane.showMessageDialog(null, "Esta casilla no puede estar vacia: UserName");
            return false;
        }
        
        File db = new File("src/Archivo/usuarios.txt");
        File tempDB = new File("src/Archivo/usuarios_temp.txt");

        try {

            
            List<Usuario> newUsuario = añadirUsuarioToList(usuario);

            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));


            /*
            implementar el hash para la contraseña
            */

            for(Usuario user:newUsuario) {
                bw.write(
                        user.getId() + ","
                        + user.getUserName()+ ","
                        + user.getPassword()
                );
                bw.flush();
                bw.newLine();
            }
            bw.close();
            db.delete();
        } catch (Exception e) {
            System.err.println("Method-crearUsuario: " + e);
        }

        boolean success = tempDB.renameTo(db);
        System.out.println(success);
        return true;
    }

    public List<Usuario> getUsuarios() {//METODO REVISADO: FUNCIONANDO BIEN
        List<Usuario> users = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Archivo/usuarios.txt"));
            String record;

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");

                String value1 = st.nextToken();
                String value2 = st.nextToken();
                String value3 = st.nextToken();

                Usuario usuario = new Usuario(
                        Integer.parseInt(value1),
                        value2,
                        value3
                );

                users.add(usuario);
            }

            br.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        return users;
    }

    public int borrarUsuarioByClave(int Id) {//METODO REVISADO: FUNCIONANDO

        String record;

        int eleccion = 1;

        File newFile = new File("src/Archivo/usuarios_temp.txt");
        File file = new File("src/Archivo/usuarios.txt");
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

            while ((record = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(record, ",");
                String value1;

                value1 = st.nextToken();

                /*
                Probar el panel que este funcionando bien
                solo borrar el usuario si el usuario da aceptar
                 */
                if (Integer.parseInt(value1) == Id) {
                    eleccion = JOptionPane.showConfirmDialog(null, ("Seguro que desea borrar el reguistro:" + "\n"
                            + "Nombre: " + st.nextToken()), "Borra Cliente", 1);
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

    public Usuario buscarUsuarioByClave(int Id) {//MOETODO REVISADO: FUNCIONANDO
        String record;
        Usuario usuario = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Archivo/usuarios.txt"));
            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                String clave = st.nextToken();
                if (Integer.parseInt(clave) == Id) {

                    String value2 = st.nextToken();

                    usuario = new Usuario(
                        Integer.parseInt(clave),
                        value2
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
        if (usuario == null) {
            System.err.println("Cliente no encontrado");
        }
        return usuario;
    }
    
    public Usuario buscarUsuarioByUserName(String userName) {//MOETODO REVISADO: FUNCIONANDO
        String record;
        Usuario usuario = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Archivo/usuarios.txt"));
            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                String clave = st.nextToken();
                String name = st.nextToken();
                if (name.equals(userName)) {

                    usuario = new Usuario(
                        Integer.parseInt(clave),
                        name
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
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
        return usuario;
    }
    
    //ACTUALIZAR USERNAME DE USUARIO Y EN OTRO METODO ACTUALIZAR EL PASSWORD
    public void actualizarPassword(int id, String password) {//METODO REVISADO
        String record, record2;

        File db = new File("src/Archivo/usuarios.txt");
        File tempDB = new File("src/Archivo/usuarios_temp.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                String value1 = st.nextToken();
                if (Integer.parseInt(value1) == id) {
                    
                    //Confirmar 
                    //Si = int 0
                    //no = int 1
                    //cacelar = int 2
                     
                    int eleccion = JOptionPane.showConfirmDialog(null,
                            "Deseea Actualizar los datos del usuario", "Actualizar", 1);
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
                String dbId = st.nextToken();
                String userName = st.nextToken();
                if (Integer.parseInt(dbId) == id) {
                    
                    bw.write(
                        dbId + ","
                        + userName + ","
                        + auth.generateStorngPasswordHash(password)
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
            System.err.println("Method-actualizarUsuarioById: " + e);
        }

        boolean success = tempDB.renameTo(db);
        System.out.println(success);
    }
    
    public void actualizarUserName(int id, String newUserName) {//METODO REVISADO
        String record, record2;
        if(usuarioRegistrado.getUserName().equals(newUserName)){
            JOptionPane.showMessageDialog(null, "El nombre nuevo es el mismo que el anterior. no seas wey", "Error Actualizar", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Usuario usr = new Usuario(0, newUserName,"**********");
        
        if(usuarioExite(usr))return;

        File db = new File("src/Archivo/usuarios.txt");
        File tempDB = new File("src/Archivo/usuarios_temp.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");
                String value1 = st.nextToken();
                if (Integer.parseInt(value1) == id) {
                    
                    //Confirmar 
                    //Si = int 0
                    //no = int 1
                    //cacelar = int 2
                     
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
                String dbId = st.nextToken();
                String userName = st.nextToken();
                String password = st.nextToken();
                if (Integer.parseInt(dbId) == id) {
                    
                    bw.write(
                        dbId + ","
                        + newUserName + ","
                        + password
                    );
                    
                    this.usuarioRegistrado = new Usuario(
                        Integer.parseInt(dbId),
                        newUserName,
                        "**********"
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
            System.err.println("Method-actualizarUsuarioById: " + e);
        }

        boolean success = tempDB.renameTo(db);
        System.out.println(success);
    }
    
    public boolean compararCodigoRecuperacion(String codigo){
        
        File db = new File("src/Archivo/recuperarPassword/codigoRecuperacion.txt");
        
        boolean result = false;
        if(codigo == null){
            db.delete();
            return result;
        }
        
        if(codigo.equals(readCodigoRecuperacion())){
            System.out.println("Credenciales correctas");
            result = true;
        }else{
            JOptionPane.showMessageDialog(null,"Codigo de recuperacion incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            result = false;
        }
        db.delete();
        return result;
    }
    
    private String readCodigoRecuperacion() {//METODO REVISADO

        String record;
        String codigo = null;
        
        File tempDB = new File("src/Archivo/recuperarPassword/codigoRecuperacion.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(tempDB));

            while ((record = br.readLine()) != null) {
                codigo = record;
            }

            br.close();
            br.close();
            
        } catch (Exception e) {
            System.err.println("Method-actualizarUsuarioById: " + e);
        }
        return codigo;
    }
    
    public void generarCodigoRecuperacion() {//METODO REVISADO

        
        File tempDB = new File("src/Archivo/recuperarPassword/codigoRecuperacion.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
            
            double x = Math.random();
            
            bw.write(Double.toString(x));

            bw.flush();
            bw.newLine();
            bw.close();
            
        } catch (Exception e) {
            System.err.println("Method-actualizarUsuarioById: " + e);
        }
    }
    
    public int generarId() {

        int count = 0;

        if (getUsuarios().isEmpty()) {
            return count;
        }

        for (Usuario usuario : getUsuarios()) {
            if (usuario.getId() != count) {
                return count;
            }
            count++;
        }

        return getUsuarios().size();
    }

    private List<Usuario> añadirUsuarioToList(Usuario usuario) throws NoSuchAlgorithmException, InvalidKeySpecException {
        List<Usuario> usuarios = getUsuarios();
        int id = generarId();

        Usuario user = new Usuario(
                id,
                usuario.getUserName(),
                auth.generateStorngPasswordHash(usuario.getPassword())
        );

        usuarios.add(id, user);

        return usuarios;
    }
    
    private boolean usuarioExite(Usuario usuario){
        boolean result = false;
        for(Usuario user:getUsuarios()){
            if(usuario.getUserName().equals(user.getUserName())){
                result = true;
                JOptionPane.showMessageDialog(null, "Usuario ya existente");
            }
        }
        
        return result;
    }
}