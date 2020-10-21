/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.vwcantidadactividad.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.VwCantidadActividad;
import pe.gob.mimp.siscap.model.VwCantidadActividad_;
import pe.gob.mimp.siscap.repository.vwcantidadactividad.CustomVwCantidadActRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class VwCantidadActRepositoryImpl implements CustomVwCantidadActRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<VwCantidadActividad> obtenerCantidadActividad(String nombre) {
        CriteriaQuery<VwCantidadActividad> cq = getEntityManager().getCriteriaBuilder().createQuery(VwCantidadActividad.class);

        Root<VwCantidadActividad> registro = cq.from(VwCantidadActividad.class);

        cq.distinct(true);

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get(VwCantidadActividad_.departamentoActividad), nombre)
                ));

        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get(VwCantidadActividad_.departamentoActividad)));
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }

    @Override
    public List<VwCantidadActividad> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<VwCantidadActividad> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(VwCantidadActividad.class);
        Root<VwCantidadActividad> entitie = criteriaQuery.from(VwCantidadActividad.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
