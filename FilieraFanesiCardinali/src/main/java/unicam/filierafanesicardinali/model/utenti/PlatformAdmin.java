package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PlatformAdmin extends User{
    @OneToMany
    List<RoleRequest> acceptedRequestsList;

    public PlatformAdmin(String nome, String email, String password) {
        super(nome, email, password);
        this.acceptedRequestsList = new ArrayList<>();
    }
    public PlatformAdmin() {
    }

    public List<RoleRequest> getAcceptedRequestsList() {
        return acceptedRequestsList;
    }

    public void addAcceptedRequest(RoleRequest roleRequest){
        acceptedRequestsList.add(roleRequest);
    }

    public void removeRoleRequestFromUserId(Long id){
        acceptedRequestsList.removeIf(roleRequest -> roleRequest.getUser().getId().equals(id));
    }
}
