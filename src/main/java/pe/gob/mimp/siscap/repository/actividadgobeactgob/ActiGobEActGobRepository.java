package pe.gob.mimp.siscap.repository.actividadgobeactgob;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ActividadGobEActGob;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ActiGobEActGobRepository extends JpaRepository<ActividadGobEActGob, BigDecimal>, CustomActiGobEActGobRepository {

}
