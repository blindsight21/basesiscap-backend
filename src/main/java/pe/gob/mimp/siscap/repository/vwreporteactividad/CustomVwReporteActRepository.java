/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.vwreporteactividad;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.siscap.model.VwReporteActividad;

/**
 *
 * @author Omar
 */
public interface CustomVwReporteActRepository {

    List<VwReporteActividad> findByParams(Map<String, Object> parameters, String orderBy);
    
    int getRecordCount(Map<String, Object> parameters);
    
}
