package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.acquisto.Carrello;
import unicam.filierafanesicardinali.repository.CarrelloRepository;

@Entity
public class Acquirente {

	private String nome;


    @Id
    private Long id;

	@OneToOne
	private Carrello carrello;



	public Carrello getCarrello() {
		return carrello;
	}

	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}


	public Acquirente(String nome) {
		this.nome = nome;
        carrello = new Carrello();


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