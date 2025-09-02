package unicam.filierafanesicardinali.model.eventi;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;

import java.util.List;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private java.time.LocalDateTime data;

	@Embedded
	private Position position;

	@OneToMany
	private List<Invitation> invitationList;

	public Event(String name, java.time.LocalDateTime data, Position position) {
		this.name = name;
		this.data = data;
		this.position = position;
	}
	public Event() {}
}