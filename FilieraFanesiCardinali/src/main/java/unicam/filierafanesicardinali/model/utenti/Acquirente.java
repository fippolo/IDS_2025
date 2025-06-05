package unicam.filierafanesicardinali.model.utenti;

import unicam.filierafanesicardinali.model.acquisto.Carello;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

public class Acquirente {

	private String nome;
	private Carello carello;


	public Acquirente(String nome) {
		this.nome = nome;
		carello = new Carello();
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