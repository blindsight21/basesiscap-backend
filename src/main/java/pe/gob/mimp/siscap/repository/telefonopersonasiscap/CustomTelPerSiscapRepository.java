/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.telefonopersonasiscap;

import java.util.List;
import pe.gob.mimp.siscap.model.PersonaSiscap;
import pe.gob.mimp.siscap.model.TelefonoPersonaSiscap;

/**
 *
 * @author Omar
 */
public interface CustomTelPerSiscapRepository {

    List<TelefonoPersonaSiscap> obtenerTelefonos(PersonaSiscap personaSiscap);
    
}
