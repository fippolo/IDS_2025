package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.social.SocialPost;

@Repository
public interface SocialPostRepository extends JpaRepository<SocialPost, Long> {
}
