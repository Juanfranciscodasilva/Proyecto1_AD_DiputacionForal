package BBDD;

import Clases.Response;
import Clases.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

public class UsuariosAplicacion {
    /*TODO MONTAR METODOS PARA LEER Y ESCRIBIR SOBRE UN .DAT DE USUARIOS 
    DE LA APLICACION (LOGIN Y REGISTER)*/
    public static File bdUsuarios = null;
    
    public static Response iniciarSesion(Usuario usu){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            Usuario usuario = buscarUsuarioByUsuarioYPassword(usu);
            if(usuario == null){
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("No se ha encontrado el usuario con esas credenciales");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al iniciar sesión. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Response registrarUsuario(Usuario usu){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            if(!existeUsuario(usu)){
                insertarUsuario(usu);
            }else{
                respuesta.setCorrecto(false);
                respuesta.setMensajeError("El usuario ya existe.");
            }
        }catch(Exception ex){
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al iniciar sesión. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static void instanciarFichero() throws Exception{
        try{
            bdUsuarios = new File("usuarios.dat");
            System.out.println(bdUsuarios.getAbsolutePath());
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static Usuario buscarUsuarioByUsuarioYPassword(Usuario usu) throws Exception{
        try{
            FileInputStream input = new FileInputStream(bdUsuarios);
            ObjectInputStream objIS = new ObjectInputStream(input);
            while(input.available() != 0){
                Usuario usuario = (Usuario)objIS.readObject();
                if(usuario.getUsuario().equals(usu.getUsuario()) 
                        && usuario.getPassword().equals(usu.getPassword())){
                    return usuario;
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static Usuario buscarUsuarioByUsuario(Usuario usu) throws Exception{
        try{
            FileInputStream input = new FileInputStream(bdUsuarios);
            ObjectInputStream objIS = new ObjectInputStream(input);
            while(input.available() != 0){
                Usuario usuario = (Usuario)objIS.readObject();
                if(usuario.getUsuario().equals(usu.getUsuario())){
                    return usuario;
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static boolean existeUsuario(Usuario usu) throws Exception{
        try{
            Usuario busqueda = buscarUsuarioByUsuario(usu);
            return busqueda != null;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void insertarUsuario(Usuario usu) throws Exception{
        try {
            FileOutputStream fileout = new FileOutputStream(bdUsuarios);
            ObjectOutputStream objOS = new ObjectOutputStream(fileout);
            objOS.writeObject(usu);
        } catch (Exception e) {
            throw e;
        }
    }
}
