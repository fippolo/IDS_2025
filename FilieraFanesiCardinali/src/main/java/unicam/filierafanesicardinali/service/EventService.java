package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.utenti.Entertainer;
import unicam.filierafanesicardinali.model.utenti.User;
import unicam.filierafanesicardinali.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    EventRepository eventRepository;
    UserService userService;
    @Autowired
    public EventService(EventRepository eventRepository, UserService userService) {
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    public Event createEvent(String name, LocalDateTime date, Position position, Long entertainerID){
        Entertainer entertainer = getEventCreator(entertainerID);
        Event event = new Event(name, date, position, entertainer.getId());
        return eventRepository.save(event);
    }

    public Event getEvent(Long id){
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }
    public Event deleteEvent(Long eventId) {
        Event event = getEvent(eventId);
        // This will delete the event AND all its invitations due to cascade/orphanRemoval
        eventRepository.deleteById(eventId);
        return event;
    }
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
    public List<Event> getEventsByCreator(Long id){
        return getEventCreator(id).getEventsList();
    }

    //helper methods
    private Entertainer getEventCreator(Long id){
        User user = userService.getUser(id);
        if(user instanceof Entertainer){
            return (Entertainer) user;
        } else {
            throw new RuntimeException("User is not an entertainer");
        }
    }
}
