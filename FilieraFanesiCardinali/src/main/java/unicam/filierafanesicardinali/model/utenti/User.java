package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.eventi.Invitation;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String password;

	@OneToMany(mappedBy = "invitedUser")
	private List<Invitation> invites;

	User(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.invites = new java.util.ArrayList<Invitation>();
	}

	public User() {	}

	public Long getId() {
		return id;
	}
}