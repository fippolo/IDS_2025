package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Product, Long> {

    List<Product> findByStatoTrue(); //restituisce i prodotti verificati

    List<Product> findByStatoFalse(); //restituisce i prodotti non verificati

    List<Product> findByVenditoreId(Long venditoreId);//restituisce i prodotti verificati di un venditore

}
