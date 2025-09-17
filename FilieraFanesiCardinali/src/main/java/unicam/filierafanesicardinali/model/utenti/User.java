package unicam.filierafanesicardinali.model.utenti;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.eventi.Invitation;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;


@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String password;

	@OneToMany(mappedBy = "invitedUser", cascade = CascadeType.ALL, orphanRemoval = true)
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

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Invitation> getInvites() {
		return invites;
	}

	public void setInvites(List<Invitation> invites) {
		this.invites = invites;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addInvite(Invitation inv){
		this.invites.add(inv);
	}
}