/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.archivoactividadgob.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.ArchivoActividadGob;
import pe.gob.mimp.siscap.repository.archivoactividadgob.CustomArchivoActGobRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class ArchivoActGobRepositoryImpl implements CustomArchivoActGobRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<ArchivoActividadGob> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<ArchivoActividadGob> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(ArchivoActividadGob.class);
        Root<ArchivoActividadGob> entitie = criteriaQuery.from(ArchivoActividadGob.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
}
