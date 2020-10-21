/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.actividadgobresultado;

import java.util.List;
import java.util.Map;
import pe.gob.mimp.siscap.model.ActividadGobResultado;

/**
 *
 * @author Omar
 */
public interface CustomActiGobResultadoRepository {

   List<ActividadGobResultado> findByParams(Map<String, Object> parameters, String orderBy) ;
   
   int getRecordCount(Map<String, Object> parameters);
   
   List<ActividadGobResultado> findAllByField(Object field, Object value);
}
