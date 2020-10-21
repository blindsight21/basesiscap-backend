package pe.gob.mimp.siscap.repository.profesional;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Profesional;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ProfesionalRepository extends JpaRepository<Profesional, BigDecimal>, CustomProfesionalRepository {

}
