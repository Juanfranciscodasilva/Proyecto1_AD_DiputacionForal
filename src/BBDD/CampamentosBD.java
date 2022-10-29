package BBDD;

import Clases.Campamento;
import Clases.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CampamentosBD {
    public static File bdCampamentos = null;
    
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
    
    public static void instanciarFichero() throws Exception{
        try{
            bdCampamentos = new File("campamentos.dat");
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
    
    public static void insertarCampamento(Campamento camp) throws Exception{
        try {
            List<Campamento> campamentos = getListaCampamentosFromBD();
            camp.setId(generarIdFromList(campamentos));
            campamentos.add(camp);
            insertarListaCampamentos(campamentos);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void insertarListaCampamentos(List<Campamento> campamentos) throws Exception{
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
    
    public static int generarIdFromList(List<Campamento> campamentos){
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
    
    public static List<Campamento> getListaCampamentosFromBD() throws Exception{
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
