package unicam.filierafanesicardinali.model.amministrazione;

import unicam.filierafanesicardinali.model.utenti.UtenteGenerico;

import java.util.ArrayList;
import java.util.List;

public class GestorePiattaforma {

	private String nome;

	private List<UtenteGenerico> listaUtentiDaApprovare;

	public GestorePiattaforma(String nome) {
		this.nome = nome;
		this.listaUtentiDaApprovare = new ArrayList<UtenteGenerico>();
	}

	public void aggiungiUtente(UtenteGenerico utente) {
		this.listaUtentiDaApprovare.add(utente);
	}

	/**
	 * 
	 * @param listaUtentiDaApprovare
	 */
	private void approvaUtente(UtenteGenerico listaUtentiDaApprovare) {
		// TODO - implement GestorePiattaforma.approvaUtente
		throw new UnsupportedOperationException();
	}




}