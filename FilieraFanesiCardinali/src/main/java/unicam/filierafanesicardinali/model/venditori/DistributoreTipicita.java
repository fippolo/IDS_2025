package unicam.filierafanesicardinali.model.venditori;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;
import unicam.filierafanesicardinali.model.venditori.Venditore;

import java.util.ArrayList;
import java.util.List;
@Entity
@DiscriminatorValue("distributore")
public class DistributoreTipicita extends Venditore {

	@OneToMany(cascade = CascadeType.ALL)
	private List<Prodotto> pacchetto;
	public DistributoreTipicita(String nome, String email, String password) {
		super(nome, email, password);
		pacchetto = new ArrayList<Prodotto>();
	}

	public DistributoreTipicita() {

	}

	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param descrizione
	 * @param listaProdotti
	 */
	public ProdottoDistributore creaPacchetto(String nome, float prezzo, String descrizione, List<Prodotto> listaProdotti) {
		return new ProdottoDistributore(nome, prezzo, descrizione, this, pacchetto);
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

	public List<Prodotto> getPacchetto() {
		return pacchetto;
	}

	public void setPacchetto(List<Prodotto> pacchetto) {
		this.pacchetto = pacchetto;
	}
}