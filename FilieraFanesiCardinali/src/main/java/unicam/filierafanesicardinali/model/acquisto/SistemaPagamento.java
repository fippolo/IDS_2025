package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.Acquirente;

@Entity
public class SistemaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Acquirente acquirente;

    @ManyToOne
    private Product product;

    public SistemaPagamento(Acquirente acquirente, Product product) {
        this.acquirente = acquirente;
        this.product = product;
    }

    public SistemaPagamento() {

    }

    public Product getProdotto() {
        return product;
    }

    public void setProdotto(Product product) {
        this.product = product;
    }

//    public Venditore getVenditore() {
//        return venditore;
//    }

//    public void setVenditore(Venditore venditore) {
//        this.venditore = venditore;
//    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}