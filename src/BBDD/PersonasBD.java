package BBDD;

import Clases.Campamento;
import Clases.Persona;
import Clases.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonasBD {
    public static File bdPersonas = null;
    
    public static Response registrarPersona(Persona per){
        Response respuesta = new Response();
        try{
            instanciarFichero();
            insertarPersona(per); 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta.setCorrecto(false);
            respuesta.setMensajeError("Ha ocurrido un error al registrar a la persona. Intentalo de nuevo.");
            return respuesta;
        }
        return respuesta;
    }
    
    private static void instanciarFichero() throws Exception{
        try{
            bdPersonas = new File("personas.dat");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static Persona buscarPersonaByDni(String dni) throws Exception{
        try{
            FileInputStream input = new FileInputStream(bdPersonas);
            ObjectInputStream objIS = new ObjectInputStream(input);
            while(input.available() != 0){
                Persona persona = (Persona)objIS.readObject();
                if(persona.getDni().equalsIgnoreCase(dni)){
                    return persona;
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    private static void insertarPersona(Persona per) throws Exception{
        try {
            List<Persona> personas = getListaPersonasFromBD();
            per.setId(generarIdFromList(personas));
            campamentos.add(camp);
            insertarListaCampamentos(campamentos);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static void deleteCampamento(Campamento camp) throws Exception{
        try {
            List<Campamento> campamentos = getListaCampamentosFromBD();
            campamentos = campamentos.stream().filter(c -> c.getId() != camp.getId()).collect(Collectors.toList());
            insertarListaCampamentos(campamentos);
        } catch (Exception e) {
            throw e;
        }
    }
    
    private static Response updateCampamento(Campamento camp) throws Exception{
        Response respuesta = new Response();
        try {
            List<Campamento> campamentos = getListaCampamentosFromBD();
            List<Campamento> campamentosEncontrados = campamentos.stream().filter(c -> c.getId() == camp.getId()).collect(Collectors.toList());
            Campamento encontrado = null;
            if(campamentosEncontrados != null && !campamentosEncontrados.isEmpty()){
                encontrado = campamentosEncontrados.get(0);
            }
            
            if(encontrado != null){
                if(PersonasCampamentosBD.countOfPersonasInCampamento(encontrado) > camp.getCapacidad()){
                    respuesta.setCorrecto(false);
                    respuesta.setMensajeError("Ya hay mas personas inscritas que la nueva capacidad del campamento indicada. Por favor"
                            + " indica una capacidad adecuada o reduce el número de inscripciones para poder continuar.");
                    return respuesta;
                }
                encontrado.setCapacidad(camp.getCapacidad());
                encontrado.setNombre(camp.getNombre());
                encontrado.setLugar(camp.getLugar());
                encontrado.setFechaI(camp.getFechaI());
                encontrado.setFechaF(camp.getFechaF());
            }
            insertarListaCampamentos(campamentos);
            return respuesta;
        } catch (Exception e) {
            return respuesta;
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
    
    private static int generarIdFromList(List<Persona> personas){
        int id = 0;
        if(personas == null || personas.isEmpty()){
            return 0;
        }
        for(Persona p : personas){
            if(p.getId() > id){
                id = p.getId();
            }
        }
        return id+1;
    }
    
    private static List<Persona> getListaPersonasFromBD() throws Exception{
        try{
            List<Persona> personas = new ArrayList<>();
            if(bdPersonas.exists()){
                FileInputStream input = new FileInputStream(bdPersonas);
                ObjectInputStream objIS = new ObjectInputStream(input);
                while(input.available() != 0){
                    Persona camp = (Persona)objIS.readObject();
                    personas.add(camp);
                }
            }
            return personas;
        }catch(Exception ex){
            throw ex;
        }
    }
}
