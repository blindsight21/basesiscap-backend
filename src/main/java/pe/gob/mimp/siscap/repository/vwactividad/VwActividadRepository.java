package pe.gob.mimp.siscap.repository.vwactividad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.VwActividad;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface VwActividadRepository extends JpaRepository<VwActividad, BigDecimal>, CustomVwActividadRepository {

}
