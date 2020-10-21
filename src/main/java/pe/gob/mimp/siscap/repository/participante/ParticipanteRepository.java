package pe.gob.mimp.siscap.repository.participante;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Participante;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, BigDecimal>, CustomParticipanteRepository {

}
