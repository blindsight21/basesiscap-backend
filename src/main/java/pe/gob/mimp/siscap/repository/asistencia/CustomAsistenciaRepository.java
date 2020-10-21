/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.asistencia;

import java.util.List;
import pe.gob.mimp.siscap.model.Asistencia;

/**
 *
 * @author Omar
 */
public interface CustomAsistenciaRepository {

    List<Asistencia> findAllByField(Object field, Object value);
    
}
