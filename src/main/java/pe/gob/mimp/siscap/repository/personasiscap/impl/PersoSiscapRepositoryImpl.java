/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.personasiscap.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.PersonaSiscap;
import pe.gob.mimp.siscap.repository.personasiscap.CustomPersoSiscapRepository;
import pe.gob.mimp.siscap.util.Constantes;
import pe.gob.mimp.siscap.util.CoreConstant;
import pe.gob.mimp.siscap.util.Funciones;

/**
 *
 * @author Omar
 */
public class PersoSiscapRepositoryImpl implements CustomPersoSiscapRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<PersonaSiscap> findByParams(Map<String, Object> parameters, String orderBy) {
//        logger.info(":: PersonaSiscapFacade.findByParams :: Starting execution...");

        String selectClause = "select ps " + buildSelectClause();
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
//        logger.info(":: PersonaSiscapFacade.findByParams :: Execution finish.");
        return q.getResultList();
    }

    private String buildSelectClause() {
        String selectClause = "from PersonaSiscap ps ";
        return selectClause;
    }

    private String buildWhereClause(Map<String, Object> parameters) {
        String whereClause = "";

        if (parameters.get("nidPersonaSiscap") != null) {
            whereClause = whereClause + "ps.nidPersonaSiscap = :nidPersonaSiscap";
        }
        if (parameters.get("txtDocumento") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ps.txtDocumento = :txtDocumento";
        }
        if (parameters.get("nidUsuario") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ps.nidUsuario = :nidUsuario";
        }
        if (parameters.get("flgActivo") != null) {
            whereClause = (!"".equals(whereClause) ? whereClause + " " + CoreConstant.CONDITION_AND + " " : "");
            whereClause = whereClause + "ps.flgActivo = :flgActivo";
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
            if ("nidPersonaSiscap".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "ps.nidPersonaSiscap";
            }
            if ("txtApellidoPaterno".equals(orderByElement)) {
                orderByClause = (!"".equals(orderByClause) ? orderByClause + " " + CoreConstant.SEPARATOR_COMA + " "
                        : "");
                orderByClause = orderByClause + "ps.txtApellidoPaterno";
            }
        }
        return orderByClause;
    }
    
    @Override
    public List<PersonaSiscap> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<PersonaSiscap> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(PersonaSiscap.class);
        Root<PersonaSiscap> entitie = criteriaQuery.from(PersonaSiscap.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
