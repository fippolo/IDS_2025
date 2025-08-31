package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart {

	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> listaProdotti;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Cart() {
		listaProdotti = new ArrayList<Product>();
	}
	public Cart(List<Product> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	public List<Product> getListaProdotti() {
		return listaProdotti;
	}
	public void setListaProdotti(List<Product> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	public void aggiungiProdotto(Product product) {
		listaProdotti.add(product);
	}
	public void rimuoviProdotto(Product product) {
		listaProdotti.remove(product);
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