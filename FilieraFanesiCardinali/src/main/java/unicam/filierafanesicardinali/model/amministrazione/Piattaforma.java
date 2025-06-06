package unicam.filierafanesicardinali.model.amministrazione;

import unicam.filierafanesicardinali.model.eventi.Evento;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.utenti.Acquirente;
import unicam.filierafanesicardinali.model.utenti.UtenteGenerico;
import unicam.filierafanesicardinali.model.venditori.DistributoreTipicita;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.model.venditori.Trasformatore;

import java.util.ArrayList;
import java.util.List;

public class Piattaforma {

	private List<UtenteGenerico> listaUtenti;
	private List<Produttore> listaProduttori;
	private List<Trasformatore> listaTrasformatori;
	private List<DistributoreTipicita> listaDistributoreTipicita;
	private List<Curatore> listaCuratore;
	private List<Acquirente> listaAcquirente;
	private List<Prodotto> listaProdotti;
	private List<Evento> listaEventi;
	private static volatile Piattaforma instance;
	//TODO capire cosa gestire su questa classe

	private Piattaforma() {
		this.listaUtenti = new ArrayList<UtenteGenerico>();
		this.listaProduttori = new ArrayList<Produttore>();
		this.listaTrasformatori = new ArrayList<Trasformatore>();
		this.listaDistributoreTipicita = new ArrayList<DistributoreTipicita>();
		this.listaCuratore = new ArrayList<Curatore>();
		this.listaAcquirente = new ArrayList<Acquirente>();
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



	public void addDistributoreTipicita(DistributoreTipicita distributoreTipicita) {
		this.listaDistributoreTipicita.add(distributoreTipicita);
	}

	public void addCuratore(Curatore curatore) {
		this.listaCuratore.add(curatore);
	}

	public void addAcquirente(Acquirente acquirente) {
		this.listaAcquirente.add(acquirente);
	}


	public void addUtenteGenerico(UtenteGenerico utente) {
		this.listaUtenti.add(utente);
	}


	public void addProduttore(Produttore produttore) {
		this.listaProduttori.add(produttore);
	}

	public void addTrasformatore(Trasformatore trasformatore) {
		this.listaTrasformatori.add(trasformatore);
	}

	public List<Prodotto> showProdotti() {
		return this.listaProdotti;
	}
}