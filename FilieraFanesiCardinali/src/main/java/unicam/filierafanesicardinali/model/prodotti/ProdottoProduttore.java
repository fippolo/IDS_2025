package unicam.filierafanesicardinali.model.prodotti;

public class ProdottoProduttore extends Prodotto {

	private String metodoDiColtivazione;

	public ProdottoProduttore(String nome, float prezzo, boolean stato, String descrizione,String metodoDiColtivazione) {
		super(nome, prezzo, stato, descrizione);
		this.metodoDiColtivazione = metodoDiColtivazione;
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