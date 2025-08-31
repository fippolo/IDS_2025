package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.Entity;

@Entity
public class GenericUser extends User{
    public GenericUser(String nome, String email, String password) {
        super(nome, email, password);
    }
    public GenericUser(){}
}
