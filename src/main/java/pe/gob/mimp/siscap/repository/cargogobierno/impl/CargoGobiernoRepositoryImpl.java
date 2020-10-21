/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.cargogobierno.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import pe.gob.mimp.siscap.model.CargoGobierno;
import pe.gob.mimp.siscap.repository.cargogobierno.CustomCargoGobiernoRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class CargoGobiernoRepositoryImpl implements CustomCargoGobiernoRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<CargoGobierno> findAllByField(Object field, Object value) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<CargoGobierno> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(CargoGobierno.class);
        Root<CargoGobierno> entitie = criteriaQuery.from(CargoGobierno.class);

        criteriaQuery.select(entitie).where(criteriaBuilder.equal(entitie.get(field.toString()), value));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
}
