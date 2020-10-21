/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.archivoactividad;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.siscap.model.ArchivoActividad;

/**
 *
 * @author Omar
 */
public interface CustomArchivoActividadRepository {

   List<ArchivoActividad> findByParams(Map<String, Object> parameters, String orderBy) ;
   
   int getRecordCount(Map<String, Object> parameters);
   
   List<ArchivoActividad> findAllByField(Object field, Object value);
}
