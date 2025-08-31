package unicam.filierafanesicardinali.model.localizzazione;

import jakarta.persistence.*;

@Embeddable
public class Position {

	private String via;
	private String CAP;
	private String civico;
	private String citta;
	private String provincia;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Position() {

	}

	public Position(String via, String civico, String citta, String provincia) {
		this.via = via;
		this.civico = civico;
		this.citta = citta;
		this.provincia = provincia;
	}
	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCAP() {
		return this.CAP;
	}

	public void setCap(String CAP) {
		this.CAP = CAP;
	}

	public String getCivico() {
		return this.civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return this.provincia + "";
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}



}