package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.acquisto.SistemaPagamento;

@Repository
public interface SistemaPagamentoRepository extends JpaRepository<SistemaPagamento, Long> {
}
