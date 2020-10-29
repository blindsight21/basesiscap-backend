package pe.gob.mimp.siscap.repository.disponibilidad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Disponibilidad;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, BigDecimal>, CustomDisponibilidadRepository {

}
