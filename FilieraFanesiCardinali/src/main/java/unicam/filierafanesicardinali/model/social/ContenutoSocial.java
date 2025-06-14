package unicam.filierafanesicardinali.model.social;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.venditori.Venditore;

public class ContenutoSocial {
    /**
     * Identificativo univoco del contenuto social.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Prodotto associato al contenuto social.
     */
    @ManyToOne
    private Prodotto prodotto;

    /**
     * Venditore associato al contenuto social.
     */
    @ManyToOne
    private Venditore venditore;

    /**
     * Descrizione del contenuto social.
     */
    private String descrizione;

    /**
     * Costruttore di default.
     */
    public ContenutoSocial() {}

    /**
     * Costruttore con parametri.
     *
     * @param prodotto     il prodotto associato al contenuto
     * @param venditore      il venditore associato al contenuto
     * @param descrizione la descrizione del contenuto
     */
    public ContenutoSocial(Prodotto prodotto, Venditore venditore, String descrizione) {
        this.prodotto = prodotto;
        this.venditore = venditore;
        this.descrizione = descrizione;
    }

    /**
     * Restituisce l'ID del contenuto social.
     *
     * @return l'ID del contenuto
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID del contenuto social.
     *
     * @param id l'ID da impostare
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il prodotto associato al contenuto social.
     *
     * @return il prodotto associato
     */
    public Prodotto getProdotto() {
        return prodotto;
    }

    /**
     * Imposta il prodotto associato al contenuto social.
     *
     * @param prodotto il prodotto da associare
     */
    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    /**
     * Restituisce il venditore associato al contenuto social.
     *
     * @return il venditore associato
     */
    public Venditore getVenditore() {
        return venditore;
    }

    /**
     * Imposta il venditore associato al contenuto social.
     *
     * @param venditore il venditore da associare
     */
    public void setVenditore(Venditore venditore) {
        this.venditore = venditore;
    }

    /**
     * Restituisce la descrizione del contenuto social.
     *
     * @return la descrizione del contenuto
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta la descrizione del contenuto social.
     *
     * @param descrizione la descrizione da impostare
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
