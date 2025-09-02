package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.utenti.UtenteGenerico;

@Repository
public interface UtenteGenericoRepository extends JpaRepository<UtenteGenerico, Long>{
}
