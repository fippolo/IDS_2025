package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;

import java.util.List;

@Entity
public class PlatformAdmin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany
    List<RoleRequest> requestsList;

    public PlatformAdmin(String nome, String email, String password, List<RoleRequest> requestsList) {
        super(nome, email, password);
        this.requestsList = requestsList;
    }
    public PlatformAdmin() {
    }

    public List<RoleRequest> getRequestsList() {
        return requestsList;
    }
}
