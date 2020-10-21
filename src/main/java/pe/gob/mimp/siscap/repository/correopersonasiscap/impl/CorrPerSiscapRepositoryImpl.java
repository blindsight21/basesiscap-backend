/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.correopersonasiscap.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.CorreoPersonaSiscap;
import pe.gob.mimp.siscap.model.CorreoPersonaSiscap_;
import pe.gob.mimp.siscap.model.PersonaSiscap;
import pe.gob.mimp.siscap.repository.correopersonasiscap.CustomCorrPerSiscapRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class CorrPerSiscapRepositoryImpl implements CustomCorrPerSiscapRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @Override
    public List<CorreoPersonaSiscap> obtenerCorreos(PersonaSiscap personaSiscap) 
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<CorreoPersonaSiscap> cq = getEntityManager().getCriteriaBuilder().createQuery(CorreoPersonaSiscap.class);
        Root<CorreoPersonaSiscap> registro = cq.from(CorreoPersonaSiscap.class);
        
        cq.where(
               cb.and(
                       cb.equal(registro.get(CorreoPersonaSiscap_.flgActivo), BigInteger.ONE),
                       cb.equal(registro.get(CorreoPersonaSiscap_.nidPersonaSiscap), personaSiscap)));
        
        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get(CorreoPersonaSiscap_.nidCorreoPersonaSiscap)));
       
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        return q.getResultList();
    }    
    
    @Override
    public List<CorreoPersonaSiscap> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<CorreoPersonaSiscap> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(CorreoPersonaSiscap.class);
        Root<CorreoPersonaSiscap> entitie = criteriaQuery.from(CorreoPersonaSiscap.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
