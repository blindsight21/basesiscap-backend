/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.capacitador.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.ActividadGob;
import pe.gob.mimp.siscap.model.Capacitador;
import pe.gob.mimp.siscap.model.Capacitador_;
import pe.gob.mimp.siscap.repository.capacitador.CustomCapacitadorRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class CapacitadorRepositoryImpl implements CustomCapacitadorRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @Override
    public List<Capacitador> obtenerCapacitadorporActividad(ActividadGob actividad)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Capacitador> cq = getEntityManager().getCriteriaBuilder().createQuery(Capacitador.class);
        Root<Capacitador> registro = cq.from(Capacitador.class);
           
        cq.where(cb.and(
                cb.equal(registro.get(Capacitador_.flgActivo), BigInteger.ONE),
                cb.equal(registro.get(Capacitador_.nidActividadGob), actividad)
            ));
        
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        return q.getResultList();
    }
    
    @Override
    public List<Capacitador> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<Capacitador> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(Capacitador.class);
        Root<Capacitador> entitie = criteriaQuery.from(Capacitador.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

}
