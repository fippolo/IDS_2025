package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.amministrazione.Curatore;

public interface CuratoreRepository extends JpaRepository<Curatore, Integer> {
}
