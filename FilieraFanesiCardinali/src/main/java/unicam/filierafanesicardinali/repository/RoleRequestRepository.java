package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;

public interface RoleRequestRepository extends JpaRepository<RoleRequest, Long> {
    void deleteByUserId(Long userId);
}
