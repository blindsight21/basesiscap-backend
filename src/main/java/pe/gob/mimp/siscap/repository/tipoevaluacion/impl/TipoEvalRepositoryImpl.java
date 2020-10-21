/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.tipoevaluacion.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.gob.mimp.siscap.model.TipoEvaluacion;
import pe.gob.mimp.siscap.repository.tipoevaluacion.CustomTipoEvalRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class TipoEvalRepositoryImpl implements CustomTipoEvalRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TipoEvaluacion> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: TipoEvaluacionFacade.findByParams :: Starting execution...");

        String selectClause = "select te " + buildSelectClause();
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
//        logger.info(":: TipoEvaluacionFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: TipoEvaluacionFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(te.nidTipoEvaluacion) " + buildSelectClause();
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
//        logger.info(":: TipoEvaluacionFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from TipoEvaluacion te ";

        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidTipoEvaluacion") != null) {
            whereClause = whereClause + "te.nidTipoEvaluacion = :nidTipoEvaluacion";
        }
        if (parameters.get("txtTipoEvaluacion") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "te.txtTipoEvaluacion = :txtTipoEvaluacion";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "te.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "te.flgActivo = :flgActivo";
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
            if ("nidTipoEvaluacion".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "te.nidTipoEvaluacion";
            }
            if ("txtTipoEvaluacion".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "te.txtTipoEvaluacion";
            }
        }
        return orderByClause;
    }

    /*@Override
     public List<TipoEvaluacion> obtenerTipoEvaluacionTodos() {
     CriteriaQuery<TipoEvaluacion> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoEvaluacion.class);

     Root<TipoEvaluacion> registro = cq.from(TipoEvaluacion.class);

     cq.distinct(true);

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoEvaluacion_.nidTipoEvaluacion)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }

     @Override
     public List<TipoEvaluacion> obtenerTipoEvaluacionActivos() {
     CriteriaQuery<TipoEvaluacion> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoEvaluacion.class);

     Root<TipoEvaluacion> registro = cq.from(TipoEvaluacion.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(TipoEvaluacion_.flgActivo), BigInteger.ONE)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoEvaluacion_.nidTipoEvaluacion)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
    
}
