package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.acquisto.orders.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
