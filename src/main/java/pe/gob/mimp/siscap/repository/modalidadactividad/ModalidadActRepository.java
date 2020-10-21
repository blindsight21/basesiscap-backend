package pe.gob.mimp.siscap.repository.modalidadactividad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ModalidadActividad;

public interface ModalidadActRepository extends JpaRepository<ModalidadActividad, BigDecimal>, CustomModalidadActRepository {

}
