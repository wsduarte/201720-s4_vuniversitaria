/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.OrigenDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.EstudianteLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
@Path("estudiantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EstudianteResource {

    @Inject
    EstudianteLogic estudiante;

    public EstudianteLogic getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteLogic estudiante) {
        this.estudiante = estudiante;
    }

    @GET
    public List<EstudianteDTO> getEstudiantes() throws Exception {
        return listEstudianteEntity2DTO(estudiante.getEstudiantes());
    }

    @GET
    @Path("{cedula: \\d+}")
    public EstudianteDTO getEstudiante(@PathParam("cedula") Long cedula) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.getEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + " no existe.", 404);
        }
        return new EstudianteDTO(entity);
    }

    @POST
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) throws BusinessLogicException {
        return new EstudianteDTO(this.estudiante.createEstudiante(estudiante.toEntity()));
    }

    @DELETE
    @Path("{estudiantesCedula: \\d+}")
    public void deleteEstudiante(@PathParam("estudiantesCedula") Long cedula) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.getEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + " no existe.", 404);
        }
        estudiante.deleteEstudiante(cedula);
    }

    @PUT
    @Path("{cedula: \\d+}")
    public EstudianteDTO updateEstudiante(@PathParam("cedula") Long cedula, EstudianteDTO estu) throws BusinessLogicException {
        estu.setCedula(cedula);
        EstudianteEntity entity = estudiante.getEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + " no existe.", 404);
        }
        return new EstudianteDTO(estudiante.updateEstudiante(estu.toEntity()));
    }

    @Path("{cedulaEstudiante: \\d+}/calificaciones")
    public Class<CalificacionResource> getCalificacionResource(@PathParam("cedulaEstudiante") Long cedulaEstudiante) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.getEstudiante(cedulaEstudiante);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedulaEstudiante + "/calificacion no existe.", 404);
        }
        return CalificacionResource.class;
    }

    private List<EstudianteDTO> listEstudianteEntity2DTO(List<EstudianteEntity> entityList) {
        List<EstudianteDTO> list = new ArrayList<>();
        for (EstudianteEntity entity : entityList) {
            list.add(new EstudianteDTO(entity));
        }
        return list;
    }

    @GET
    @Path("{cedula: \\d+}/origenes")
    public OrigenDTO getOrigen(@PathParam("cedula") Long cedula) {
        return new OrigenDTO(estudiante.getOrigen(cedula));
    }

    @Path("{cedulaEstudiante: \\d+}/reservas")
    public Class<ReservaResource> getReservaResource(@PathParam("cedulaEstudiante") Long cedulaEstudiante) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.getEstudiante(cedulaEstudiante);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedulaEstudiante + "/reservas no existe.", 404);
        }
        return ReservaResource.class;
    }
    
    @Path("{cedulaEstudiante: \\d+}/factura")
    public Class<FacturaResource> getFacturas(@PathParam("cedulaEstudiante") Long cedulaEstudiante) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.getEstudiante(cedulaEstudiante);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedulaEstudiante + "/calificacion no existe.", 404);
        }
        return FacturaResource.class;
    }

}
