/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.vwactividad.impl;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.VwActividad;
import pe.gob.mimp.siscap.model.VwActividad_;
import pe.gob.mimp.siscap.repository.vwactividad.CustomVwActividadRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class VwActividadRepositoryImpl implements CustomVwActividadRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @Override
    public List<VwActividad> obtenerActividadDepartamento(BigDecimal nidDepartamento) {
        CriteriaQuery<VwActividad> cq = getEntityManager().getCriteriaBuilder().createQuery(VwActividad.class);

        Root<VwActividad> registro = cq.from(VwActividad.class);

        cq.distinct(true);

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get(VwActividad_.nidDepartamento), nidDepartamento.toBigInteger())
                ));

        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get(VwActividad_.nidActividadGob)));
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }
}
