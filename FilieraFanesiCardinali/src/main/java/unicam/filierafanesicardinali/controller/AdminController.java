package unicam.filierafanesicardinali.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.filierafanesicardinali.service.UserService;

@RestController
@RequestMapping("/api/v1/RoleRequest")
public class AdminController {
    UserService userService;

}
