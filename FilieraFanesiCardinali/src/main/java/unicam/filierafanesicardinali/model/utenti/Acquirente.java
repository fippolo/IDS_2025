package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import unicam.filierafanesicardinali.model.acquisto.Carello;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

@Entity
public class Acquirente {

	private String nome;

	@ManyToOne
	@JoinColumn(name = "carello_id")
	private Carello carello;
    @Id
    private Long id;

	public Carello getCarello() {
		return carello;
	}

	public void setCarello(Carello carello) {
		this.carello = carello;
	}


	public Acquirente(String nome) {
		this.nome = nome;
		carello = new Carello();
	}

	public Acquirente() {

	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void aggiungiProdotto(Prodotto prodotto) {
		carello.aggiungiProdotto(prodotto);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void eliminaProdotto(Prodotto prodotto) {
		carello.rimuoviProdotto(prodotto);
	}

	public void svuotaCarrello() {
		carello.svuotaCarello();
	}


}