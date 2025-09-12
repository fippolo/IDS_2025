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
    public IOrderBuilder addProduct(CartItem ci) {
        // create a brand new CartItem instance; DO NOT add the same object
        draft.getOrderItems().add(new CartItem(ci.getProduct(), ci.getQuantity()));
        return this;
    }

    @Override
    public IOrderBuilder addProducts(List<CartItem> items) {
        if (items == null || items.isEmpty()) return this;

        List<CartItem> target = draft.getOrderItems(); // List<CartItem>
        for (CartItem incoming : items) {
            if (incoming == null || incoming.getProduct() == null) continue;
            Product p = incoming.getProduct();
            Long pid = p.getId();
            if (pid == null) continue;

            int qty = incoming.getQuantity();
            if (qty <= 0) continue;

            boolean merged = false;
            for (CartItem existing : target) {
                Product ep = existing.getProduct();
                if (ep != null && pid.equals(ep.getId())) {
                    existing.setQuantity(existing.getQuantity() + qty); // merge
                    merged = true;
                    break;
                }
            }
            if (!merged) {
                // IMPORTANT: create a NEW instance so Order owns its copy
                target.add(new CartItem(p, qty));
            }
        }
        return this;
    }

    @Override
    public Order build() {
        draft.setTotal(draft.getOrderItems().stream().mapToDouble(CartItem::getSubtotal).sum());
        return draft;
    }
}
