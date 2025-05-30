package unicam.filierafanesicardinali.model.amministrazione;

import unicam.filierafanesicardinali.model.eventi.Evento;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.utenti.UtenteGenerico;

import java.util.List;

public class Piattaforma {

	private List<UtenteGenerico> listaUtenti;
	private List<Prodotto> listaProdotti;
	private List<Evento> listaEventi;
	private Piattaforma instance;

}