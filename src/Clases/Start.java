package Clases;

import Layouts.Inicio; 
import Layouts.Login;
import Layouts.Menu;
import Layouts.Registrar;
import java.security.NoSuchAlgorithmException;
import java.util.Timer;
import java.util.TimerTask;
import Desvanecimiento.Desvanecimiento;

public class Start {
    
    //Constructor
    public Start(){}
    
    static Menu menu; //Instanciar clase Menu.
    static Login login;
    static Registrar registrar;
    static Desvanecimiento animacion = null;
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        //Abre la ventana
        Inicio in = new Inicio();
        login = new Login();
        registrar = new Registrar();
        menu = new Menu();

        Timer reloj = new Timer(); //Contador de tiempo
        TimerTask iniciador = new TimerTask() {
            
            //Tarea a ejecutar
            public void run() {
                in.dispose(); 
                animacion = new Desvanecimiento();
                animacion.Abrir(login, 15);
            }
        };
        
        //(Tarea a ejecutar, tiempo de espera)
        reloj.schedule(iniciador, 2000); 
    }
    
    public static Menu getMenu(){
        return Start.menu;
    }
    
    public static Login getLogin(){
        return Start.login;
    }
    
    public static Registrar getRegistrar(){
        return Start.registrar;
    }
    
    
    
}
