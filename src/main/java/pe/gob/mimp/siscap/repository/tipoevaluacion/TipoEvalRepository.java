package pe.gob.mimp.siscap.repository.tipoevaluacion;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.TipoEvaluacion;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface TipoEvalRepository extends JpaRepository<TipoEvaluacion, BigDecimal>, CustomTipoEvalRepository {

}
