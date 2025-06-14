package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.social.Social;

public interface SocialRepository extends JpaRepository<Social, Integer> {
}
