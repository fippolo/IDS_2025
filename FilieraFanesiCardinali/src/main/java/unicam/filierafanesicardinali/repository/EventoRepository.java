package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.eventi.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
