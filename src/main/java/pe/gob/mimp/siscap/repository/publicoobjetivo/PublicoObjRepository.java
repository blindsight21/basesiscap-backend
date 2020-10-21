package pe.gob.mimp.siscap.repository.publicoobjetivo;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.PublicoObjetivo;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface PublicoObjRepository extends JpaRepository<PublicoObjetivo, BigDecimal>, CustomPublicoObjRepository {

}
