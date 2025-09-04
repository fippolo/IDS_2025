package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import unicam.filierafanesicardinali.model.eventi.Event;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Entertainer extends User{
    @OneToMany
    private List<Event> eventsList;

    public Entertainer(String nome, String email, String password) {
        super(nome, email, password);
        this.eventsList = new ArrayList<Event>();
    }

    public Entertainer(){}

    public List<Event> getEventsList() {
        return eventsList;
    }
    public void setEventsList(List<Event> eventsList) {
        this.eventsList = eventsList;
    }
}

