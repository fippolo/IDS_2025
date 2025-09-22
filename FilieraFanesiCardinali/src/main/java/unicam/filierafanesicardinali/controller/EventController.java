package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.controller.DTO.InvitationDto;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.model.eventi.Invitation;
import unicam.filierafanesicardinali.service.EventService;
import unicam.filierafanesicardinali.service.InvitationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Event")
public class EventController {
    private final EventService eventService;
    private final InvitationService invitationService;
    @Autowired
    public EventController(EventService eventService, InvitationService invitationService) {
        this.eventService = eventService;
        this.invitationService = invitationService;
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

    @PostMapping("/{id}/invitation")
    public ResponseEntity<Invitation> inviteEvent(@PathVariable Long id, @RequestBody InvitationDto invitation) {
        return ResponseEntity.ok(invitationService.sendInvitation(id,invitation.userId(), invitation.expiry()));
    }
}
