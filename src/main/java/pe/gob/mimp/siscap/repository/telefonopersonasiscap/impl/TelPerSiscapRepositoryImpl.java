/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.telefonopersonasiscap.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.PersonaSiscap;
import pe.gob.mimp.siscap.model.TelefonoPersonaSiscap;
import pe.gob.mimp.siscap.model.TelefonoPersonaSiscap_;
import pe.gob.mimp.siscap.repository.telefonopersonasiscap.CustomTelPerSiscapRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class TelPerSiscapRepositoryImpl implements CustomTelPerSiscapRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @Override
    public List<TelefonoPersonaSiscap> obtenerTelefonos(PersonaSiscap personaSiscap) 
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<TelefonoPersonaSiscap> cq = getEntityManager().getCriteriaBuilder().createQuery(TelefonoPersonaSiscap.class);
        Root<TelefonoPersonaSiscap> registro = cq.from(TelefonoPersonaSiscap.class);
        
        cq.where(
               cb.and(
                       cb.equal(registro.get(TelefonoPersonaSiscap_.flgActivo), BigInteger.ONE),
                       cb.equal(registro.get(TelefonoPersonaSiscap_.nidPersonaSiscap), personaSiscap)));
        
        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get(TelefonoPersonaSiscap_.nidTelefonoPersonaSiscap)));
       
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        return q.getResultList();
    }
}
