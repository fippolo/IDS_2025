package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.utenti.User;
import unicam.filierafanesicardinali.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User genericUser) {
        return ResponseEntity.ok(userService.createUser(genericUser));
    }



    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User toRet=userService.getUser(id);
        return ResponseEntity.ok(toRet);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
