package unicam.filierafanesicardinali.model.acquisto.orders;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ReceiptNumberGenerator {
    private final AtomicInteger receiptNumber = new AtomicInteger(0);
    public int next(){return receiptNumber.incrementAndGet();}
}
