package pe.gob.mimp.siscap.repository.telefonopersonasiscap;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.TelefonoPersonaSiscap;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface TelPerSiscapRepository extends JpaRepository<TelefonoPersonaSiscap, BigDecimal>, CustomTelPerSiscapRepository {

}
