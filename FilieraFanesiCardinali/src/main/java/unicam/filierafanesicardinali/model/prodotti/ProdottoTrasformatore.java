package unicam.filierafanesicardinali.model.prodotti;

public class ProdottoTrasformatore extends Prodotto {

	private String ProcessoDiTrasformazione;

	public ProdottoTrasformatore(String nome, float prezzo, boolean stato, String descrizione, String processoDiTrasformazione) {
		super(nome, prezzo, stato, descrizione);
		this.ProcessoDiTrasformazione = processoDiTrasformazione;
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