package unicam.filierafanesicardinali.model.venditori;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.filierafanesicardinali.model.localizzazione.Position;
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
	 * @param position
	 */
	public ProdottoProduttore creaProdotto(String nome, float prezzo, String descrizione, String metodoDiColtivazione, Position position) {
		return new ProdottoProduttore(nome, prezzo,descrizione,this, position, metodoDiColtivazione);
	}

}