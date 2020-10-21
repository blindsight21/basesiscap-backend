/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.contacto;

import java.util.List;
import pe.gob.mimp.siscap.model.Contacto;

/**
 *
 * @author Omar
 */
public interface CustomContactoRepository {

    List<Contacto> findAllByField(Object field, Object value);
    
}
