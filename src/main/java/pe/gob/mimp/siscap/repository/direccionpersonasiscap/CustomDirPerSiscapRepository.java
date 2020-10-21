/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.direccionpersonasiscap;

import java.util.List;
import pe.gob.mimp.siscap.model.DireccionPersonaSiscap;

/**
 *
 * @author Omar
 */
public interface CustomDirPerSiscapRepository {

    List<DireccionPersonaSiscap> findAllByField(Object field, Object value);
    
}
