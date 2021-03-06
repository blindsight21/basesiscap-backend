/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.actividadgobresultado.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.ActividadGobResultado;
import pe.gob.mimp.siscap.repository.actividadgobresultado.CustomActiGobResultadoRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class ActiGobResultadoRepositoryImpl implements CustomActiGobResultadoRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

   @SuppressWarnings("unchecked")
    @Override
    public List<ActividadGobResultado> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: ActividadGobResultadoFacade.findByParams :: Starting execution...");

        String selectClause = "select agr " + buildSelectClause();
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
//        logger.info(":: ActividadGobResultadoFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: ActividadGobResultadoFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(agr.nidActividadGobResultado) " + buildSelectClause();
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
//        logger.info(":: ActividadGobResultadoFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from ActividadGobResultado agr ";
        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidActividadGobResultado") != null) {
            whereClause = whereClause + "agr.nidActividadGobResultado = :nidActividadGobResultado";
        }
        if (parameters.get("txtActividadGobResultado") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agr.txtActividadGobResultado = :txtActividadGobResultado";
        }
        if (parameters.get("nidNivelEvaluacion") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agr.nidNivelEvaluacion = :nidNivelEvaluacion";
        }
        if (parameters.get("nidActividadGob") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agr.nidActividadGob = :nidActividadGob";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agr.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agr.flgActivo = :flgActivo";
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
            if ("nidActividadGobResultado".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agr.nidActividadGobResultado";
            }
            if ("txtActividadGobResultado".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agr.txtActividadGobResultado";
            }
            if ("nidNivelEvaluacion".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agr.nidNivelEvaluacion";
            }
            if ("nidActividadGob".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agr.nidActividadGob";
            }
        }
        return orderByClause;
    }

    @Override
    public List<ActividadGobResultado> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<ActividadGobResultado> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(ActividadGobResultado.class);
        Root<ActividadGobResultado> entitie = criteriaQuery.from(ActividadGobResultado.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    /*@Override
     public List<ActividadGobResultado> obtenerResultadoActivos(ActividadGob actividad)
     {
     CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
     CriteriaQuery<ActividadGobResultado> cq = getEntityManager().getCriteriaBuilder().createQuery(ActividadGobResultado.class);
     Root<ActividadGobResultado> registro = cq.from(ActividadGobResultado.class);
           
     cq.where(cb.and(
     cb.equal(registro.get(ActividadGobResultado_.flgActivo), BigInteger.ONE),
     cb.equal(registro.get(ActividadGobResultado_.nidActividadGob), actividad)
     ));
        
     javax.persistence.Query q = getEntityManager().createQuery(cq);
        
     return q.getResultList();
     }*/
}
