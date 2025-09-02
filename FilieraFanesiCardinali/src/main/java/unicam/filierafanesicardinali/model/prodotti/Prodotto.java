package unicam.filierafanesicardinali.model.prodotti;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.venditori.Venditore;

import java.util.Objects;


/**
 * Classe che rappresenta un prodotto generico all'interno della filiera.
 * Questa classe utilizza l'ereditarietà per gestire diversi tipi di prodotti.
 */
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "tipo"
)
@JsonSubTypes({
		@JsonSubTypes.Type(value = ProdottoProduttore.class, name = "produttore"),
		@JsonSubTypes.Type(value = ProdottoTrasformatore.class, name = "trasformatore"),
		@JsonSubTypes.Type(value = ProdottoDistributore.class, name = "distributore")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_prodotto", discriminatorType = DiscriminatorType.STRING)
public class Prodotto {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Venditore venditore;
	private String nome;
	private float prezzo;
	private boolean stato;
	private String descrizione;
	@OneToOne
	private Indirizzo indirizzo;

	public Venditore getVenditore() {
		return venditore;
	}

	public void setVenditore(Venditore venditore) {
		this.venditore = venditore;
	}

	public Prodotto(String nome, float prezzo, String descrizione, Venditore venditore, Indirizzo indirizzo) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.stato = false;
		this.descrizione = descrizione;
		this.venditore = venditore;
		this.indirizzo = indirizzo;
	}

	public Prodotto() {}


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

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
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

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id,nome, prezzo, stato, descrizione);
		return result;
	}
}