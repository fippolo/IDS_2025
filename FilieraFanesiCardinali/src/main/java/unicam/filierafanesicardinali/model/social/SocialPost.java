package unicam.filierafanesicardinali.model.social;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.time.LocalDateTime;

@Entity
public class SocialPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "product_id",
            insertable = false, updatable = false,              // productId is the source of truth
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) // don't create FK constraint
    )
    @NotFound(action = NotFoundAction.IGNORE)               // if the row is missing, set to null instead of failing
    private Product product;

    private String linkToPost;
    private java.time.LocalDateTime dateOfPosting;
    
    public SocialPost() {
        this.dateOfPosting = java.time.LocalDateTime.now();
    }
    public SocialPost(Product product, String linkToPost) {
        this.product = product;
        this.productId = product.getId();
        this.linkToPost = linkToPost;
        this.dateOfPosting = java.time.LocalDateTime.now();
    }
    public SocialPost(Long productId, String linkToPost) {
        this.productId = productId;
        this.linkToPost = linkToPost;
        this.dateOfPosting = java.time.LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getLinkToPost() {
        return linkToPost;
    }

    public void setLinkToPost(String linkToPost) {
        this.linkToPost = linkToPost;
    }

    public LocalDateTime getDateOfPosting() {
        return dateOfPosting;
    }

    public void setDateOfPosting(LocalDateTime dataCreazione) {
        this.dateOfPosting = dataCreazione;
    }
}
