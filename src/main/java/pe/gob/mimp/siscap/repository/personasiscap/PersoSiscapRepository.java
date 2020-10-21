package pe.gob.mimp.siscap.repository.personasiscap;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.PersonaSiscap;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface PersoSiscapRepository extends JpaRepository<PersonaSiscap, BigDecimal>, CustomPersoSiscapRepository {

}
