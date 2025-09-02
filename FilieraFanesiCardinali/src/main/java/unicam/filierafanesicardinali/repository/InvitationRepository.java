package unicam.filierafanesicardinali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.filierafanesicardinali.model.eventi.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    boolean existsByEventIdAndInvitedUser_Id(Long eventId, Long invitedUserId);

}
