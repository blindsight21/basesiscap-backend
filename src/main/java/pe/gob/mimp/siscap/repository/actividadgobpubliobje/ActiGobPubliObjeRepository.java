package pe.gob.mimp.siscap.repository.actividadgobpubliobje;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.ActividadGobPubliObje;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ActiGobPubliObjeRepository extends JpaRepository<ActividadGobPubliObje, BigDecimal>, CustomActiGobPubliObjeRepository {

}
