package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.eventi.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
