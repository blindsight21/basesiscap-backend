package pe.gob.mimp.siscap.repository.estadoactividadgob;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.EstadoActividadGob;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface EstadoActGobRepository extends JpaRepository<EstadoActividadGob, BigDecimal>, CustomEstadoActGobRepository {

}
