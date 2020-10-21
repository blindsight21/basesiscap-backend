package pe.gob.mimp.siscap.repository.vwactividadcalendario;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.VwActividadCalendario;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface VwActividadCalRepository extends JpaRepository<VwActividadCalendario, BigDecimal>, CustomVwActividadCalRepository {

}
