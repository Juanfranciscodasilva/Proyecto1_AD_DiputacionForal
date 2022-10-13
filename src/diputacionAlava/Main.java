package diputacionAlava;

import Ventanas.IniciarSesion;
import Ventanas.VPrincipal;

public class Main {
    private static VPrincipal p;
    private static IniciarSesion vLogin;

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
    
}
