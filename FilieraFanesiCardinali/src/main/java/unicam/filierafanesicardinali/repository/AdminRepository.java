package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.utenti.PlatformAdmin;

import java.util.List;

public interface AdminRepository extends JpaRepository<PlatformAdmin, Long> {
    List<PlatformAdmin> findByAcceptedRequestsListId(Long userId);
}
