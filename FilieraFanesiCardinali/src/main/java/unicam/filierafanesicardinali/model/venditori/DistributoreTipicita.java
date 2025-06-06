package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;
import unicam.filierafanesicardinali.model.venditori.Venditore;

import java.util.ArrayList;
import java.util.List;

public class DistributoreTipicita extends Venditore {

	private List<Prodotto> pacchetto;
	public DistributoreTipicita(String nome, String email, String password) {
		super(nome, email, password);
		pacchetto = new ArrayList<Prodotto>();
	}

	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param descrizione
	 * @param listaProdotti
	 */
	public ProdottoDistributore creaPacchetto(String nome, float prezzo, String descrizione, Prodotto listaProdotti) {
		return new ProdottoDistributore(nome, prezzo, descrizione, pacchetto);
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void aggiungiProdottoAlPacchetto(Prodotto prodotto) {
		pacchetto.add(prodotto);
	}

	/**
	 * 
	 * @param prodotto
	 */
	public void eliminaProdottoDalPacchetto(Prodotto prodotto) {
		pacchetto.remove(prodotto);
	}

}