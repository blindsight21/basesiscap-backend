package pe.gob.mimp.siscap.repository.tipoobjetivo;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.TipoObjetivo;

public interface TipoObjetivoRepository extends JpaRepository<TipoObjetivo, BigDecimal>, TipoObjetivoRepositoryCustom {

}
