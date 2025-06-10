package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.acquisto.Carello;

public interface CarrelloRepository extends JpaRepository<Carello, Long> {
}
