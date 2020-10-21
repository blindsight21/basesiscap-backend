/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.nivelevaluacion.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.gob.mimp.siscap.model.NivelEvaluacion;
import pe.gob.mimp.siscap.repository.nivelevaluacion.CustomNivelEvalRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class NivelEvalRepositoryImpl implements CustomNivelEvalRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<NivelEvaluacion> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: NivelEvaluacionFacade.findByParams :: Starting execution...");

        String selectClause = "select ne " + buildSelectClause();
        String whereClause = buildWhereClause(parameters);

        if (!Funciones.esVacio(whereClause)) {
            whereClause = " where " + whereClause;
        }

        String orderClause = buildOrderByClause(orderBy);
        if (!Funciones.esVacio(orderClause)) {
            orderClause = " order by " + orderClause;
        } else {
            orderClause = "";
        }

        String hql = selectClause + whereClause + orderClause;

//        logger.info("   SISCAP HQL: " + hql);

        Query q = getEntityManager().createQuery(hql);
        for (Map.Entry<String, Object> map : parameters.entrySet()) {
            q.setParameter(map.getKey(), map.getValue());
        }
//        logger.info(
//                ":: NivelEvaluacionFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: NivelEvaluacionFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(ne.nidNivelEvaluacion) " + buildSelectClause();
        selectClause = selectClause.replaceAll("fetch ", CoreConstant.BLANCO);
        String whereClause = buildWhereClause(parameters);
        if (!Funciones.esVacio(whereClause)) {
            whereClause = " where " + whereClause;
        }

        String hql = selectClause + whereClause;

//        logger.info("getRecordCount HQL: " + hql);

        Query q = getEntityManager().createQuery(hql);

        for (Map.Entry<String, Object> map : parameters.entrySet()) {
            q.setParameter(map.getKey(), map.getValue());
        }
//        logger.info(":: NivelEvaluacionFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from NivelEvaluacion ne ";
        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidNivelEvaluacion") != null) {
            whereClause = whereClause + "ne.nidNivelEvaluacion = :nidNivelEvaluacion";
        }
        if (parameters.get("txtNivelEvaluacion") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ne.txtNivelEvaluacion = :txtNivelEvaluacion";
        }
        if (parameters.get("nidTipoEvaluacion") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ne.nidTipoEvaluacion = :nidTipoEvaluacion";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ne.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ne.flgActivo = :flgActivo";
        }
        return whereClause;
    }

    private String buildOrderByClause(String orderBy) {
        if (Funciones.esVacio(orderBy)) {
            return null;
        }

        String orderByClause = "";
        String[] orderByArray = orderBy.split(CoreConstant.SEPARATOR_COMA);
        for (String orderByElement : orderByArray) {
            if ("nidNivelEvaluacion".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "ne.nidNivelEvaluacion";
            }
            if ("txtNivelEvaluacion".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "ne.txtNivelEvaluacion";
            }
        }
        return orderByClause;
    }

    /*@Override
     public List<NivelEvaluacion> obtenerNivelEvaluacionActivos()
     {
     CriteriaQuery<NivelEvaluacion> cq = getEntityManager().getCriteriaBuilder().createQuery(NivelEvaluacion.class);

     Root<NivelEvaluacion> registro = cq.from(NivelEvaluacion.class);
        
     cq.distinct(true);
        
     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(NivelEvaluacion_.flgActivo), BigInteger.ONE)
     ));
               
     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(NivelEvaluacion_.nidNivelEvaluacion)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);
        
     return q.getResultList();
     }
    
     @Override
     public List<NivelEvaluacion> obtenerNivelEvaluacionporTipo(TipoEvaluacion tipoEvaluacion)
     {
     CriteriaQuery<NivelEvaluacion> cq = getEntityManager().getCriteriaBuilder().createQuery(NivelEvaluacion.class);
     Root<NivelEvaluacion> registro = cq.from(NivelEvaluacion.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(NivelEvaluacion_.flgActivo), BigInteger.ONE), 
     getEntityManager().getCriteriaBuilder().equal(registro.get(NivelEvaluacion_.nidTipoEvaluacion), tipoEvaluacion)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get(NivelEvaluacion_.nidNivelEvaluacion)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
}
