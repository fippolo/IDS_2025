package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.amministrazione.GestorePiattaforma;

@Repository
public interface GestoreRepository extends JpaRepository<GestorePiattaforma, Long> {
}
