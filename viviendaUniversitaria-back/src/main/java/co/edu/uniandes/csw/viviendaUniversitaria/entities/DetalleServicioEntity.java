package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela una parte de la factura. ¨Parte que se encarga de registar
 * los servicios que pide un usuario.
 *
 * @author ws.duarte
 */
@Entity
public class DetalleServicioEntity extends BaseEntity {

    /**
     * Total generado por la prestación del servicio.
     */
    private Double subTotal;

    /**
     * Relación con factura.
     */
    @PodamExclude
    @ManyToOne
    private FacturaEntity factura;

    /**
     * Relacion con servicio.
     */
    @PodamExclude
    @ManyToOne
    private ServiciosEntity servicio;

    /**
     * Retorna el total generado por el servicio.
     *
     * @return Total generado por el servicio.
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * Cambia el total generado por el servicio.
     *
     * @param subTotal Nuevo total genreado por el sevicio.
     */
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Retorna la relación con factura.
     *
     * @return Relación con factura.
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * Cambia la relacíon con factura.
     *
     * @param factura Nueva relación con factura.
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     * Retorna la relacion con servicio.
     *
     * @return Relacion con servicio.
     */
    public ServiciosEntity getServicio() {
        return servicio;
    }

    /**
     * Cambia la relacion con servicio.
     *
     * @param servicio Nueva relacion con servicio.
     */
    public void setServicio(ServiciosEntity servicio) {
        this.servicio = servicio;
    }

    /**
     * Determina si dos detalles de servicio son iguales.
     *
     * @param obj Detalle de servicio a comparar.
     * @return True si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DetalleServicioEntity) {
            return super.equals(obj);
        }
        return false;
    }

    /**
     * Retorna el código hash de la entidad.
     * @return Código hash de la entidad.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.subTotal);
        return hash;
    }
}
