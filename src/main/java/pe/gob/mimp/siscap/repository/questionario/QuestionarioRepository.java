package pe.gob.mimp.siscap.repository.questionario;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Questionario;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface QuestionarioRepository extends JpaRepository<Questionario, BigDecimal>, CustomQuestionarioRepository {

}
