package unicam.filierafanesicardinali.model.eventi;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Animatore {

	private String nome;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Evento> listaEventi;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Animatore(String nome) {
		this.nome = nome;
		this.listaEventi = new ArrayList<Evento>();
	}

	public Animatore() {

	}

	/**
	 * @param nome
	 * @param data
	 * @param ora
	 * @param luogo
	 * @return
	 */
	public Evento creaEvento(String nome, String data, String ora, Indirizzo luogo) {
		//listaEventi.add(new Evento(nome,data,ora,luogo,this));
		return new Evento(nome,data,ora,luogo,this);
	}


	/* INUTILE (CREDO)
	public void visualizzaEventi() {
		System.out.println("Visualizza Eventi");
		for (Evento evento : listaEventi) {
			System.out.println(evento);
		}
	}

	*/

	public Long getId() {
		return id;
	}
}