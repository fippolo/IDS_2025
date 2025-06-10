package unicam.filierafanesicardinali.model.prodotti;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("distributore")
public class ProdottoDistributore extends Prodotto {

    @OneToMany(cascade = CascadeType.ALL)
	private List<Prodotto> listaProdotti;

	public ProdottoDistributore(String nome, float prezzo, String descrizione, List<Prodotto> listaProdotti) {
		super(nome, prezzo, descrizione);
		this.listaProdotti = listaProdotti;
	}

	public ProdottoDistributore() {

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