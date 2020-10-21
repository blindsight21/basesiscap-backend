/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.vwactividad;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.siscap.model.VwActividad;

/**
 *
 * @author Omar
 */
public interface CustomVwActividadRepository {

    List<VwActividad> obtenerActividadDepartamento(BigDecimal nidDepartamento);

}
