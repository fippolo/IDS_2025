package unicam.filierafanesicardinali.model.acquisto.orders;

import unicam.filierafanesicardinali.model.acquisto.CartItem;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderBuilder {
    IOrderBuilder withInsertionDate(LocalDateTime date);
    IOrderBuilder setBuyer(Long idBuyer);
    IOrderBuilder addProduct(CartItem product);
    IOrderBuilder addProducts(List<CartItem> products);
    Order build();
}
