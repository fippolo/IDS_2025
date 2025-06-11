package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.acquisto.Carello;

@Repository
public interface CarrelloRepository extends JpaRepository<Carello, Long> {
}
