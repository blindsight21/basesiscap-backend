package pe.gob.mimp.siscap.repository.direcciongobierno;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.DireccionGobierno;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface DireccionGobRepository extends JpaRepository<DireccionGobierno, BigDecimal>, CustomDireccionGobRepository {

}
