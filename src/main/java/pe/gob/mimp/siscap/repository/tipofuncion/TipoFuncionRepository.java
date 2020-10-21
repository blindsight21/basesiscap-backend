package pe.gob.mimp.siscap.repository.tipofuncion;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.TipoFuncion;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface TipoFuncionRepository extends JpaRepository<TipoFuncion, BigDecimal>, CustomTipoFuncionRepository {

}
