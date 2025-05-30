package unicam.filierafanesicardinali.model.eventi;

import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;

public class Evento {

	private String nome;
	private String data;
	private String ora;
	private Indirizzo luogo;

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

	public String getLuogo() {
		// TODO - implement Evento.getLuogo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param luogo
	 */
	public void setLuogo(String luogo) {
		// TODO - implement Evento.setLuogo
		throw new UnsupportedOperationException();
	}

}