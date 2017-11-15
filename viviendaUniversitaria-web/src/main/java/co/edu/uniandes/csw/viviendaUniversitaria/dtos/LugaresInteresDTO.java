/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;

/**
 *
 * @author jc.sanguino10
 */
public class LugaresInteresDTO {

    /**
     * Atributo que modela el id del Lugar de Interes
     */
    private Long id;
    /**
     * Atributo que modela algunos comentarios del propietario sobre su
     * hospedaje
     */
    private String descripcion;
    /**
     * Modela la distancia desde el lugar de interes al hospedaje
     */
    private double distancia;
    /**
     * Imagen del lugar de interes
     */
    private String rutaImagen;

    /**
     * Constructor por defecto
     */
    public LugaresInteresDTO() {
        //Constructor vacío por default
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param lugarInteres: Es la entidad que se va a convertir a DTO
     */
    public LugaresInteresDTO(LugaresInteresEntity lugarInteres) {
        this.descripcion = lugarInteres.getDescripcion();
        this.id = lugarInteres.getId();
        this.rutaImagen = lugarInteres.getRutaImagen();
        this.distancia = lugarInteres.getDistancia();
    }

    /**
     * Retorna el id del dto Lugar de Interes
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el id del dto Lugar de Interes
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna la descripcion del dto Lugar de Interes
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripcion del dto Lugar de Interes
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna la distancia del dto Lugar de Interes
     *
     * @return distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * Cambia la distancia del dto Lugar de Interes
     *
     * @param distancia
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * Retorna la ruta de imagen del dto Lugar de Interes
     *
     * @return rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * Cambia la ruta de imagen del dto Lugar de Interes
     *
     * @param rutaImagen
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * Realiza el cambio de un dto Lugar de Interes a un entity
     *
     * @return LugarInteresEntity
     */
    public LugaresInteresEntity toEntity() {
        LugaresInteresEntity lugaresInteresEntity = new LugaresInteresEntity();
        lugaresInteresEntity.setDescripcion(this.descripcion);
        lugaresInteresEntity.setDistancia(this.distancia);
        lugaresInteresEntity.setRutaImagen(this.rutaImagen);
        lugaresInteresEntity.setId(this.id);
        return lugaresInteresEntity;
    }

}
