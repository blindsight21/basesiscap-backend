/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.tipoobjetivo.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.gob.mimp.siscap.model.TipoObjetivo;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;
import pe.gob.mimp.siscap.repository.tipoobjetivo.TipoObjetivoRepositoryCustom;

/**
 *
 * @author Omar
 */
public class TipoObjetivoRepositoryImpl implements TipoObjetivoRepositoryCustom {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TipoObjetivo> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: TipoObjetivoFacade.findByParams :: Starting execution...");

        String selectClause = "select to " + buildSelectClause();
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
//        logger.info(":: TipoObjetivoFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: TipoObjetivoFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(to.nidTipoObjetivo) " + buildSelectClause();
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
//        logger.info(":: TipoObjetivoFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from TipoObjetivo to ";

        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidTipoObjetivo") != null) {
            whereClause = whereClause + "to.nidTipoObjetivo = :nidTipoObjetivo";
        }
        if (parameters.get("txtTipoObjetivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.txtTipoObjetivo = :txtTipoObjetivo";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.flgActivo = :flgActivo";
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
            if ("nidTipoObjetivo".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "to.nidTipoObjetivo";
            }
            if ("txtTipoObjetivo".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "to.txtTipoObjetivo";
            }
            /*if ("fechaRegistro".equals(orderByElement)) {
             orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
             : "");
             orderByClause = orderByClause + "to.fechaRegistro desc";
             }*/
        }
        return orderByClause;
    }

    /*@Override
     public List<TipoObjetivo> obtenerTipoObjetivoTodos()
     {
     CriteriaQuery<TipoObjetivo> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoObjetivo.class);

     Root<TipoObjetivo> registro = cq.from(TipoObjetivo.class);
        
     cq.distinct(true);       
              
     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoObjetivo_.nidTipoObjetivo)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);
        
     return q.getResultList();
     }
    
     @Override
     public List<TipoObjetivo> obtenerTipoObjetivoActivos()
     {
     CriteriaQuery<TipoObjetivo> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoObjetivo.class);

     Root<TipoObjetivo> registro = cq.from(TipoObjetivo.class);
        
     cq.distinct(true);
        
     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(TipoObjetivo_.flgActivo), BigInteger.ONE)
     ));
               
     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoObjetivo_.nidTipoObjetivo)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);
        
     return q.getResultList();
     }*/
}
