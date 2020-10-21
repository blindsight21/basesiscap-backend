package pe.gob.mimp.siscap.repository.tipomodalidad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.TipoModalidad;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface TipoModalidadRepository extends JpaRepository<TipoModalidad, BigDecimal>, CustomTipoModalidadRepository {

}
