/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author a.eslava
 */
@Entity
public class ReservaEntity extends BaseEntity{

    private Long cedulaHuesped;
    private Long idHospedaje;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @PodamExclude
    @OneToOne
    private EstudianteEntity estudiante;
    
    @PodamExclude
    @OneToOne
    private HospedajeEntity hospedaje;
    
    @PodamExclude
    @OneToMany(fetch = FetchType.LAZY)
    private List<DetalleReservaEntity> detalleReserva;

    public List<DetalleReservaEntity> getDetalleReserva() {
        return detalleReserva;
    }

    public HospedajeEntity getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }

    public void setDetalleReserva(List<DetalleReservaEntity> detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCedulaHuesped() {
        return cedulaHuesped;
    }

    public void setCedulaHuesped(Long cedulaHuesped) {
        this.cedulaHuesped = cedulaHuesped;
    }

    public Long getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(Long idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        
        this.fechaInicio = fechaInicio;

    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
