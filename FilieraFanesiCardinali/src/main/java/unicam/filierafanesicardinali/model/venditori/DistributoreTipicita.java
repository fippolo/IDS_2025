package unicam.filierafanesicardinali.model.venditori;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;

import java.util.ArrayList;
import java.util.List;

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

	public ProdottoDistributore creaProdotto(String nome, float prezzo, String descrizione, Indirizzo indirizzo) {
		return new ProdottoDistributore(nome, prezzo, descrizione, this,indirizzo, null);
	}


	public void startBundle(String nome, float prezzo, String descrizione, Indirizzo indirizzo){
		bundle = new ProdottoDistributore(nome, prezzo,descrizione, this,indirizzo, new ArrayList<>());

	}

	public void aggiungiProdotto(Prodotto prodotto){
		if(bundle != null && prodotto != null){
			this.bundle.aggiungiProdotto(prodotto);

		}
		else throw new NullPointerException("Prodotto non trovato");
	}

	public ProdottoDistributore endBundle(){
		ProdottoDistributore prodotto = bundle;
		bundle = null;
		return prodotto;
	}



}