package pe.gob.mimp.siscap.repository.vwparticipanteactividad;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.VwParticipanteActividad;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface VwParticipanteActRepository extends JpaRepository<VwParticipanteActividad, BigDecimal>, CustomVwParticipanteActRepository {

}
