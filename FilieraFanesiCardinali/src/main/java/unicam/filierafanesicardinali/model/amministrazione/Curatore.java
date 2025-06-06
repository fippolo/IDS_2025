package unicam.filierafanesicardinali.model.amministrazione;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.amministrazione.Piattaforma;

public class Curatore {

	private String nome;
	private String email;
	private String password;
	private Prodotto prodotto;
	private Piattaforma piattaforma;

	public Curatore(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	/**
	 * 
	 * @param prodotto
	 */
	private void approvaProdotto(Prodotto prodotto) {
		// TODO - implement Curatore.approvaProdotto
		if(piattaforma.showProdotti().contains(prodotto)){
			for(Prodotto p : piattaforma.showProdotti())
			{
				if(p.equals(prodotto)){
					p.setStato(true);
				}
			}
		}
		throw new UnsupportedOperationException();
	}

}