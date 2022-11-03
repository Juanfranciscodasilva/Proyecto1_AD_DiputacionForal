package BBDD;

import Clases.Campamento;
import Clases.Response;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class PersonasCampamentosBD {
    public static RandomAccessFile bdPersonasCampamentos = null;
    
    public static Response registrarCampamento(Campamento camp){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            insertarCampamento(camp); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al crear el campamento. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Response eliminarRelacionByCampamentoId(int idCampamento){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            deleteByCampamentoId(idCampamento); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar las personas inscritas.");
            return respuesta;
        }
        return respuesta;
    }
    
    public static Response eliminarRelacionByPersonaId(int idPersona){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            deleteByPersonaId(idPersona); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al eliminar las personas inscritas.");
            return respuesta;
        }
        return respuesta;
    }
    
    private static void deleteByCampamentoId(int idCampamento) throws Exception{
        try{
            int posicion = 0;
            bdPersonasCampamentos.seek(0);
            while(bdPersonasCampamentos.getFilePointer() < bdPersonasCampamentos.length()){
                bdPersonasCampamentos.seek(posicion);
                int idCampamento = bdPersonasCampamentos.readInt();
                StringBuffer buffer = new StringBuffer();
                for(int x = 0;x<10;x++){
                    buffer.append(bd.readChar());
                }
                String apellido = buffer.toString();
                int departamento = bd.readInt();
                double salario = bd.readDouble();
                Empleado empleGenerado = new Empleado(id,apellido,departamento,salario);
                System.out.println(empleGenerado.toString());
                posicion += 8;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    private static void instanciarFichero() throws Exception{
        try{
            bdPersonasCampamentos = new RandomAccessFile("campamentos.dat", "rw");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    
    
    public static Campamento buscarCampamentoById(Campamento camp) throws Exception{
        try{
            FileInputStream input = new FileInputStream(bdCampamentos);
            ObjectInputStream objIS = new ObjectInputStream(input);
            while(input.available() != 0){
                Campamento campamento = (Campamento)objIS.readObject();
                if(campamento.getId() == camp.getId()){
                    return campamento;
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    private static void insertarCampamento(Campamento camp) throws Exception{
        try {
            List<Campamento> campamentos = getListaCampamentosFromBD();
            camp.setId(generarIdFromList(campamentos));
            campamentos.add(camp);
            insertarListaCampamentos(campamentos);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void insertarListaCampamentos(List<Campamento> campamentos) throws Exception{
        try {
            FileOutputStream fileout = new FileOutputStream(bdCampamentos);
            ObjectOutputStream objOS = new ObjectOutputStream(fileout);
            for(Campamento c : campamentos){
                objOS.writeObject(c);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static int generarIdFromList(List<Campamento> campamentos){
        int id = 0;
        if(campamentos == null || campamentos.isEmpty()){
            return 0;
        }
        for(Campamento c : campamentos){
            if(c.getId() > id){
                id = c.getId();
            }
        }
        return id+1;
    }
    
    private static List<Campamento> getListaCampamentosFromBD() throws Exception{
        try{
            List<Campamento> campamentos = new ArrayList<>();
            if(bdCampamentos.exists()){
                FileInputStream input = new FileInputStream(bdCampamentos);
                ObjectInputStream objIS = new ObjectInputStream(input);
                while(input.available() != 0){
                    Campamento camp = (Campamento)objIS.readObject();
                    campamentos.add(camp);
                }
            }
            return campamentos;
        }catch(Exception ex){
            throw ex;
        }
    }
}
