/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.correopersonasiscap;

import java.util.List;
import pe.gob.mimp.siscap.model.CorreoPersonaSiscap;
import pe.gob.mimp.siscap.model.PersonaSiscap;

/**
 *
 * @author Omar
 */
public interface CustomCorrPerSiscapRepository {

    List<CorreoPersonaSiscap> obtenerCorreos(PersonaSiscap personaSiscap);
    
    List<CorreoPersonaSiscap> findAllByField(Object field, Object value);
}
