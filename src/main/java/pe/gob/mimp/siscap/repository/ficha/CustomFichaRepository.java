/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.ficha;

import java.util.List;
import pe.gob.mimp.siscap.model.Ficha;

/**
 *
 * @author Omar
 */
public interface CustomFichaRepository {

    List<Ficha> findAllByField(Object field, Object value);
    
}
