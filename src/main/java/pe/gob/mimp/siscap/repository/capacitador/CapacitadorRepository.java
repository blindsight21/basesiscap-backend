package pe.gob.mimp.siscap.repository.capacitador;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Capacitador;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface CapacitadorRepository extends JpaRepository<Capacitador, BigDecimal>, CustomCapacitadorRepository {

}
