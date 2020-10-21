package pe.gob.mimp.siscap.repository.nivelevaluacion;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.NivelEvaluacion;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface NivelEvalRepository extends JpaRepository<NivelEvaluacion, BigDecimal>, CustomNivelEvalRepository {

}
