package unicam.filierafanesicardinali.model.eventi;

import unicam.filierafanesicardinali.model.eventi.Evento;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;

import java.util.ArrayList;
import java.util.List;

public class Animatore {

	private String nome;
	private List<Evento> listaEventi;

	public Animatore(String nome) {
		this.nome = nome;
		this.listaEventi = new ArrayList<Evento>();
	}

	/**
	 * 
	 * @param nome
	 * @param data
	 * @param ora
	 * @param luogo
	 */
	public void creaEvento(String nome, String data, String ora, Indirizzo luogo) {
		listaEventi.add(new Evento(nome,data,ora,luogo));
	}

	public void visualizzaEventi() {
		System.out.println("Visualizza Eventi");
		for (Evento evento : listaEventi) {
			System.out.println(evento);
		}
	}

}