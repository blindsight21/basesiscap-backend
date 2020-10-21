package pe.gob.mimp.siscap.repository.asistencia;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Asistencia;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface AsistenciaRepository extends JpaRepository<Asistencia, BigDecimal>, CustomAsistenciaRepository {

}
