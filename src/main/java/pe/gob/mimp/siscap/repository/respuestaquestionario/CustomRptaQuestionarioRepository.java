/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.repository.respuestaquestionario;

import java.util.List;
import pe.gob.mimp.siscap.model.Questionario;
import pe.gob.mimp.siscap.model.RespuestaQuestionario;

/**
 *
 * @author Omar
 */
public interface CustomRptaQuestionarioRepository {

    List<RespuestaQuestionario> obtenerRespuestas(Questionario questionario);
    
}
