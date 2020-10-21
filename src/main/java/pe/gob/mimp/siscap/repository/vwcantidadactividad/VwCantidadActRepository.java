package pe.gob.mimp.siscap.repository.vwcantidadactividad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.VwCantidadActividad;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface VwCantidadActRepository extends JpaRepository<VwCantidadActividad, BigDecimal>, CustomVwCantidadActRepository {

}
