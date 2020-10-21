/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.tipofuncion.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.gob.mimp.siscap.model.TipoFuncion;
import pe.gob.mimp.siscap.repository.tipofuncion.CustomTipoFuncionRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class TipoFuncionRepositoryImpl implements CustomTipoFuncionRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TipoFuncion> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: TipoFuncionFacade.findByParams :: Starting execution...");

        String selectClause = "select tf " + buildSelectClause();
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
//        logger.info(":: TipoFuncionFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: TipoFuncionFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(tf.nidTipoFuncion) " + buildSelectClause();
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
//        logger.info(":: TipoFuncionFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from TipoFuncion tf ";

        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidTipoFuncion") != null) {
            whereClause = whereClause + "tf.nidTipoFuncion = :nidTipoFuncion";
        }
        if (parameters.get("txtTipoFuncion") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tf.txtTipoFuncion = :txtTipoFuncion";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tf.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tf.flgActivo = :flgActivo";
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
            if ("nidTipoFuncion".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "tf.nidTipoFuncion";
            }
            if ("txtTipoFuncion".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "tf.txtTipoFuncion";
            }
            /*if ("fechaRegistro".equals(orderByElement)) {
             orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
             : "");
             orderByClause = orderByClause + "tf.fechaRegistro desc";
             }*/
        }
        return orderByClause;
    }


    /*@Override
     public List<TipoFuncion> obtenerTipoFuncionTodos() {
     CriteriaQuery<TipoFuncion> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoFuncion.class);

     Root<TipoFuncion> registro = cq.from(TipoFuncion.class);

     cq.distinct(true);

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoFuncion_.nidTipoFuncion)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }

     @Override
     public List<TipoFuncion> obtenerTipoFuncionActivos() {
     CriteriaQuery<TipoFuncion> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoFuncion.class);

     Root<TipoFuncion> registro = cq.from(TipoFuncion.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(TipoFuncion_.flgActivo), BigInteger.ONE)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoFuncion_.nidTipoFuncion)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
    
}
