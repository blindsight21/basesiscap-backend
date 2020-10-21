package pe.gob.mimp.siscap.repository.actividadgobpubliproc;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ActividadGobPubliProc;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ActiGobPubliProcRepository extends JpaRepository<ActividadGobPubliProc, BigDecimal>, CustomActiGobPubliProcRepository {

}
