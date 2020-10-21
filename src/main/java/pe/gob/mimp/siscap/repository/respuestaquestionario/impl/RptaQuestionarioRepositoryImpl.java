/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.respuestaquestionario.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.Questionario;
import pe.gob.mimp.siscap.model.RespuestaQuestionario;
import pe.gob.mimp.siscap.model.RespuestaQuestionario_;
import pe.gob.mimp.siscap.repository.respuestaquestionario.CustomRptaQuestionarioRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class RptaQuestionarioRepositoryImpl implements CustomRptaQuestionarioRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @Override
    public List<RespuestaQuestionario> obtenerRespuestas(Questionario questionario) {
        CriteriaQuery<RespuestaQuestionario> cq = getEntityManager().getCriteriaBuilder().createQuery(RespuestaQuestionario.class);
        Root<RespuestaQuestionario> registro = cq.from(RespuestaQuestionario.class);

        cq.distinct(true);

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get(RespuestaQuestionario_.nidQuestionario), questionario)
                ));

        cq.orderBy(
                getEntityManager().getCriteriaBuilder().asc(registro.get(RespuestaQuestionario_.numOrden))
        );
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }
    
}
