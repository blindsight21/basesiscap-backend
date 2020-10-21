/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.tipoevaluacion;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.siscap.model.TipoEvaluacion;

/**
 *
 * @author Omar
 */
public interface CustomTipoEvalRepository {

    List<TipoEvaluacion> findByParams(Map<String, Object> parameters, String orderBy);
    
    int getRecordCount(Map<String, Object> parameters);
    
}
