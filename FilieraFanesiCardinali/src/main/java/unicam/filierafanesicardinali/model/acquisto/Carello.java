package unicam.filierafanesicardinali.model.acquisto;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class Carello {

	private List<Prodotto> listaProdotti;

	public Carello() {
		listaProdotti = new ArrayList<Prodotto>();
	}
	public Carello(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}
	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	public void aggiungiProdotto(Prodotto prodotto) {
		listaProdotti.add(prodotto);
	}
	public void rimuoviProdotto(Prodotto prodotto) {
		listaProdotti.remove(prodotto);
	}

	public void svuotaCarello() {
		listaProdotti.clear();
	}

}