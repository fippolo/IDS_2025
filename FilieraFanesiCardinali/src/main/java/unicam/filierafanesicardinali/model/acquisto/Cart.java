package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart {

	@OneToMany(cascade = CascadeType.ALL)
	private List<CartItem> CartItemList;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Cart() {
		CartItemList = new ArrayList<CartItem>();
	}
}