package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Acquirente {

	private String nome;


    @Id
    private Long id;




	public Acquirente(String nome) {
		this.nome = nome;
	}

	public Acquirente() {

	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}




}