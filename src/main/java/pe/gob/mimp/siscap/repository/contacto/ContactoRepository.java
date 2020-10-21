package pe.gob.mimp.siscap.repository.contacto;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.mimp.siscap.model.Contacto;
import pe.gob.mimp.siscap.repository.ExtendedRepository;

public interface ContactoRepository extends JpaRepository<Contacto, BigDecimal>, CustomContactoRepository {

}
