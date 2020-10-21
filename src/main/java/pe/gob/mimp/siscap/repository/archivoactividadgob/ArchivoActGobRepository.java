package pe.gob.mimp.siscap.repository.archivoactividadgob;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ArchivoActividadGob;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ArchivoActGobRepository extends JpaRepository<ArchivoActividadGob, BigDecimal>, CustomArchivoActGobRepository {

}
