package unicam.filierafanesicardinali.model.amministrazione;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.amministrazione.Piattaforma;

@Entity
public class Curatore {

	private String nome;
	private String email;
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Curatore(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public Curatore() {

	}

	/*
	 * 
	 * @param prodotto

	private void approvaProdotto(Prodotto prodotto) {
		// TODO - implement Curatore.approvaProdotto
		if(piattaforma.showProdotti().contains(prodotto)){
			for(Prodotto p : piattaforma.showProdotti())
			{
				if(p.equals(prodotto)){
					p.setStato(true);
				}
			}
		}
		throw new UnsupportedOperationException();
	}
	 */

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}