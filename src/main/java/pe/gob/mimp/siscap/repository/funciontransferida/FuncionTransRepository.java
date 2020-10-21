package pe.gob.mimp.siscap.repository.funciontransferida;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.FuncionTransferida;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface FuncionTransRepository extends JpaRepository<FuncionTransferida, BigDecimal>, CustomFuncionTransRepository {

}
