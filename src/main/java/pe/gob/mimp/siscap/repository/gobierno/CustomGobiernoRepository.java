/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.gobierno;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.siscap.model.Gobierno;
import pe.gob.mimp.siscap.model.TipoGobierno;

/**
 *
 * @author Omar
 */
public interface CustomGobiernoRepository {
    
    List<Gobierno> findByParams(Map<String, Object> parameters, String orderBy);
    
    int getRecordCount(Map<String, Object> parameters);
    
     List<Gobierno> obtenerGobierno(TipoGobierno tipoGobierno);
     
     List<Gobierno> findAllByField(Object field, Object value);

}
