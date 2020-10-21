/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.parametrosiscap;

import java.util.List;
import pe.gob.mimp.siscap.model.ParametroSiscap;

/**
 *
 * @author Omar
 */
public interface CustomParamSiscapRepository {

    List<ParametroSiscap> findAllByField(Object field, Object value);
    
}
