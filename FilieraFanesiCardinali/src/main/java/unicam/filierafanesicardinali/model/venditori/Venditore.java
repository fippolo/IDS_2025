package unicam.filierafanesicardinali.model.venditori;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "tipo"
)
@JsonSubTypes({
		@JsonSubTypes.Type(value = Trasformatore.class, name = "trasformatore"),
		@JsonSubTypes.Type(value = Produttore.class, name = "produttore"),
		@JsonSubTypes.Type(value = DistributoreTipicita.class, name = "distributore")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_venditore", discriminatorType = DiscriminatorType.STRING)
public class Venditore implements IVenditore {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String nome;
//	private Prodotto listaProdotti;
	private String email;
	private String password;
	private boolean stato;

	public Venditore(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.stato = false;
	}

	public Venditore(){}
	/**
	 * 
	 * @param nome
	 * @param prezzo
	 * @param descrizione
	 */
	public Prodotto creaProdotto(String nome, float prezzo, String descrizione) {
		return new Prodotto(nome, prezzo, descrizione, this);
	}

	public Long getId() {
		return Id;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}
}
