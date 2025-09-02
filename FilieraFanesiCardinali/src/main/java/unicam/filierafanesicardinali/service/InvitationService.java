package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.model.eventi.Invitation;
import unicam.filierafanesicardinali.model.utenti.User;
import unicam.filierafanesicardinali.repository.EventRepository;
import unicam.filierafanesicardinali.repository.InvitationRepository;
import unicam.filierafanesicardinali.repository.UserRepository;

import java.time.LocalDateTime;

//TODO: refactor
@Service
public class InvitationService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final InvitationRepository invitationRepository;

    @Autowired
    public InvitationService(EventRepository eventRepository, UserRepository userRepository,
                             InvitationRepository invitationRepository){
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.invitationRepository = invitationRepository;
    }


    @Transactional
    public Invitation sendInvitation(Long EventId, Long UserId, LocalDateTime expiry){
        if (invitationRepository.existsByEventIdAndInvitedUser_Id(EventId, UserId)) {
            throw new IllegalStateException("User already invited to this event.");
        }
        Event event = eventRepository.getReferenceById(EventId);
        User user = userRepository.getReferenceById(UserId);
        Invitation inv = event.addInvitation(user, expiry);
        // Because of CascadeType.ALL on Event->Invitation, saving the event is enough:
        eventRepository.save(event);
        return inv;
    }

}
