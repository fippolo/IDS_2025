package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
}
