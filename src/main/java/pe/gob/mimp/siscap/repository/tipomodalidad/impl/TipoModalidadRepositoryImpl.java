/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.tipomodalidad.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.gob.mimp.siscap.model.TipoModalidad;
import pe.gob.mimp.siscap.repository.tipomodalidad.CustomTipoModalidadRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class TipoModalidadRepositoryImpl implements CustomTipoModalidadRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TipoModalidad> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: TipoModalidadFacade.findByParams :: Starting execution...");

        String selectClause = "select tm " + buildSelectClause();
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
//        logger.info(":: TipoModalidadFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: TipoModalidadFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(tm.nidTipoModalidad) " + buildSelectClause();
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
//        logger.info(":: TipoModalidadFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from TipoModalidad tm ";

        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidTipoModalidad") != null) {
            whereClause = whereClause + "tm.nidTipoModalidad = :nidTipoModalidad";
        }
        if (parameters.get("txtTipoModalidad") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tm.txtTipoModalidad = :txtTipoModalidad";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tm.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "tm.flgActivo = :flgActivo";
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
            if ("nidTipoModalidad".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "tm.nidTipoModalidad";
            }
            if ("txtTipoModalidad".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "tm.txtTipoModalidad";
            }
            /*if ("fechaRegistro".equals(orderByElement)) {
             orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
             : "");
             orderByClause = orderByClause + "tm.fechaRegistro desc";
             }*/
        }
        return orderByClause;
    }

    /*@Override
     public List<TipoModalidad> obtenerTipoModalidadTodos() {
     CriteriaQuery<TipoModalidad> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoModalidad.class);

     Root<TipoModalidad> registro = cq.from(TipoModalidad.class);

     cq.distinct(true);

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoModalidad_.nidTipoModalidad)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }

     @Override
     public List<TipoModalidad> obtenerTipoModalidadActivos() {
     CriteriaQuery<TipoModalidad> cq = getEntityManager().getCriteriaBuilder().createQuery(TipoModalidad.class);

     Root<TipoModalidad> registro = cq.from(TipoModalidad.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(TipoModalidad_.flgActivo), BigInteger.ONE)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(TipoModalidad_.nidTipoModalidad)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
    
}
