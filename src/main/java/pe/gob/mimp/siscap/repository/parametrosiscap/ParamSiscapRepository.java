package pe.gob.mimp.siscap.repository.parametrosiscap;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ParametroSiscap;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ParamSiscapRepository extends JpaRepository<ParametroSiscap, BigDecimal>, CustomParamSiscapRepository {

}
