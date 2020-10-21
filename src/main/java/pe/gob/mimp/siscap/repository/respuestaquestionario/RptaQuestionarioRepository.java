package pe.gob.mimp.siscap.repository.respuestaquestionario;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.RespuestaQuestionario;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface RptaQuestionarioRepository extends JpaRepository<RespuestaQuestionario, BigDecimal>, CustomRptaQuestionarioRepository {

}
