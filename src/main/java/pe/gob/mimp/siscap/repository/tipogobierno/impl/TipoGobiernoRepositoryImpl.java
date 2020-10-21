/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.tipogobierno.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.gob.mimp.siscap.model.TipoGobierno;
import pe.gob.mimp.siscap.repository.tipogobierno.CustomTipoGobiernoRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class TipoGobiernoRepositoryImpl implements CustomTipoGobiernoRepository{
    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TipoGobierno> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: TipoGobiernoFacade.findByParams :: Starting execution...");

        String selectClause = "select tg " + buildSelectClause();
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
//        logger.info(":: TipoGobiernoFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: TipoGobiernoFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(tg.nidTipoGobierno) " + buildSelectClause();
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
//        logger.info(":: TipoGobiernoFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from TipoGobierno tg ";

        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidTipoGobierno") != null) {
            whereClause = whereClause + "tg.nidTipoGobierno = :nidTipoGobierno";
        }
        if (parameters.get("txtTipoGobierno") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tg.txtTipoGobierno = :txtTipoGobierno";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tg.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tg.flgActivo = :flgActivo";
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
            if ("nidTipoGobierno".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "tg.nidTipoGobierno";
            }
            if ("txtTipoGobierno".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "tg.txtTipoGobierno";
            }
            /*if ("fechaRegistro".equals(orderByElement)) {
             orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
             : "");
             orderByClause = orderByClause + "tg.fechaRegistro desc";
             }*/
        }
        return orderByClause;
    }

    /*@Override
     public List<TipoGobierno> obtenerTipoGobiernoTodos() {
     CriteriaQuery<TipoGobierno> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoGobierno.class);

     Root<TipoGobierno> registro = cq.from(TipoGobierno.class);

     cq.distinct(true);

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoGobierno_.nidTipoGobierno)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }

     @Override
     public List<TipoGobierno> obtenerTipoGobiernoActivos() {
     CriteriaQuery<TipoGobierno> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoGobierno.class);

     Root<TipoGobierno> registro = cq.from(TipoGobierno.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(TipoGobierno_.flgActivo), BigInteger.ONE)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoGobierno_.nidTipoGobierno)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
}
