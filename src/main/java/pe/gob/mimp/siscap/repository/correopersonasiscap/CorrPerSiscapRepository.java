package pe.gob.mimp.siscap.repository.correopersonasiscap;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.CorreoPersonaSiscap;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface CorrPerSiscapRepository extends JpaRepository<CorreoPersonaSiscap, BigDecimal>, CustomCorrPerSiscapRepository {

}
