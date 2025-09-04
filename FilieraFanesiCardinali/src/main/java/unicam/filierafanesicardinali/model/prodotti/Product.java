package unicam.filierafanesicardinali.model.prodotti;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.utenti.Seller;

//TODO: Product Type Enumerator
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	@JsonBackReference("seller-products")
	private Seller seller;


	@Embedded
	private Position productionSite;

	public Product(String name, double price, String descrizione, Seller seller, Position productionSite, String productType) {
		this.name = name;
		this.price = price;
		this.stato = false;
		this.descrizione = descrizione;
		this.seller = seller;
		this.productionSite = productionSite;
		this.productType = productType;
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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller sellerId) {
		this.seller = sellerId;
	}

	public void setProductionSite(Position productionSite) {
		this.productionSite = productionSite;
	}
}