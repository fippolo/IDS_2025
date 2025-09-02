package unicam.filierafanesicardinali.model.eventi;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;

@Entity
public class Evento {

	private String nome;
	private String data;
	private String ora;

	@ManyToOne
	private Animatore animatore;

	@ManyToOne
	private Indirizzo luogo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Evento(String nome, String data, String ora, Indirizzo luogo, Animatore animatore) {
		this.nome = nome;
		this.data = data;
		this.ora = ora;
		this.luogo = luogo;
		this.animatore = animatore;
	}

	public Evento() {

	}

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return this.data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return this.ora;
	}

	/**
	 * 
	 * @param ora
	 */
	public void setOra(String ora) {
		this.ora = ora;
	}

	public Indirizzo getLuogo() {
		return this.luogo;
	}

	/**
	 * 
	 * @param luogo
	 */
	public void setLuogo(Indirizzo luogo) {
		this.luogo = luogo;
	}



	public Long getId() {
		return id;
	}

	public Animatore getAnimatore() {
		return animatore;
	}
}