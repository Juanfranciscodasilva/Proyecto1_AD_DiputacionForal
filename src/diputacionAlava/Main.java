package diputacionAlava;

import BBDD.CampamentosBD;
import BBDD.PersonasBD;
import BBDD.UsuariosAplicacionBD;
import Clases.Campamento;
import Clases.Persona;
import Clases.Response;
import Clases.Usuario;
import Ventanas.CrearCampamento;
import Ventanas.IniciarSesion;
import Ventanas.InscribirPersona;
import Ventanas.RegistrarUsuario;
import Ventanas.VPrincipal;
import Ventanas.VerModificarEliminarCampamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Main {
    private static IniciarSesion vLogin;
    private static RegistrarUsuario vRegistrar;
    private static VPrincipal vPrincipal;
    private static CrearCampamento vCrearModificarCampamento;
    private static VerModificarEliminarCampamento vVerModificarEliminarCamp;
    private static InscribirPersona vInscribirPersona;

    public static void main(String[] args) {
//        vLogin = new IniciarSesion();
//        vLogin.setVisible(true);
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void CerrarPrograma(){
        hacerDisposeDeTodasLasVentanas();
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
    
    public static void entrarALaAplicacion(){
        vLogin.setVisible(false);
        vLogin.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void entrarACreacionDeCampamento(){
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
        vCrearModificarCampamento = new CrearCampamento(0,new Campamento());
        vCrearModificarCampamento.setVisible(true);
    }
    
    public static void entrarAModificacionDeCampamento(Campamento camp){
        vVerModificarEliminarCamp.setVisible(false);
        vVerModificarEliminarCamp.dispose();
        vCrearModificarCampamento = new CrearCampamento(1,camp);
        vCrearModificarCampamento.setVisible(true);
    }
    
    public static void cerrarCrearModificarCampamento(int opcion){
        vCrearModificarCampamento.setVisible(false);
        vCrearModificarCampamento.dispose();
        if(opcion==1){
            entrarVerModificarEliminarCamp(1);
        }else{
            vPrincipal = new VPrincipal();
            vPrincipal.setVisible(true);
        }
    }
    
    public static void entrarVerModificarEliminarCamp(int opcion){
        try{
            List<Campamento> campamentos = CampamentosBD.getAllCampamentos();
            if(vPrincipal != null){
                vPrincipal.setVisible(false);
                vPrincipal.dispose();
            }
            vVerModificarEliminarCamp = new VerModificarEliminarCampamento(opcion, campamentos);
            vVerModificarEliminarCamp.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir la ventana. Intentalo de nuevo.");
        }
    }
    
     public static void entrarInscribirPersona(){
        
        try{
            List<Campamento> campamentos = CampamentosBD.getAllCampamentos();
            List<Persona> personas = PersonasBD.getAllPersonas();
            if(vPrincipal != null){
                vPrincipal.setVisible(false);
                vPrincipal.dispose();
            }
            vInscribirPersona = new InscribirPersona(campamentos,personas);
            vInscribirPersona.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir la ventana. Intentalo de nuevo.");
        }
    }
    
    public static void cerrarInscribirPersona(){
        vInscribirPersona.setVisible(false);
        vInscribirPersona.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void cerrarVerModificarEliminarCamp(){
        vVerModificarEliminarCamp.setVisible(false);
        vVerModificarEliminarCamp.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void volverAlLoginConUsuario(Usuario usu){
        vRegistrar.setVisible(false);
        vRegistrar.dispose();
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
        vLogin.setUsuario(usu.getUsuario());
    }
    
    public static boolean iniciarSesion(Usuario usu){
        Response respuesta = UsuariosAplicacionBD.iniciarSesion(usu);
        return respuesta.isCorrecto();
    }
    
    public static void CerrarSesion(){
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
        vLogin = new IniciarSesion();
        vLogin.setVisible(true);
    }
    
    public static Response insertarUsuario(Usuario usu){
        return UsuariosAplicacionBD.registrarUsuario(usu);
    }
    
    public static Response insertarCampamento(Campamento camp){
        return CampamentosBD.registrarCampamento(camp);
    }
    
    public static void hacerDisposeDeTodasLasVentanas(){
        if(vLogin != null){
            vLogin.dispose();
        }
        if(vRegistrar != null){
            vRegistrar.dispose();
        }
        if(vPrincipal != null){
            vPrincipal.dispose();
        }
    }
    
    public static Response EliminarCampamento(Campamento camp){
        return CampamentosBD.eliminarCampamento(camp);
    }
    
    public static Response ModificarCampamento(Campamento camp){
        return CampamentosBD.modificarCampamento(camp);
    }
}
