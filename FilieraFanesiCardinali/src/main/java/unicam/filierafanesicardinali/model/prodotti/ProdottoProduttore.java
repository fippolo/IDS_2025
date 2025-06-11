package unicam.filierafanesicardinali.model.prodotti;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.filierafanesicardinali.model.venditori.Produttore;

@Entity
@DiscriminatorValue("produttore")
public class ProdottoProduttore extends Prodotto {

	private String metodoDiColtivazione;

	public ProdottoProduttore(String nome, float prezzo, String descrizione, Produttore produttore, String metodoDiColtivazione) {
		super(nome, prezzo, descrizione, produttore);
		this.metodoDiColtivazione = metodoDiColtivazione;
	}

	public ProdottoProduttore() {

	}

	public String getMetodoDiColtivazione() {
		return this.metodoDiColtivazione;
	}

	/**
	 * 
	 * @param metodoDiColtivazione
	 */
	public void setMetodoDiColtivazione(String metodoDiColtivazione) {
		this.metodoDiColtivazione = metodoDiColtivazione;
	}

}