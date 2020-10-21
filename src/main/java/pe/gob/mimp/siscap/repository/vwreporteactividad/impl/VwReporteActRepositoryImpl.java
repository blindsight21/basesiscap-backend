/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.vwreporteactividad.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.gob.mimp.siscap.model.VwReporteActividad;
import pe.gob.mimp.siscap.repository.vwreporteactividad.CustomVwReporteActRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class VwReporteActRepositoryImpl implements CustomVwReporteActRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<VwReporteActividad> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: VwReporteActividadFacade.findByParams :: Starting execution...");

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
//        logger.info(":: VwReporteActividadFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: VwReporteActividadFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(to.nidActividadGob) " + buildSelectClause();
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
//        logger.info(":: VwReporteActividadFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from VwReporteActividad to ";

        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidActividadGob") != null) {
            whereClause = whereClause + "to.nidActividadGob = :nidActividadGob";
        }
        if (parameters.get("numTrimestre") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.numTrimestre = :numTrimestre";
        }
        if (parameters.get("numAnio") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.numAnio = :numAnio";
        }
        if (parameters.get("nidDepartamento") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.nidDepartamento = :nidDepartamento";
        }
        if (parameters.get("txtEstadoActividadGob") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.txtEstadoActividadGob = :txtEstadoActividadGob";
        }
        if (parameters.get("nidEstadoActividadGob") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.nidEstadoActividadGob = :nidEstadoActividadGob";
        }
        if (parameters.get("txtArea") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.txtArea = :txtArea";
        }
        if (parameters.get("nidArea") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "to.nidArea = :nidArea";
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
            if ("nidActividadGob".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "to.nidActividadGob";
            }
        }
        return orderByClause;
    }
    
    /*@Override
    public List<VwReporteActividad> obtenerPorTrimestreEstado(BigInteger trimestre, BigInteger estado, BigInteger area) {
        CriteriaQuery<VwReporteActividad> cq = getEntityManager().getCriteriaBuilder().createQuery(VwReporteActividad.class);

        Root<VwReporteActividad> registro = cq.from(VwReporteActividad.class);

        cq.distinct(true);

        if (null != trimestre && null == estado && null == area) {

            cq.where(
                    getEntityManager().getCriteriaBuilder().and(
                            getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.numTrimestre), trimestre)
                    ));
        } else if (null != estado && null == trimestre && null == area) {
            cq.where(
                    getEntityManager().getCriteriaBuilder().and(
                            getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.nidEstadoActividadGob), estado)
                    ));
        } else if (null != area && null == trimestre && null == estado) {
            cq.where(
                    getEntityManager().getCriteriaBuilder().and(
                            getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.nidArea), area)
                    ));
        } else if (null != area && null != trimestre && null == estado) {
            cq.where(
                    getEntityManager().getCriteriaBuilder().and(
                            getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.nidArea), area),
                            getEntityManager().getCriteriaBuilder().and(
                                    getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.numTrimestre), trimestre))
                    ));
        } else if (null != area && null == trimestre && null != estado) {
            cq.where(
                    getEntityManager().getCriteriaBuilder().and(
                            getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.nidArea), area),
                            getEntityManager().getCriteriaBuilder().and(
                                    getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.nidEstadoActividadGob), estado))
                    ));
        } else if (null == area && null != trimestre && null != estado) {
            cq.where(
                    getEntityManager().getCriteriaBuilder().and(
                            getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.numTrimestre), trimestre),
                            getEntityManager().getCriteriaBuilder().and(
                                    getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.nidEstadoActividadGob), estado))
                    ));
        } else if (null != trimestre && null != estado && null != area) {
            cq.where(
                    getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.nidArea), area),
                    getEntityManager().getCriteriaBuilder().and(
                            getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.numTrimestre), trimestre),
                            getEntityManager().getCriteriaBuilder().equal(registro.get(VwReporteActividad_.nidEstadoActividadGob), estado)
                    ));
        } else {
            cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(VwReporteActividad_.nidActividadGob)));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
        }

        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(VwReporteActividad_.nidActividadGob)));
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }*/
    
}
