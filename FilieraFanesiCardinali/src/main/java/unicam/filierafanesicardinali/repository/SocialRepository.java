package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.social.Social;

@Repository
public interface SocialRepository extends JpaRepository<Social, Integer> {
}
