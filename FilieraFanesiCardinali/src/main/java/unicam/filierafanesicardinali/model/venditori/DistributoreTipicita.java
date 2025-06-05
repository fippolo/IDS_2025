package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;
import unicam.filierafanesicardinali.model.venditori.Venditore;

public class DistributoreTipicita extends Venditore {


	public DistributoreTipicita(String nome, String email, String password) {
		super(nome, email, password);
	}

	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param stato
	 * @param descrizione
	 * @param listaProdotti
	 */
	public ProdottoDistributore creaPacchetto(String nome, float prezzo, boolean stato, String descrizione, Prodotto listaProdotti) {
		// TODO - implement DistributoreTipicita.creaPacchetto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void aggiungiProdottoAlPacchetto(Prodotto prodotto) {
		// TODO - implement DistributoreTipicita.aggiungiProdottoAlPacchetto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void eliminaProdottoDalPacchetto(Prodotto prodotto) {
		// TODO - implement DistributoreTipicita.eliminaProdottoDalPacchetto
		throw new UnsupportedOperationException();
	}

}