package unicam.filierafanesicardinali.model.utenti;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (getClass() != obj.getClass()) return false;
		if(obj==null && this==null) return true;
		UtenteGenerico that = (UtenteGenerico) obj;
		if (this.nome == that.nome && this.email == that.email) return false;
		return true;

	}

	/**
	 * Calcola l'hash code per questo utente basato sulla email.
	 *
	 * @return il valore hash code
	 */
	@Override
	public int hashCode() {
		return Objects.hash(email, nome);
	}

}