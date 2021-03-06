    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.OrigenDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.OrigenLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author a.eslava
 */
@Path("origenes")
@Produces("application/json")
@Consumes("application/json")
public class OrigenResource {

    OrigenLogic origenLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final String ALGO1 = "El recurso /origenes/";
    private static final String ALGO2 = "no existe";

    public OrigenResource() {
    //fds
    }
    @Inject
    public OrigenResource(OrigenLogic origenLogic) {
        this.origenLogic = origenLogic;
    }
    
    
    /**
     * crea un origen
     * @param origen
     * @return
     * @throws BusinessLogicException 
     */
    @POST
    public OrigenDTO createOrigen(OrigenDTO origen) throws BusinessLogicException {
        OrigenEntity origenEntity = origen.toEntity();
        OrigenEntity nuevoOrigen = origenLogic.create(origenEntity);
        return new OrigenDTO(nuevoOrigen);
    }
/**
 * da la lista de origenes
 * @return
 * @throws BusinessLogicException 
 */
    @GET
    public List<OrigenDTO> getOrigens() throws BusinessLogicException {
        return listEntity2DTO(origenLogic.findAll());
    }
    /**
     * da un origen
     * @param id
     * @return
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{id: \\d+}")
    public OrigenDTO getOrigen(@PathParam("id") Long id) throws BusinessLogicException {
        OrigenEntity entity = origenLogic.find(id);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + id + ALGO2, 404);
        }
        return new OrigenDTO(origenLogic.find(id));
    }
    /**
     * va a la clase intermedia
     * @param idOrigen
     * @return
     * @throws BusinessLogicException 
     */
    @Path("{OrigenesId: \\d+}/estudiantes")
    public Class<OrigenEstudianteResource> getOrigenEstudianteResource(@PathParam("OrigenesId") Long idOrigen) throws BusinessLogicException {
        OrigenEntity entity = origenLogic.find(idOrigen);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + idOrigen + ALGO2, 404);
        }
        return OrigenEstudianteResource.class;
    }

/**
 * acutaliza un origen
 * @param id
 * @param dto
 * @return
 * @throws BusinessLogicException 
 */
    @PUT
    @Path("{id: \\d+}")
    public OrigenDTO updateOrigen(@PathParam("id") Long id, OrigenDTO dto) throws BusinessLogicException {
        OrigenEntity entity = dto.toEntity();
        entity.setId(id);
        OrigenEntity oldEntity = origenLogic.find(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El origen no existe", 404);
        }
        
        entity.setEstudiante(oldEntity.getEstudiantes());
        return new OrigenDTO(origenLogic.update(entity,id));
    }

    /**
     * borra un origen
     * @param id
     * @throws BusinessLogicException 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteOrigen(@PathParam("id") Long id) throws BusinessLogicException {
        OrigenEntity entity = origenLogic.find(id);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + id + ALGO2, 404);
        }
        origenLogic.delete(id);

    }
    /**
     * pasa de entity a DTO
     * @param entityList
     * @return 
     */
    private List<OrigenDTO> listEntity2DTO(List<OrigenEntity> entityList) {
        List<OrigenDTO> list = new ArrayList<>();
        for (OrigenEntity entity : entityList) {
            list.add(new OrigenDTO(entity));
        }
        return list;
    }

}
