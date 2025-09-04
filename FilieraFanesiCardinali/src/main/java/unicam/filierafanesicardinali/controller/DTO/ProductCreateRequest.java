package unicam.filierafanesicardinali.controller.DTO;

import unicam.filierafanesicardinali.model.localizzazione.Position;

public record ProductCreateRequest(
        boolean isBundle,
        String name,
        double price,
        String description,
        Position site,
        Long sellerId
) {}