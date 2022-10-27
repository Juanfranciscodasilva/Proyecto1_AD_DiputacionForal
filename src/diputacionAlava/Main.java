package diputacionAlava;

import BBDD.UsuariosAplicacion;
import Clases.Response;
import Clases.Usuario;
import Ventanas.IniciarSesion;
import Ventanas.RegistrarUsuario;
import Ventanas.VPrincipal;

public class Main {
    private static VPrincipal p;
    private static IniciarSesion vLogin;
    private static RegistrarUsuario vRegistrar;

    public static void main(String[] args) {
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
        /*p = new VPrincipal();
        p.setVisible(true);*/
    }
    
    public static void CerrarPrograma(){
        vLogin.dispose();
        System.exit(0);
    }
    
    public static void abrirRegistrarUsuario(){
        vLogin.setVisible(false);
        vLogin.dispose();
        vRegistrar = new RegistrarUsuario();
        vRegistrar.setVisible(true);
    }
    
    public static void volverAlLogin(){
        vRegistrar.setVisible(false);
        vRegistrar.dispose();
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
        
    }
    
    public static void volverAlLoginConUsuario(Usuario usu){
        vRegistrar.setVisible(false);
        vRegistrar.dispose();
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
        vLogin.setUsuario(usu.getUsuario());
    }
    
    public static boolean iniciarSesion(Usuario usu){
        Response respuesta = UsuariosAplicacion.iniciarSesion(usu);
        return respuesta.isCorrecto();
    }
    
    public static Response insertarUsuario(Usuario usu){
        return UsuariosAplicacion.registrarUsuario(usu);
    }
}
