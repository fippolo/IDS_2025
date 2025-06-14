package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Carrello {

	@OneToMany(cascade = CascadeType.ALL)
	private List<Prodotto> listaProdotti;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Carrello() {
		listaProdotti = new ArrayList<Prodotto>();
	}
	public Carrello(List<Prodotto> listaProdotti) {
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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}