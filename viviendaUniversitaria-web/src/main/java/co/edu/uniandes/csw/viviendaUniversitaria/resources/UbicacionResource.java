/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.UbicacionDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.UbicacionLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
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
@Path("ubicaciones")
@Produces("application/json")
@Consumes("application/json")
@Stateless

public class UbicacionResource {
    /**
     * Inject 
     */
    @Inject
    private UbicacionLogic logic;

    @GET
    public List<UbicacionDetailDTO> getUbicaciones() {
            return listEntity2DetailDTO(logic.findAll());
        
    }

    private List<UbicacionDetailDTO> listEntity2DetailDTO(List<UbicacionEntity> entityList) {
        List<UbicacionDetailDTO> list = new ArrayList<>();
        for (UbicacionEntity entity : entityList) {
            list.add(new UbicacionDetailDTO(entity));
        }
        return list;
    }

    @GET
    @Path("/{idUbicacion: [0-9][0-9]*}")
    public UbicacionDetailDTO getUbicacion(@PathParam("idUbicacion") Long id) throws BusinessLogicException {
        if (logic.find(id) != null) {
            UbicacionEntity entity = logic.find(id);
            return new UbicacionDetailDTO(entity);
        } else {
            throw new WebApplicationException("La ubicacion con ese id no existe", 404);
        }
    }

    @PUT
    @Path("/{idUbicacion: [0-9][0-9]*}")
    public UbicacionDetailDTO updateUbicacion(@PathParam("idUbicacion") Long id, UbicacionDetailDTO ubi) throws BusinessLogicException {
       UbicacionEntity entity = ubi.toEntity();
        entity.setId(id);
        UbicacionEntity oldEntity = logic.find(id);
        if (oldEntity == null) {
            throw new WebApplicationException("La ubicacion no existe", 404);
        }
        return new UbicacionDetailDTO(logic.update(entity,id));
    }
    @POST
    public UbicacionDetailDTO createUbicacion(UbicacionDetailDTO ubi) throws BusinessLogicException {
       UbicacionEntity ubicacionEntity = ubi.toEntity();
        UbicacionEntity nuevaUbi = logic.create(ubicacionEntity);
        return new UbicacionDetailDTO(nuevaUbi);
    }
}
