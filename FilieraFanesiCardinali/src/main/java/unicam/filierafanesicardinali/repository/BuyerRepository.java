package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.utenti.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
