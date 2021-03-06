/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela un hospedaje.
 * @author ws.duarte
 */
@Entity
public class HospedajeEntity extends BaseEntity {

    /**
     * Tipo de arrendamiento del hospedaje.
     */
    private String tipoArrendamiento;

    /**
     * Descripción del hospadaje.
     */
    private String descripcion;

    /**
     * Valoración total del hospadaje.
     */
    private Double valoracion;

    /**
     * Cantidad de votos totales.
     */
    private Integer cantidadVotaciones;
    
    /**
     * Ruta de la image asociada a este hospedaje.
     */
    private String rutaImagen;
    /**
     * Relacion ubicacion.
     */
    private UbicacionEntity ubicacion;

    /**
     * Relación con regla.
     */
    @PodamExclude
    @OneToMany(mappedBy = "hospedaje", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReglaEntity> reglas;

    /**
     * Relción con servicios.
     */
    @PodamExclude
    @OneToMany(mappedBy = "hospedaje", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ServiciosEntity> servicios;

    /**
     * Relación con hospedajeLugar.
     */
    @PodamExclude
    @OneToMany(mappedBy = "hospedaje", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<HospedajeLugarEntity> hospedajesLugares;

    /**
     * Relación con facturas.
     */
    @PodamExclude
    @OneToMany(mappedBy = "hospedaje", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FacturaEntity> facturas;

    /**
     * Relación con reserva.
     */
    @PodamExclude
    @OneToMany(mappedBy = "hospedaje", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReservaEntity> reservas;

    /**
     * Relación con calificaciónes.
     */
    @PodamExclude
    @OneToMany(mappedBy = "hospedaje", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CalificacionEntity> calificaciones;

    /**
     * Relación con arrendador.
     */
    @PodamExclude
    @ManyToOne(fetch = FetchType.LAZY)
    private ArrendadorEntity arrendador;

    /**
     * Retorna la ruta de la imagen del hospedaje.
     * @return Ruta de la imagen del hospedaje.
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * Cambia la ruta de la imagen del hospedaje.
     * @param rutaImagen Nueva ruta de la imagen.
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * Retorna el tipo de arreendamiento del hospedaje.
     * @return Tipo de arrendamiento del hospedaje.
     */
    public String getTipoArrendamiento() {
        return tipoArrendamiento;
    }

    /**
     * Cambia el tipo de arrendamiento del hospedaje.
     *
     * @param tipoArrendamiento Nuevo tipo de arrendamiento para el hospedaje.
     */
    public void setTipoArrendamiento(String tipoArrendamiento) {
        this.tipoArrendamiento = tipoArrendamiento;
    }

    /**
     * Retorna la dercripción del hospedaje.
     *
     * @return Descripción del hospeadaje.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambi la descripción del hospedaje.
     *
     * @param descripcion Nueva descripción del hospadaje.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna la valoración del hospadaje.
     *
     * @return Valoración del hospadaje.
     */
    public Double getValoracion() {
        return valoracion;
    }

    /**
     * Cambiia la valoración del hospedaje.
     *
     * @param valoracion Nueva valoración para el hospedaje.
     */
    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }

    /**
     * Retorna la relacíon con las reglas.
     *
     * @return Relación con las reglas.
     */
    public List<ReglaEntity> getReglas() {
        return reglas;
    }

    /**
     * Cambia la relación con regla.
     *
     * @param reglas Nueva relación con regla.
     */
    public void setReglas(List<ReglaEntity> reglas) {
        this.reglas = reglas;
    }

    /**
     * Retorna la relación con servicios.
     *
     * @return Relación con servicios.
     */
    public List<ServiciosEntity> getServicios() {
        return servicios;
    }

    /**
     * Cambia la relación con servicios.
     *
     * @param servicios Nueva relación con servicios.
     */
    public void setServicios(List<ServiciosEntity> servicios) {
        this.servicios = servicios;
    }

    /**
     * Retorna la relación con hospedajeLugar.
     *
     * @return Relación con hospedajeLugar.
     */
    public List<HospedajeLugarEntity> getHospedajesLugares() {
        return hospedajesLugares;
    }

    /**
     * Cambia la relación con hospedajeLugar.
     *
     * @param hospedajesLugares Nueva relación entre hospedajeLugar.
     */
    public void setHospedajesLugares(List<HospedajeLugarEntity> hospedajesLugares) {
        this.hospedajesLugares = hospedajesLugares;
    }

    /**
     * Retorna la relacíon con reserva.
     *
     * @return Relación con reserva.
     */
    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    /**
     * Cambia la relación con reserva.
     *
     * @param reservas Nueva relación con reserva.
     */
    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }

    /**
     * Retorna la relación con calificaciones.
     *
     * @return Relación con calificación.
     */
    public List<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    /**
     * Cambia la relación con calificacíon.
     *
     * @param calificaciones Nueva relación con calificación.
     */
    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * Retorna la relación con arrendador.
     *
     * @return Relación con arrendador.
     */
    public ArrendadorEntity getArrendador() {
        return arrendador;
    }

    /**
     * Cambia la relación con arrendador.
     *
     * @param arrendador Nueva relacíon con arrendador.
     */
    public void setArrendador(ArrendadorEntity arrendador) {
        this.arrendador = arrendador;
    }

    /**
     * Retorna la relación con ubicación.
     *
     * @return Relación con ubicación.
     */
    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    /**
     * Cambia la relación conubicación.
     *
     * @param ubicacion Nueva relación con ubicación.
     */
    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Retorna la relación con facturas.
     * @return  Relación con factura.
     */
    public List<FacturaEntity> getFacturas() {
        return facturas;
    }

    /**
     * Cambia la relación con factura.
     * @param facturas Nueva relación con factura.
     */
    public void setFacturas(List<FacturaEntity> facturas) {
        this.facturas = facturas;
    }

    /**
     * Determina si dos hospedajes son iguales.
     *
     * @param obj Hospedaje a comparar.
     * @return True si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HospedajeEntity) {
            return super.equals(obj);
        } else {
            return false;
        }
    }

    /**
     * Retorna el código hash respectivo a hospefdsaje.
     * @return código hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.tipoArrendamiento);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.valoracion);
        hash = 97 * hash + Objects.hashCode(this.cantidadVotaciones);
        hash = 97 * hash + Objects.hashCode(this.ubicacion);
        return hash;
    }

    /**
     * Retorna la cantidad de votos totales.
     *
     * @return Cantidad de votos totales.
     */
    public Integer getCantidadVotaciones() {
        return cantidadVotaciones;
    }

    /**
     * Cambia el valor de la cantidad de realciones totales.
     *
     * @param cantidadVotaciones Nueva cantidad de realciones totales.
     */
    public void setCantidadVotaciones(Integer cantidadVotaciones) {
        this.cantidadVotaciones = cantidadVotaciones;
    }

    /**
     * Incremaenta la cantidad de voraciónes y actualiza la valoración total.
     *
     * @param calificacion calificación a agregar.
     */
    public void incrementarCalificacion(CalificacionEntity calificacion) {
        valoracion = ((valoracion * cantidadVotaciones) + calificacion.getValoracion()) / (cantidadVotaciones + 1);
        cantidadVotaciones++;
    }   
}
