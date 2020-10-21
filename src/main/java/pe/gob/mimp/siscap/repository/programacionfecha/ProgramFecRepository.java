package pe.gob.mimp.siscap.repository.programacionfecha;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ProgramacionFecha;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ProgramFecRepository extends JpaRepository<ProgramacionFecha, BigDecimal>, CustomProgramFecRepository {

}
