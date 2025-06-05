package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;

public class Venditore {

	private String nome;
	private Prodotto listaProdotti;
	private String email;
	private String password;

	public Venditore(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param stato
	 * @param descrizione
	 */
	public Prodotto creaProdotto(String nome, float prezzo, boolean stato, String descrizione) {
		return new Prodotto(nome, prezzo, stato, descrizione);
	}

}