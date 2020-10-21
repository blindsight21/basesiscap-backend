/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.profesional.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.siscap.repository.profesional.CustomProfesionalRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class ProfesionalRepositoryImpl implements CustomProfesionalRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
