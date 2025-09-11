package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.acquisto.Cart;

@Entity
public class Buyer extends User{
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;

	public Buyer(String nome, String email, String password) {
		super(nome, email, password);
		this.cart = new Cart();
	}

	public Buyer() {}

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}