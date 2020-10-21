package pe.gob.mimp.siscap.repository.direccionpersonasiscap;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.DireccionPersonaSiscap;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface DirPerSiscapRepository extends JpaRepository<DireccionPersonaSiscap, BigDecimal>, CustomDirPerSiscapRepository {

}
