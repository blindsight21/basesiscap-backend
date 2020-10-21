/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.actividadgobeactgob.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.ActividadGob;
import pe.gob.mimp.siscap.model.ActividadGobEActGob;
import pe.gob.mimp.siscap.repository.actividadgobeactgob.CustomActiGobEActGobRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class ActiGobEActGobRepositoryImpl implements CustomActiGobEActGobRepository{
    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<ActividadGobEActGob> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: ActividadGobEActGobFacade.findByParams :: Starting execution...");

        String selectClause = "select age " + buildSelectClause();
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
//        logger.info(":: ActividadGobEActGobFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: ActividadGobEActGobFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(age.nidActividadGobEActGob) " + buildSelectClause();
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
//        logger.info(":: ActividadGobEActGobFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from ActividadGobEActGob age ";
        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidActividadGobEActGob") != null) {
            whereClause = whereClause + "age.nidActividadGobEActGob = :nidActividadGobEActGob";
        }
        if (parameters.get("nidActividadGob") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "age.nidActividadGob = :nidActividadGob";
        }
        if (parameters.get("nidEstadoActividadGob") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "age.nidEstadoActividadGob = :nidEstadoActividadGob";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "age.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "age.flgActivo = :flgActivo";
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
            if ("nidActividadGobEActGob".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "age.nidActividadGobEActGob";
            }
            if ("nidActividadGob".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "age.nidActividadGob";
            }
            if ("nidEstadoActividadGob".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "age.nidEstadoActividadGob";
            }
        }
        return orderByClause;
    }
    
    @Override
    public List<ActividadGobEActGob> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<ActividadGobEActGob> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(ActividadGobEActGob.class);
        Root<ActividadGobEActGob> entitie = criteriaQuery.from(ActividadGobEActGob.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }


    /*@Override
     public List<ActividadGobEActGob> obtenerActivos(ActividadGob actividad) {
     CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
     CriteriaQuery<ActividadGobEActGob> cq = getEntityManager().getCriteriaBuilder().createQuery(ActividadGobEActGob.class);
     Root<ActividadGobEActGob> registro = cq.from(ActividadGobEActGob.class);

     cq.where(cb.and(
     cb.equal(registro.get(ActividadGobEActGob_.flgActivo), BigInteger.ONE),
     cb.equal(registro.get(ActividadGobEActGob_.nidActividadGobierno), actividad)
     ));

     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
}
