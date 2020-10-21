/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.telefonogobierno.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.gob.mimp.siscap.repository.telefonogobierno.CustomTelefonoGobRepository;
import pe.gob.mimp.siscap.util.Constantes;

/**
 *
 * @author Omar
 */
public class TelefonoGobRepositoryImpl implements CustomTelefonoGobRepository {

    @PersistenceContext(unitName = Constantes.NOMBRE_ENTITY_MANAGER)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
