package unicam.filierafanesicardinali.model.social;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Product;

@Entity
public class SocialPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private String linkToPost;
    private java.time.LocalDateTime dataCreazione;
    
    public SocialPost() {
        this.dataCreazione = java.time.LocalDateTime.now();
    }
    public SocialPost(Product product, String linkToPost) {
        this.product = product;
        this.linkToPost = linkToPost;
        this.dataCreazione = java.time.LocalDateTime.now();
    }
}
