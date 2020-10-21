/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.actividadgobpubliproc.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.ActividadGobPubliProc;
import pe.gob.mimp.siscap.repository.actividadgobpubliproc.CustomActiGobPubliProcRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class ActiGobPubliProcRepositoryImpl implements CustomActiGobPubliProcRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

   @SuppressWarnings("unchecked")
    @Override
    public List<ActividadGobPubliProc> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: ActividadGobPubliProcFacade.findByParams :: Starting execution...");

        String selectClause = "select agpp " + buildSelectClause();
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
//        logger.info(":: ActividadGobPubliProcFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: ActividadGobPubliProcFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(agpp.nidActividadGobProcGob) " + buildSelectClause();
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
//        logger.info(":: ActividadGobPubliProcFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from ActividadGobPubliProc agpp ";
        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidActividadGobProcGob") != null) {
            whereClause = whereClause + "agpp.nidActividadGobProcGob = :nidActividadGobProcGob";
        }
        if (parameters.get("nidActividadGob") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agpp.nidActividadGob = :nidActividadGob";
        }
        if (parameters.get("nidGobierno") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agpp.nidGobierno = :nidGobierno";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agpp.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agpp.flgActivo = :flgActivo";
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
            if ("nidActividadGobProcGob".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : ""); 
                orderByClause = orderByClause + "agpp.nidActividadGobProcGob";
            }
            if ("nidActividadGob".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agpp.nidActividadGob";
            }
            if ("nidGobierno".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agpp.nidGobierno";
            }
        }
        return orderByClause;
    }

    @Override
    public List<ActividadGobPubliProc> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<ActividadGobPubliProc> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(ActividadGobPubliProc.class);
        Root<ActividadGobPubliProc> entitie = criteriaQuery.from(ActividadGobPubliProc.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    /*@Override
     public List<ActividadGobPubliProc> obtenerPublicoObjeProceActivos(ActividadGob actividad) {
     CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
     CriteriaQuery<ActividadGobPubliProc> cq = getEntityManager().getCriteriaBuilder().createQuery(ActividadGobPubliProc.class);
     Root<ActividadGobPubliProc> registro = cq.from(ActividadGobPubliProc.class);

     cq.where(cb.and(
     cb.equal(registro.get(ActividadGobPubliProc_.flgActivo), BigInteger.ONE),
     cb.equal(registro.get(ActividadGobPubliProc_.nidActividadGobierno), actividad)
     ));

     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
}
