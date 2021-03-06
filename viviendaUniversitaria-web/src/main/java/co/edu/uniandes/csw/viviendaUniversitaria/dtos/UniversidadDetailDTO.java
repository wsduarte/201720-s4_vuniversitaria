/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;

/**
 *
 * @author c.santacruza
 */
public class UniversidadDetailDTO extends UniversidadDTO {

    /**
     * Relación con ubicacion.
     */
    private UbicacionDetailDTO ubicacion;
    
    /**
     * Constructor po defecto.
     */
    public UniversidadDetailDTO() {
        //Vacio por defecto
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public UniversidadDetailDTO(UniversidadEntity entity) {
        super(entity);
        if (entity.getUbicacion() != null) {
            this.ubicacion = new UbicacionDetailDTO(entity.getUbicacion());
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return
     */
    @Override
    public UniversidadEntity toEntity() {
        UniversidadEntity u = super.toEntity();
        if (ubicacion != null) {
            u.setUbicacion(ubicacion.toEntity());
        }
        return u;
    }
    /**
     * Retorna la ubicación de una universidad
     * @return ubicacionDTO
     */
    public UbicacionDetailDTO getUbicacion() {
        return ubicacion;
    }
    /**
     * Modifica la ubicación de una universidad
     * @param ubicacion 
     */
    public void setUbicacion(UbicacionDetailDTO ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
