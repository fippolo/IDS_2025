package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ElementCollection
	@CollectionTable(
			name = "cart_items",
			joinColumns = @JoinColumn(name = "cart_id"),
			uniqueConstraints = @UniqueConstraint(columnNames = { "cart_id", "product_id" })
	)
	private List<CartItem> cartItemList = new ArrayList<>();

	public Cart() {}

	public List<CartItem> getCartItemList() { return cartItemList; }
	public void emptyCart() { cartItemList.clear(); }
	public Long getId() { return id; }
	
}