/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author a.eslava
 */
@Entity
public class OrigenEntity extends BaseEntity implements Serializable{
    private String name;
    
    @PodamExclude
    @OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = true ,mappedBy = "origen", fetch=FetchType.LAZY)
    private List<EstudianteEntity> estudiante;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EstudianteEntity> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(List<EstudianteEntity> estudiante) {
        this.estudiante = estudiante;
    }
}
