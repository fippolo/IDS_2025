package unicam.filierafanesicardinali.model.prodotti;


import java.util.Objects;

public class Prodotto {

	private String nome;
	private float prezzo;
	private boolean stato;
	private String descrizione;

	public Prodotto(String nome, float prezzo, boolean stato, String descrizione) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.stato = stato;
		this.descrizione = descrizione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return this.prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public boolean getStato() {
		return this.stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

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