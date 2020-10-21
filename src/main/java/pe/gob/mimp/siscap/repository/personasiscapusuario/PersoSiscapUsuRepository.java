package pe.gob.mimp.siscap.repository.personasiscapusuario;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.PersonaSiscapUsuario;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface PersoSiscapUsuRepository extends JpaRepository<PersonaSiscapUsuario, BigDecimal>, CustomPersoSiscapUsuRepository {

}
