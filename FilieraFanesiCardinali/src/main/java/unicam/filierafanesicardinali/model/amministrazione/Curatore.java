package unicam.filierafanesicardinali.model.amministrazione;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;

public class Curatore {

	private String nome;
	private String email;
	private String password;
	private Prodotto listaProdotti;

	public Curatore(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	/**
	 * 
	 * @param listaProdotti
	 */
	private void approvaProdotto(Prodotto listaProdotti) {
		// TODO - implement Curatore.approvaProdotto
		throw new UnsupportedOperationException();
	}

}