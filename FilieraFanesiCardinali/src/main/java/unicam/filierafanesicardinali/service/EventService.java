package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.model.localizzazione.Position;
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
        Event e = new Event(name, date, position, entertainerID);
        eventRepository.save(e);
        userService.addEventToEntertrainer(e.getEntertainerID(), e);
        return e;
    }

    public Event getEvent(Long id){
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }
    public Event deleteEvent(Long eventId) {
        Event event = getEvent(eventId);
        // This will delete the event AND all its invitations due to cascade/orphanRemoval
        userService.removeEventFromEntertrainer(event.getEntertainerID(), event);
        eventRepository.deleteById(eventId); // double check
        return event;
    }
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
    public List<Event> getEventsByCreator(Long id){
        return userService.getEventCreator(id).getEventsList();
    }

    public Event saveEvent(Event event){
        return eventRepository.save(event);
    }
}
