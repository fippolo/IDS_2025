package unicam.filierafanesicardinali.model.prodotti;


public class Prodotto {

	private String nome;
	private float prezzo;
	private boolean stato;
	private String descrizione;

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return this.prezzo;
	}

	/**
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public boolean getStato() {
		return this.stato;
	}

	/**
	 * 
	 * @param stato
	 */
	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	/**
	 * 
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}