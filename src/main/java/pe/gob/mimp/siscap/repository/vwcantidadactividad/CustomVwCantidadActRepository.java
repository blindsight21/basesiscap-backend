/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.vwcantidadactividad;

import java.util.List;
import pe.gob.mimp.siscap.model.VwCantidadActividad;

/**
 *
 * @author Omar
 */
public interface CustomVwCantidadActRepository {

    List<VwCantidadActividad> obtenerCantidadActividad(String nombre);

    List<VwCantidadActividad> findAllByField(Object field, Object value);

}
