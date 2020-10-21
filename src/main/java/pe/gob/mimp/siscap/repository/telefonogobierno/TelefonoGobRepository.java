package pe.gob.mimp.siscap.repository.telefonogobierno;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.TelefonoGobierno;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface TelefonoGobRepository extends JpaRepository<TelefonoGobierno, BigDecimal>, CustomTelefonoGobRepository {

}
