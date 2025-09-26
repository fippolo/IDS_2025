package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;

import java.util.List;

public interface RoleRequestRepository extends JpaRepository<RoleRequest, Long> {
    List<RoleRequest> findByUserId(Long userId);
}
