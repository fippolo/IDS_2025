package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.venditori.Venditore;

import java.nio.channels.FileChannel;
import java.util.List;

@Repository
public interface VenditoreRepository extends JpaRepository<Venditore, Long> {
    FileChannel findByEmail(String email);

    List<Venditore> findByNome(String nome);

    List<Venditore> findByStatoFalse();

    List<Venditore> findByStatoTrue();
}