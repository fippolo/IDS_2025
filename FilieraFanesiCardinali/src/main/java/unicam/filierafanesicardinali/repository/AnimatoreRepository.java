package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.eventi.Animatore;

import java.util.List;

public interface AnimatoreRepository extends JpaRepository<Animatore, Long> {
    List<Animatore> id(Long id);
}
