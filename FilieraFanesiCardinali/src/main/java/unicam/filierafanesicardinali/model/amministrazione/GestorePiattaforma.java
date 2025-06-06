package unicam.filierafanesicardinali.model.amministrazione;

import unicam.filierafanesicardinali.model.utenti.Acquirente;
import unicam.filierafanesicardinali.model.utenti.UtenteGenerico;
import unicam.filierafanesicardinali.model.venditori.DistributoreTipicita;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.model.venditori.Trasformatore;

import java.util.ArrayList;
import java.util.List;

public class GestorePiattaforma {

	private String nome;
	private Piattaforma piattaforma;
	private List<UtenteGenerico> listaUtentiDaApprovare;

	public GestorePiattaforma(String nome, Piattaforma piattaforma) {
		this.nome = nome;
		this.piattaforma = piattaforma;
		this.listaUtentiDaApprovare = new ArrayList<UtenteGenerico>();
	}

	public void aggiungiUtente(UtenteGenerico utente) {
		this.listaUtentiDaApprovare.add(utente);
	}

	/**
	 * 
	 * @param daApprovare
	 */
	private void approvaUtente(UtenteGenerico daApprovare, short roleID) {
		if(roleID>5 && roleID<0) throw new UnsupportedOperationException();



		if (this.listaUtentiDaApprovare.contains(daApprovare)) {

			switch (roleID) {
				case 0: piattaforma.addUtenteGenerico((UtenteGenerico) daApprovare);
				case 1: piattaforma.addProduttore(new Produttore(daApprovare.getNome(),daApprovare.getEmail(),daApprovare.getPassword()));
				case 2: piattaforma.addTrasformatore(new Trasformatore(daApprovare.getNome(),daApprovare.getEmail(),daApprovare.getPassword()));
				case 3: piattaforma.addDistributoreTipicita(new DistributoreTipicita(daApprovare.getNome(),daApprovare.getEmail(),daApprovare.getPassword()));
				case 4: piattaforma.addCuratore(new Curatore(daApprovare.getNome(),daApprovare.getEmail(),daApprovare.getPassword()));
				case 5: piattaforma.addAcquirente(new Acquirente(daApprovare.getNome()));
			}

			this.listaUtentiDaApprovare.remove(daApprovare);
		}

		throw new UnsupportedOperationException();
	}




}