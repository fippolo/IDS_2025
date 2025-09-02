package unicam.filierafanesicardinali.model.venditori;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.prodotti.ProdottoTrasformatore;
@Entity
@DiscriminatorValue("trasformatore")
public class Trasformatore extends Venditore {

	public Trasformatore(String nome, String email, String password) {
		super(nome, email, password);
	}

	public Trasformatore() {

	}

	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param processoDiTrasformazione
	 * @param descrizione
	 */
	public ProdottoTrasformatore creaProdotto(String nome, float prezzo, String processoDiTrasformazione, Indirizzo indirizzo, String descrizione) {
		ProdottoTrasformatore nuovoProdotto = new ProdottoTrasformatore(nome,prezzo,descrizione,this,indirizzo,processoDiTrasformazione);
		return nuovoProdotto;
	}

}