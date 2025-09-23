package unicam.filierafanesicardinali.model.ruoli;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.utenti.User;

@Entity
public class RoleRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @Enumerated(EnumType.ORDINAL)
    UserRole role;

    boolean approved;

    public RoleRequest() {
    }

    public RoleRequest(UserRole role, User user) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean getApproved() { return approved; }

    public void setApproved(boolean approved) { this.approved = approved; }

}
