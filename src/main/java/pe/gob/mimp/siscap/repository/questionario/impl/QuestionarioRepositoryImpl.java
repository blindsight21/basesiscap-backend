/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.questionario.impl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.Questionario;
import pe.gob.mimp.siscap.model.Questionario_;
import pe.gob.mimp.siscap.repository.questionario.CustomQuestionarioRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class QuestionarioRepositoryImpl implements CustomQuestionarioRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @Override
    public List<Questionario> obtenerQuestionario() {
        CriteriaQuery<Questionario> cq = getEntityManager().getCriteriaBuilder().createQuery(Questionario.class);

        Root<Questionario> registro = cq.from(Questionario.class);

        cq.distinct(true);

        cq.where(getEntityManager().getCriteriaBuilder().and(getEntityManager().getCriteriaBuilder().equal(registro.get(Questionario_.flgActivo), BigInteger.ONE)));
        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(Questionario_.nidQuestionario)));
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }
}
