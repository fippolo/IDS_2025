package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.acquisto.Cart;

@Entity
public class Acquirente {

	private String nome;


    @Id
    private Long id;

	@OneToOne
	private Cart cart;



	public Cart getCarrello() {
		return cart;
	}

	public void setCarrello(Cart cart) {
		this.cart = cart;
	}


	public Acquirente(String nome) {
		this.nome = nome;
        cart = new Cart();


    }

	public Acquirente() {


    }

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}




}