package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.venditori.Venditore;

@Entity
public class SistemaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Venditore venditore;

    @ManyToOne
    private Prodotto prodotto;

    public SistemaPagamento(Venditore venditore, Prodotto prodotto) {
        this.venditore = venditore;
        this.prodotto = prodotto;
    }

    public SistemaPagamento() {

    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Venditore getVenditore() {
        return venditore;
    }

    public void setVenditore(Venditore venditore) {
        this.venditore = venditore;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}