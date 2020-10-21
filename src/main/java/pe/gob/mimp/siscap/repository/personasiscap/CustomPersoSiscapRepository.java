/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.personasiscap;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.siscap.model.PersonaSiscap;

/**
 *
 * @author Omar
 */
public interface CustomPersoSiscapRepository {

    List<PersonaSiscap> findByParams(Map<String, Object> parameters, String orderBy);
    
    List<PersonaSiscap> findAllByField(Object field, Object value);
    
}
