package unicam.filierafanesicardinali.model.acquisto.orders;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import unicam.filierafanesicardinali.model.acquisto.CartItem;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Scope(value = "prototype")
public class OrderBuilder implements IOrderBuilder{
    private final Order draft=new Order();

    @Override
    public IOrderBuilder withInsertionDate(LocalDateTime date) {
        draft.setInsertionDate(date);
        return this;
    }

    @Override
    public IOrderBuilder setBuyer(Long idBuyer) {
        draft.setIdBuyer(idBuyer);
        return this;
    }

    @Override
    public IOrderBuilder addProduct(CartItem product) {
        draft.getOrderItems().add(product);
        return this;
    }

    @Override
    public IOrderBuilder addProducts(List<CartItem> products) {
        draft.getOrderItems().addAll(products);
        return this;
    }

    @Override
    public Order build() {
        draft.setTotal(draft.getOrderItems().stream().mapToDouble(CartItem::getSubtotal).sum());
        return draft;
    }
}
