package unicam.filierafanesicardinali.model.prodotti;


import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
public abstract class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "product_type", insertable = false, updatable = false)
	private String productType;

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

	public double getPrice() {
		return price;
	}

	public Position getProductionSite() {
		return productionSite;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStato() {
		return stato;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public void setProductionSite(Position productionSite) {
		this.productionSite = productionSite;
	}
}