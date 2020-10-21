package pe.gob.mimp.siscap.repository.actividadgobresultado;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ActividadGobResultado;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ActiGobResultadoRepository extends JpaRepository<ActividadGobResultado, BigDecimal>, CustomActiGobResultadoRepository {

}
