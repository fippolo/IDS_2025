package unicam.filierafanesicardinali.model.prodotti;

import java.util.List;

public class ProdottoDistributore extends Prodotto {

	private List<Prodotto> listaProdotti;

	public ProdottoDistributore(String nome, float prezzo, String descrizione, List<Prodotto> listaProdotti) {
		super(nome, prezzo, descrizione);
		this.listaProdotti = listaProdotti;
	}

	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	/**
	 * 
	 * @param listaProdotti
	 */
	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

}