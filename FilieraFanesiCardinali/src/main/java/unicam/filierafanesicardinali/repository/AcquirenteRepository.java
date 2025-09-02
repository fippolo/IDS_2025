package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.utenti.Acquirente;

@Repository
public interface AcquirenteRepository extends JpaRepository<Acquirente, Long> {

}
