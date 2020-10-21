/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.funciontransferida.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.FuncionTransferida;
import pe.gob.mimp.siscap.repository.funciontransferida.CustomFuncionTransRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class FuncionTransRepositoryImpl implements CustomFuncionTransRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<FuncionTransferida> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: FuncionTransferidaFacade.findByParams :: Starting execution...");

        String selectClause = "select f " + buildSelectClause();
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
//        logger.info(
//                ":: FuncionTransferidaFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    @Override
    public int getRecordCount(Map<String, Object> parameters) {
//        logger.info(":: EstadoFacade.getRecordCount :: Starting execution...");
        String selectClause = "select count(f.nidFuncionTransferida) " + buildSelectClause();
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
//        logger.info(":: EstadoFacade.getRecordCount :: Execution finish.");
        return ((Long) q.getSingleResult()).intValue();
    }

    private String buildSelectClause() {
        String selectClause = "from FuncionTransferida f ";
        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidFuncionTransferida") != null) {
            whereClause = whereClause + "f.nidFuncionTransferida = :nidFuncionTransferida";
        }
        if (parameters.get("txtFuncionTransferida") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "f.txtFuncionTransferida = :txtFuncionTransferida";
        }
        if (parameters.get("nidTipoFuncion") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "f.nidTipoFuncion = :nidTipoFuncion";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "f.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "f.flgActivo = :flgActivo";
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
            if ("nidFuncionTransferida".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "f.nidFuncionTransferida";
            }
            if ("txtFuncionTransferida".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "f.txtFuncionTransferida";
            }
            /*if ("fechaRegistro".equals(orderByElement)) {
             orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
             : "");
             orderByClause = orderByClause + "f.fechaRegistro desc";
             }*/
        }
        return orderByClause;
    }

    @Override
    public List<FuncionTransferida> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<FuncionTransferida> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(FuncionTransferida.class);
        Root<FuncionTransferida> entitie = criteriaQuery.from(FuncionTransferida.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    /*@Override
     public List<FuncionTransferida> obtenerFuncionTransferida(TipoFuncion tipoFuncion) {
     CriteriaQuery<FuncionTransferida> cq = getEntityManager().getCriteriaBuilder().createQuery(FuncionTransferida.class);
     Root<FuncionTransferida> registro = cq.from(FuncionTransferida.class);

     cq.distinct(true);
     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get("flgActivo"), BigInteger.ONE),
     getEntityManager().getCriteriaBuilder().equal(registro.get("nidTipoFuncion"), tipoFuncion)
     ));

     //Distrito_.txtDescripcion
     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get("txtFuncionTransferida")));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }
    

     @Override
     public List<FuncionTransferida> obtenerFuncionTransferidaTodos() {
     CriteriaQuery<FuncionTransferida> cq = getEntityManager().getCriteriaBuilder().createQuery(FuncionTransferida.class);

     Root<FuncionTransferida> registro = cq.from(FuncionTransferida.class);

     cq.distinct(true);

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(FuncionTransferida_.nidFuncionTransferida)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }

     @Override
     public List<FuncionTransferida> obtenerFuncionTransferidaActivos() {
     CriteriaQuery<FuncionTransferida> cq = getEntityManager().getCriteriaBuilder().createQuery(FuncionTransferida.class);

     Root<FuncionTransferida> registro = cq.from(FuncionTransferida.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(FuncionTransferida_.flgActivo), BigInteger.ONE)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().asc(registro.get(FuncionTransferida_.nidFuncionTransferida)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }

     @Override
     public List<FuncionTransferida> obtenerFuncionTransferidaporTipo(TipoFuncion tipoFuncion) {
     CriteriaQuery<FuncionTransferida> cq = getEntityManager().getCriteriaBuilder().createQuery(FuncionTransferida.class);
     Root<FuncionTransferida> registro = cq.from(FuncionTransferida.class);

     cq.distinct(true);

     cq.where(
     getEntityManager().getCriteriaBuilder().and(
     getEntityManager().getCriteriaBuilder().equal(registro.get(FuncionTransferida_.flgActivo), BigInteger.ONE),
     getEntityManager().getCriteriaBuilder().equal(registro.get(FuncionTransferida_.nidTipoFuncion), tipoFuncion)
     ));

     cq.orderBy(getEntityManager().getCriteriaBuilder().desc(registro.get(FuncionTransferida_.nidFuncionTransferida)));
     javax.persistence.Query q = getEntityManager().createQuery(cq);

     return q.getResultList();
     }*/
}
