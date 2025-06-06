package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.prodotti.ProdottoProduttore;


public class Produttore extends Venditore {

	public Produttore(String nome, String email, String password) {
		super(nome, email, password);
	}

	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param metodoDiColtivazione
	 * @param descrizione
	 */
	public ProdottoProduttore creaProdotto(String nome, float prezzo, String metodoDiColtivazione, String descrizione) {
		return new ProdottoProduttore(nome, prezzo ,metodoDiColtivazione,descrizione);
	}

}