package pe.gob.mimp.siscap.repository.archivoactividad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ArchivoActividad;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ArchivoActividadRepository extends JpaRepository<ArchivoActividad, BigDecimal>, CustomArchivoActividadRepository {

}
