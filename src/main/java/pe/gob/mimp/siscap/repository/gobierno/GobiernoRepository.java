package pe.gob.mimp.siscap.repository.gobierno;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Gobierno;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface GobiernoRepository extends JpaRepository<Gobierno, BigDecimal>, CustomGobiernoRepository {

}
