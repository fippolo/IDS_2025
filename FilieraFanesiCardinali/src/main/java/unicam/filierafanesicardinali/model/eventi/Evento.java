package unicam.filierafanesicardinali.model.eventi;

import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;

public class Evento {

	private String nome;
	private String data;
	private String ora;
	private Indirizzo luogo;

	public Evento(String nome, String data, String ora, Indirizzo luogo) {
		this.nome = nome;
		this.data = data;
		this.ora = ora;
		this.luogo = luogo;
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

}