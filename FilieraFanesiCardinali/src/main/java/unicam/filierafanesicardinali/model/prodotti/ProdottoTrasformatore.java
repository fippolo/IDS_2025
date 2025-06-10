package unicam.filierafanesicardinali.model.prodotti;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("trasformatore")
public class ProdottoTrasformatore extends Prodotto {

	private String ProcessoDiTrasformazione;

	public ProdottoTrasformatore(String nome, float prezzo, String descrizione, String processoDiTrasformazione) {
		super(nome, prezzo, descrizione);
		this.ProcessoDiTrasformazione = processoDiTrasformazione;
	}

	public ProdottoTrasformatore() {

	}

	public String getProcessoDiTrasformazione() {
		return ProcessoDiTrasformazione;
	}

	/**
	 * 
	 * @param processoDiTrasformazione
	 */
	public void setProcessoDiTrasformazione(String processoDiTrasformazione) {
		this.ProcessoDiTrasformazione = processoDiTrasformazione;
	}

}