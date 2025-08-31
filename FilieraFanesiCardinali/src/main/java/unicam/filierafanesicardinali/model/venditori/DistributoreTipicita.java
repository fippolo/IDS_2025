package unicam.filierafanesicardinali.model.venditori;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;

import java.util.ArrayList;

@Entity
@DiscriminatorValue("distributore")
public class DistributoreTipicita extends Venditore implements IBuilder {


	@Transient
	private ProdottoDistributore bundle = null;

	public DistributoreTipicita(String nome, String email, String password) {
		super(nome, email, password);
	}

	public DistributoreTipicita() {

	}

	public ProdottoDistributore creaProdotto(String nome, float prezzo, String descrizione, Position position) {
		return new ProdottoDistributore(nome, prezzo, descrizione, this, position, null);
	}


	public void startBundle(String nome, float prezzo, String descrizione, Position position){
		bundle = new ProdottoDistributore(nome, prezzo,descrizione, this, position, new ArrayList<>());

	}

	public void aggiungiProdotto(Product product){
		if(bundle != null && product != null){
			this.bundle.aggiungiProdotto(product);

		}
		else throw new NullPointerException("Prodotto non trovato");
	}

	public ProdottoDistributore endBundle(){
		ProdottoDistributore prodotto = bundle;
		bundle = null;
		return prodotto;
	}



}