package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoTrasformatore;

public class Trasformatore extends Venditore {

	public Trasformatore(String nome, String email, String password) {
		super(nome, email, password);
	}

	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param processoDiTrasformazione
	 * @param descrizione
	 */
	public ProdottoTrasformatore creaProdotto(String nome, float prezzo, String processoDiTrasformazione, String descrizione) {
		ProdottoTrasformatore nuovoProdotto = new ProdottoTrasformatore(nome,prezzo,descrizione,processoDiTrasformazione);
		return nuovoProdotto;
	}

}