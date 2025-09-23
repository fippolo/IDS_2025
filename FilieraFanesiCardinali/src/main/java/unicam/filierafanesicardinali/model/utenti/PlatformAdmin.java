package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PlatformAdmin extends User{
    @OneToMany
    List<RoleRequest> AcceptedRequestsList;

    public PlatformAdmin(String nome, String email, String password) {
        super(nome, email, password);
        this.AcceptedRequestsList = new ArrayList<>();
    }
    public PlatformAdmin() {
    }

    public List<RoleRequest> getAcceptedRequestsList() {
        return AcceptedRequestsList;
    }

    public void addAcceptedRequest(RoleRequest roleRequest){
        AcceptedRequestsList.add(roleRequest);
    }
}
