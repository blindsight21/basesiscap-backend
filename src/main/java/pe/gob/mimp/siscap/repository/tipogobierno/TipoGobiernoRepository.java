package pe.gob.mimp.siscap.repository.tipogobierno;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.TipoGobierno;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface TipoGobiernoRepository extends JpaRepository<TipoGobierno, BigDecimal>, CustomTipoGobiernoRepository {

}
