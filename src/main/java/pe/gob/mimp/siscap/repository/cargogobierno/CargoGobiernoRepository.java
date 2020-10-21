package pe.gob.mimp.siscap.repository.cargogobierno;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.CargoGobierno;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface CargoGobiernoRepository extends JpaRepository<CargoGobierno, BigDecimal>, CustomCargoGobiernoRepository {

}
