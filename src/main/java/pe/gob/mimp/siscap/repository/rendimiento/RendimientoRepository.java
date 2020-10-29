package pe.gob.mimp.siscap.repository.rendimiento;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Rendimiento;

public interface RendimientoRepository extends JpaRepository<Rendimiento, BigDecimal>, CustomRendimientoRepository {

}
