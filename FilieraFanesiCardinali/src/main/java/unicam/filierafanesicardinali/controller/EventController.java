package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.service.EventService;

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
    public ResponseEntity<Event> createEvent(@RequestBody Event e) {
        return ResponseEntity.ok(eventService.createEvent(e.getName(), e.getData(),
                e.getPosition(), e.getEntertainerID()));
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
