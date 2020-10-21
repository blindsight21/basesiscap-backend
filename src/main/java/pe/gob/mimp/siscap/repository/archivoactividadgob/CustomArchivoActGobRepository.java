/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.archivoactividadgob;

import java.util.List;
import pe.gob.mimp.siscap.model.ArchivoActividadGob;

/**
 *
 * @author Omar
 */
public interface CustomArchivoActGobRepository {

    List<ArchivoActividadGob> findAllByField(Object field, Object value);
    
}
