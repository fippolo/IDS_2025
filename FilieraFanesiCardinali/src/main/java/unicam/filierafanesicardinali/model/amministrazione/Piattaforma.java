package unicam.filierafanesicardinali.model.amministrazione;

import org.springframework.stereotype.Component;
import unicam.filierafanesicardinali.model.eventi.Evento;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;


import java.util.ArrayList;
import java.util.List;

@Component
public class Piattaforma {


	private List<Prodotto> listaProdotti;
	private List<Evento> listaEventi;
	private static volatile Piattaforma instance;
	//TODO capire cosa gestire su questa classe

	private Piattaforma() {

		this.listaProdotti = new ArrayList<Prodotto>();
		this.listaEventi = new ArrayList<Evento>();
	}

	public static Piattaforma getInstance() {
		if (instance == null) {
			synchronized (Piattaforma.class) {
				if (instance == null) {
					instance = new Piattaforma();
				}
			}
		}
		return instance;
	}


	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public List<Evento> getListaEventi() {
		return listaEventi;
	}

	public void setListaEventi(List<Evento> listaEventi) {
		this.listaEventi = listaEventi;
	}
}
