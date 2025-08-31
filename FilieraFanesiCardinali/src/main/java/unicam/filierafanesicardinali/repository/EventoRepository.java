package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.eventi.Event;

public interface EventoRepository extends JpaRepository<Event, Long> {
}
