package pe.gob.mimp.siscap.repository.actividadGob;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ActividadGob;

public interface ActiGobRepository extends JpaRepository<ActividadGob, BigDecimal>, CustomActiGobRepository {

}
