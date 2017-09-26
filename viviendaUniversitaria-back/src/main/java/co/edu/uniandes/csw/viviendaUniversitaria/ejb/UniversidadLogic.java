/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.UniversidadPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author c.santacruza
 */
@Stateless
public class UniversidadLogic {

    private static final Logger LOGGER = Logger.getLogger(UniversidadLogic.class.getName());

    @Inject
    private UniversidadPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public UniversidadEntity createUniversidad(UniversidadEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Universidad");
        // Invoca la persistencia para crear la Universidad
        if (persistence.find(entity.getId()) != null) {
            throw new WebApplicationException("Ya existe esta universidad", 404);
        } else {
            LOGGER.info("Termina proceso de creación de Universidad");
            return persistence.create(entity);
        }
    }

    /**
     *
     * Obtener todas las Universidades existentes en la base de datos.
     *
     * @return una lista de Universidades.
     * @throws
     * co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException
     */
    public List<UniversidadEntity> getUniversidades() throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todas las Universidades");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<UniversidadEntity> universidad = persistence.findAll();
        if (universidad.isEmpty()) {
            throw new BusinessLogicException("No existe ninguna universidad");
        } else {
              LOGGER.info("Termina proceso de consultar todas las Universidades");
            return universidad;
        }
    }

    /**
     * Modificar una universidad dado un id.
     *
     * @param id
     * @param entity, contiene la nueva información de la universidad
     * @return
     * @throws
     * co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException
     * @Return UniversidadEntity
     */
    public UniversidadEntity updateUniversidad(Long id, UniversidadEntity entity) throws BusinessLogicException {
        if (entity == null) {
            throw new WebApplicationException("No hay un información para modificar");
        } else {
            return persistence.update(entity);
        }
    }

    /**
     * Elimina una universidad dado un id
     *
     * @param id, el id de la universidad a eliminar
     * @throws
     * co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException
     */
    public void deleteUniversidad(Long id) throws BusinessLogicException {
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No existe la universidad que desea eliminar");
        } else {
            persistence.delete(id);
        }
    }

    public UniversidadEntity getUniversidad(Long id) throws BusinessLogicException {
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No existe la universidad buscada");
        } else {
            return persistence.find(id);
        }
    }
}
