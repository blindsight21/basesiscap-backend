/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.gobierno.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.Gobierno;
import pe.gob.mimp.siscap.model.TipoGobierno;
import pe.gob.mimp.siscap.repository.gobierno.CustomGobiernoRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class GobiernoRepositoryImpl implements CustomGobiernoRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Gobierno> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: GobiernoFacade.findByParams :: Starting execution...");

        String selectClause = "select g " + buildSelectClause();
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
//        logger.info(":: GobiernoFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: GobiernoFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(g.nidGobierno) " + buildSelectClause();
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
//        logger.info(":: GobiernoFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from Gobierno g ";
        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidGobierno") != null) {
            whereClause = whereClause + "g.nidGobierno = :nidGobierno";
        }
        if (parameters.get("txtGobierno") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "g.txtGobierno = :txtGobierno";
        }
        if (parameters.get("nidTipoGobierno") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "g.nidTipoGobierno = :nidTipoGobierno";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "g.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "g.flgActivo = :flgActivo";
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
            if ("nidGobierno".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "g.nidGobierno";
            }
            if ("txtGobierno".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "g.txtGobierno";
            }
            /*if ("fechaRegistro".equals(orderByElement)) {
             orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
             : "");
             orderByClause = orderByClause + "g.fechaRegistro desc";
             }*/
        }
        return orderByClause;
    }

    @Override
    public List<Gobierno> obtenerGobierno(TipoGobierno tipoGobierno) {
        CriteriaQuery<Gobierno> cq = getEntityManager().getCriteriaBuilder().createQuery(Gobierno.class);
        Root<Gobierno> registro = cq.from(Gobierno.class);

        cq.distinct(true);
        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get("flgActivo"), BigInteger.ONE),
                        getEntityManager().getCriteriaBuilder().equal(registro.get("nidTipoGobierno"), tipoGobierno)
                ));

        //Distrito_.txtDescripcion
        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get("txtGobierno")));
        javax.persistence.Query q = getEntityManager().createQuery(cq);

        return q.getResultList();
    }

    @Override
    public List<Gobierno> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<Gobierno> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(Gobierno.class);
        Root<Gobierno> entitie = criteriaQuery.from(Gobierno.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    

    /*@Override
     public List<Gobierno> obtenerGobiernoActivos() {
     CriteriaQuery<Gobierno> cq = getEntityManager().getCriteriaBuilder().createQuery(Gobierno.class);

     Root<Gobierno> registro = cq.from(Gobierno.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(Gobierno_.flgActivo), BigInteger.ONE)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(Gobierno_.nidGobierno)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }

     @Override
     public List<Gobierno> obtenerGobiernosporTipo(TipoGobierno tipoGobierno) {
     CriteriaQuery<Gobierno> cq = getEntityManager().getCriteriaBuilder().createQuery(Gobierno.class);
     Root<Gobierno> registro = cq.from(Gobierno.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(Gobierno_.flgActivo), BigInteger.ONE),
     getEntityManager().getCriteriaBuilder().equal(registro.get(Gobierno_.nidTipoGobierno), tipoGobierno)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(Gobierno_.txtGobierno)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
}
