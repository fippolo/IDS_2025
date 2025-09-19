package unicam.filierafanesicardinali.model.social;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.time.LocalDateTime;

@Entity
public class SocialPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private String linkToPost;
    private java.time.LocalDateTime dateOfPosting;
    
    public SocialPost() {
        this.dateOfPosting = java.time.LocalDateTime.now();
    }
    public SocialPost(Product product, String linkToPost) {
        this.product = product;
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
