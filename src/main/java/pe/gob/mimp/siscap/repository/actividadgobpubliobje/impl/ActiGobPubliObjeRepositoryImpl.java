/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.actividadgobpubliobje.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.ActividadGobPubliObje;
import pe.gob.mimp.siscap.repository.actividadgobpubliobje.CustomActiGobPubliObjeRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class ActiGobPubliObjeRepositoryImpl implements CustomActiGobPubliObjeRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ActividadGobPubliObje> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: ActividadGobPubliObjeFacade.findByParams :: Starting execution...");

        String selectClause = "select agpo " + buildSelectClause();
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
//        logger.info(":: ActividadGobPubliObjeFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: ActividadGobPubliObjeFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(agpo.nidActividadGobPubliObje) " + buildSelectClause();
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
//        logger.info(":: ActividadGobPubliObjeFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from ActividadGobPubliObje agpo ";
        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidActividadGobPubliObje") != null) {
            whereClause = whereClause + "agpo.nidActividadGobPubliObje = :nidActividadGobPubliObje";
        }
        if (parameters.get("nidActividadGob") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agpo.nidActividadGob = :nidActividadGob";
        }
        if (parameters.get("nidPublicoObjetivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agpo.nidPublicoObjetivo = :nidPublicoObjetivo";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agpo.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "agpo.flgActivo = :flgActivo";
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
            if ("nidActividadGobPubliObje".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agpo.nidActividadGobPubliObje";
            }
            if ("nidActividadGob".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agpo.nidActividadGob";
            }
            if ("nidPublicoObjetivo".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "agpo.nidPublicoObjetivo";
            }
        }
        return orderByClause;
    }
    
    @Override
    public List<ActividadGobPubliObje> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<ActividadGobPubliObje> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(ActividadGobPubliObje.class);
        Root<ActividadGobPubliObje> entitie = criteriaQuery.from(ActividadGobPubliObje.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    /*
     @Override
     public List<ActividadGobPubliObje> obtenerPublicoObjetivoActivos(ActividadGob actividad)
     {
     CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
     CriteriaQuery<ActividadGobPubliObje> cq = getEntityManager().getCriteriaBuilder().createQuery(ActividadGobPubliObje.class);
     Root<ActividadGobPubliObje> registro = cq.from(ActividadGobPubliObje.class);
           
     cq.where(cb.and(
     cb.equal(registro.get(ActividadGobPubliObje_.flgActivo), BigInteger.ONE),
     cb.equal(registro.get(ActividadGobPubliObje_.nidActividadGob), actividad)
     ));
        
     javax.persistence.Query q = getEntityManager().createQuery(cq);
        
     return q.getResultList();
     }*/
}
