package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.utenti.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
