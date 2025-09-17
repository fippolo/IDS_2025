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
    private final EventService eventService;
    private final UserService userService;
    private final InvitationRepository invitationRepository;

    @Autowired
    public InvitationService(EventService eventService, UserService userService,
                             InvitationRepository invitationRepository){
        this.eventService = eventService;
        this.userService = userService;
        this.invitationRepository = invitationRepository;
    }



    public Invitation sendInvitation(Long EventId, Long UserId, LocalDateTime expiry){
        if (invitationRepository.existsByEventIdAndInvitedUser_Id(EventId, UserId)) {
            throw new IllegalStateException("User already invited to this event.");
        }
        Event event = eventService.getEvent(EventId);
        User user = userService.getUser(UserId);
        Invitation inv = event.addInvitation(user, expiry);
        // Because of CascadeType.ALL on Event->Invitation, saving the event is enough:
        return eventService.saveEvent(event).getInvitationList().get(event.getInvitationList().size() - 1);
    }

}
