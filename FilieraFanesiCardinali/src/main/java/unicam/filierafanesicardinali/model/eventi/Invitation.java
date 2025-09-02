package unicam.filierafanesicardinali.model.eventi;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.utenti.User;

import java.time.LocalDateTime;

@Entity
public class Invitation {
    private LocalDateTime expirationDate;

    @ManyToOne
    private User invitedUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Invitation(){}

    public Invitation(User invitedUser, LocalDateTime expirationDate){
        this.invitedUser = invitedUser;
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
