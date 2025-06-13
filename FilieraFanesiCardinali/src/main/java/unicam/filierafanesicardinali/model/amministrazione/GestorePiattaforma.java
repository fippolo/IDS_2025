package unicam.filierafanesicardinali.model.amministrazione;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class GestorePiattaforma {

	private String nome;
	//private Piattaforma piattaforma;
	//private List<UtenteGenerico> listaUtentiDaApprovare;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public GestorePiattaforma(String nome) {
		this.nome = nome;
		//this.piattaforma = piattaforma;
		//this.listaUtentiDaApprovare = new ArrayList<UtenteGenerico>();
	}

	public GestorePiattaforma() {

	}
/*
	public void aggiungiUtente(UtenteGenerico utente) {
		this.listaUtentiDaApprovare.add(utente);
	}

	/**
	 * 
	 * @param daApprovare

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

	*/
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}