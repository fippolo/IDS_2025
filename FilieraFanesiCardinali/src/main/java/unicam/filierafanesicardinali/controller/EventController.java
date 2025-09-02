package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.service.EventService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Event")
public class EventController {
    EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody String name, @RequestBody LocalDateTime date, @RequestBody Position position, @RequestBody Long entertainerID) {
        return ResponseEntity.ok(eventService.createEvent(name, date, position, entertainerID));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/creator/{id}")
    public ResponseEntity<List<Event>> getEventsByCreator(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventsByCreator(id));
    }




}
