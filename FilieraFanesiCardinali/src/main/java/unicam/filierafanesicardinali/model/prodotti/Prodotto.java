package unicam.filierafanesicardinali.model.prodotti;


import java.util.Objects;

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



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Prodotto prodotto = (Prodotto) o;
		if (Float.compare(prodotto.prezzo, prezzo) != 0) return false;
		if (stato != prodotto.stato) return false;
		if (nome.compareTo(prodotto.nome) != 0) return false;
		if (descrizione.compareTo(prodotto.descrizione) != 0) return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(nome, prezzo, stato, descrizione);
		return result;
	}
}