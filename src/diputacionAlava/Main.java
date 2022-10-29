package diputacionAlava;

import BBDD.CampamentosBD;
import BBDD.UsuariosAplicacionBD;
import Clases.Campamento;
import Clases.Response;
import Clases.Usuario;
import Ventanas.CrearCampamento;
import Ventanas.IniciarSesion;
import Ventanas.RegistrarUsuario;
import Ventanas.VPrincipal;
import Ventanas.VerModificarEliminarCampamento;
import javax.swing.JComboBox;

public class Main {
    private static IniciarSesion vLogin;
    private static RegistrarUsuario vRegistrar;
    private static VPrincipal vPrincipal;
    private static CrearCampamento vCrearModificarCampamento;
    private static VerModificarEliminarCampamento vVerModificarEliminarCamp;

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
        vCrearModificarCampamento = new CrearCampamento(0,new Campamento());
        vCrearModificarCampamento.setVisible(true);
    }
    
    public static void cerrarCrearModificarCampamento(int opcion){
        vCrearModificarCampamento.setVisible(false);
        vCrearModificarCampamento.dispose();
        if(opcion==1){
            //TODO ventana de modificar anterior desde la que se selecciona el campamento
            //mec.setVisible(true);
        }else{
            vPrincipal = new VPrincipal();
            vPrincipal.setVisible(true);
        }
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
    
    public static JComboBox<String> RellenarComboCamp(JComboBox combo) throws Exception{
        /*combo.removeAllItems();
        combo.addItem("-----Elegir campamento-----");
            try{
             for(int x=0;x<campamentos.size();x++){
             String nombre = campamentos.get(x).getNombre();
             combo.addItem(nombre);
             combo.add
             }
         }catch(Exception e){
                     System.out.println("ha ocurrido un error "+ e.getMessage());
                     } 
         return combo;   */
        return null;
    }
}
