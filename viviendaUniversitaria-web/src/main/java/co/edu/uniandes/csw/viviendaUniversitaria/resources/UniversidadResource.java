/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.UniversidadDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.UniversidadLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
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
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author c.santacruza
 */
@Path("universidades")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class UniversidadResource {

    @Inject
    private UniversidadLogic logic;

    @GET
    public List<UniversidadDetailDTO> getUniversidades() throws BusinessLogicException {
        return listEntity2DetailDTO(logic.findAll());
    }

    private List<UniversidadDetailDTO> listEntity2DetailDTO(List<UniversidadEntity> entityList) {
        List<UniversidadDetailDTO> list = new ArrayList<>();
        for (UniversidadEntity entity : entityList) {
            list.add(new UniversidadDetailDTO(entity));
        }
        return list;
    }

    @GET
    @Path("/{idUni: \\d+}")
    public UniversidadDetailDTO getUniversidad(@PathParam("idUni") Long id) throws BusinessLogicException {
        if (logic.find(id) != null) {
            UniversidadEntity entity = logic.find(id);
            return new UniversidadDetailDTO(entity);
        } else {
            throw new WebApplicationException("La universidad con ese id no existe", 404);
        }
    }

    @POST
    public UniversidadDetailDTO createUniversidad(UniversidadDetailDTO ubi) throws BusinessLogicException {
       
        return new UniversidadDetailDTO(this.logic.create(ubi.toEntity()));

    }

    @PUT
    @Path("{idUni: \\d+}")
    public UniversidadDetailDTO updateUniversidad(@PathParam("idUni") Long idUni, UniversidadDetailDTO ubi) throws BusinessLogicException {
      UniversidadEntity entity = ubi.toEntity();
        entity.setId(idUni);
        UniversidadEntity oldEntity = logic.find(idUni);
        if (oldEntity == null) {
            throw new WebApplicationException("La universidad no existe", 404);
        }
        return new UniversidadDetailDTO(logic.update(entity,idUni));
    }

    @DELETE
    @Path("/{idUni: \\d+}")
    public void deleteUniversidad(@PathParam("idUni") Long id) throws BusinessLogicException, WebApplicationException {
        UniversidadEntity entity = logic.find(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso con id" + id + " no existe", 404);
        } else {
            logic.delete(id);
        }
    }
}
