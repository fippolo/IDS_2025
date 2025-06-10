package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Carello {

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrello_id")
	private List<Prodotto> listaProdotti;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}