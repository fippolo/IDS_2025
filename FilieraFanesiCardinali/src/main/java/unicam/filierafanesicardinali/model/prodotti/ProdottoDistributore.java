package unicam.filierafanesicardinali.model.prodotti;

import java.util.ArrayList;
import java.util.List;

public class ProdottoDistributore extends Prodotto {

	private List<Prodotto> listaProdotti;

	public ProdottoDistributore(String nome, float prezzo, boolean stato, String descrizione) {
		super(nome, prezzo, stato, descrizione);
		listaProdotti = new ArrayList<Prodotto>();
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