/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.capacitador;

import java.util.List;
import pe.gob.mimp.siscap.model.ActividadGob;
import pe.gob.mimp.siscap.model.Capacitador;

/**
 *
 * @author Omar
 */
public interface CustomCapacitadorRepository {

    List<Capacitador> obtenerCapacitadorporActividad(ActividadGob actividad);
    
    List<Capacitador> findAllByField(Object field, Object value);
}
