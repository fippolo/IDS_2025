package unicam.filierafanesicardinali.model.prodotti;


import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.venditori.Venditore;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
public abstract class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private double price;
	private boolean stato;
	private String descrizione;
	private Long sellerId;

	@Embedded
	private Position productionSite;

	public Product(String name, double price, String descrizione, Long sellerId, Position productionSite) {
		this.name = name;
		this.price = price;
		this.stato = false;
		this.descrizione = descrizione;
		this.sellerId = sellerId;
		this.productionSite = productionSite;
	}

	public Product() {
	}
	// getters and setters
}