package pe.gob.mimp.siscap.repository.ficha;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Ficha;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface FichaRepository extends JpaRepository<Ficha, BigDecimal>, CustomFichaRepository {

}
