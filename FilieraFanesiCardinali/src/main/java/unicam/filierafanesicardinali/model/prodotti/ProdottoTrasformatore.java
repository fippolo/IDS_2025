package unicam.filierafanesicardinali.model.prodotti;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.venditori.Trasformatore;

@Entity
@DiscriminatorValue("trasformatore")
public class ProdottoTrasformatore extends Prodotto {

	private String ProcessoDiTrasformazione;

	public ProdottoTrasformatore(String nome, float prezzo, String descrizione, Trasformatore trasformatore, Indirizzo indirizzo, String processoDiTrasformazione) {
		super(nome, prezzo, descrizione,trasformatore, indirizzo);
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