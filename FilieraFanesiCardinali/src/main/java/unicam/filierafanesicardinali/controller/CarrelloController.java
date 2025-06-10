package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carrelli")
public class CarrelloController {
    private final AcquirenteController acquirenteController;

    @Autowired
    public CarrelloController(AcquirenteController acquirenteController) {
        this.acquirenteController = acquirenteController;
    }


}
