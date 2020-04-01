/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.PersonaDao;
import domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Felipe Barrera
 */

@Path("/personas")
@Stateless
public class PersonaServiceRS {
    
    @Inject
    private PersonaDao personaService;
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   
    public List<Persona> listarPersonas(){
        
        return personaService.findAllPersonas();
    }
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Persona econtrarPersonaPorId(@PathParam("id")int id){
    return personaService.findPersonaById(new Persona(id));
    }
    
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarPersona(Persona persona){
       try{
            personaService.insertPersona(persona);
    return Response.ok().entity(persona).build();
       }catch(Exception ex){
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
       }
   
    }
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada){
        try{
        Persona persona = personaService.findPersonaById(new Persona(id));
        if(persona != null){
            personaService.updatePersona(personaModificada);
            return Response.ok().entity(personaModificada).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        }catch(Exception e){
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    @DELETE
    @Path("{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id){
        try {
            personaService.deletePersona(new Persona(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

 
}
