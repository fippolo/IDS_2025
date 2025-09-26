package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.utenti.PlatformAdmin;
import unicam.filierafanesicardinali.model.utenti.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
