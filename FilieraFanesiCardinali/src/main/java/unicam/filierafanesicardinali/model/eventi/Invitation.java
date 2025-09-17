package unicam.filierafanesicardinali.model.eventi;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.utenti.User;

import java.time.LocalDateTime;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(
        name = "invitations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"event_id","invited_user_id"})
)
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne( optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne( optional = false)
    @JoinColumn(name = "invited_user_id", nullable = false)
    private User invitedUser;

    private LocalDateTime expirationDate;

    public Invitation(){}

    public Invitation(Event event, User invitedUser, LocalDateTime expirationDate){
        this.event = event;
        this.invitedUser = invitedUser;
        this.expirationDate = expirationDate;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public Event getEvent() {
        return event;
    }

    public User getInvitedUser() {
        return invitedUser;
    }
}
