package unicam.filierafanesicardinali.model.eventi;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.utenti.User;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "invitations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"event_id","invited_user_id"})
)
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invited_user_id", nullable = false)
    private User invitedUser;

    private LocalDateTime expirationDate;

    public Invitation(){}

    public Invitation(Event event, User invitedUser, LocalDateTime expirationDate){
        this.event = event;
        this.invitedUser = invitedUser;
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public User getInvitedUser() {
        return invitedUser;
    }
}
