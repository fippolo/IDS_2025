package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.utenti.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
