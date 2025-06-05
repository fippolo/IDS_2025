package unicam.filierafanesicardinali.model.utenti;

public class UtenteGenerico {

	private String nome;
	private String email;
	private String password;


	/**
	 * costruttore classe UtenteGenerico, crea un oggetto con i parametri specificati
	 * @param nome nome utente
	 * @param email email utente
	 * @param password password utente
	 */
	UtenteGenerico(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void richiediRuolo() {
		// TODO - implement UtenteGenerico.richiediRuolo
		throw new UnsupportedOperationException();
	}

}