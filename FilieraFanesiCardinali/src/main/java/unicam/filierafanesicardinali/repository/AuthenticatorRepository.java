package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unicam.filierafanesicardinali.model.utenti.Authenticator;

import java.util.List;

public interface AuthenticatorRepository extends JpaRepository<Authenticator,Long> {
    @Query("select a from Authenticator a join a.authenticatedProducts p where p.id = :productId")
    List<Authenticator> findAllByProductId(@Param("productId") Long productId);
}
