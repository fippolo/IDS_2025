package unicam.filierafanesicardinali.model.eventi;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.utenti.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long entertainerID;

	private String name;
	private java.time.LocalDateTime data;

	@Embedded
	private Position position;

	@OneToMany(
			mappedBy = "event",
			cascade = CascadeType.ALL,        // create/update/remove children with the parent
			orphanRemoval = true              // remove when dropped from the collection
	)
	private List<Invitation> invitationList = new ArrayList<>();

	public Event(String name, java.time.LocalDateTime data, Position position, Long entertainerID) {
		this.name = name;
		this.data = data;
		this.position = position;
		this.entertainerID = entertainerID;
	}
	public Event() {}

	public Invitation addInvitation (User invitedUser, LocalDateTime expiry){
	Invitation inv = new Invitation(this, invitedUser, expiry);
	invitationList.add(inv);
	return inv;
	}
	public void removeInvitation(Invitation inv) {
		invitationList.remove(inv);
		inv.setEvent(null);
	}

	public Long getId() {
		return id;
	}

	public List<Invitation> getInvitationList() {
		return invitationList;
	}

	public Position getPosition() {
		return position;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getName() {
		return name;
	}

	public Long getEntertainerID() {
		return entertainerID;
	}
}