package pe.gob.mimp.siscap.repository.vwreporteactividad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.VwReporteActividad;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface VwReporteActRepository extends JpaRepository<VwReporteActividad, BigDecimal>, CustomVwReporteActRepository {

}
