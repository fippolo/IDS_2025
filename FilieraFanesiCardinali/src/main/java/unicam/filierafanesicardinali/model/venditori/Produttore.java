package unicam.filierafanesicardinali.model.venditori;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.prodotti.ProdottoProduttore;

@Entity
@DiscriminatorValue("produttore")
public class Produttore extends Venditore {

	public Produttore(String nome, String email, String password) {
		super(nome, email, password);
	}

	public Produttore() {

	}

	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param metodoDiColtivazione
	 * @param descrizione
	 * @param indirizzo
	 */
	public ProdottoProduttore creaProdotto(String nome, float prezzo, String descrizione, String metodoDiColtivazione, Indirizzo indirizzo) {
		return new ProdottoProduttore(nome, prezzo,descrizione,this,indirizzo, metodoDiColtivazione);
	}

}