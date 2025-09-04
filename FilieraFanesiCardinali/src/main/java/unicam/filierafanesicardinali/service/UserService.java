package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.utenti.*;
import unicam.filierafanesicardinali.repository.BuyerRepository;
import unicam.filierafanesicardinali.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BuyerRepository buyerRepository;
    @Autowired
    public UserService(UserRepository userRepository, BuyerRepository buyerRepository) {
        this.userRepository = userRepository;
        this.buyerRepository = buyerRepository;
    }

    public GenericUser createUser(GenericUser user){
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //TODO: role requests

    public User assignRole(Long id, byte role){
        User user = getUser(id);
        userRepository.deleteById(id);
        return switch (role) {
            case 0 -> userRepository.save((Authenticator) user);
            case 1 -> buyerRepository.save((Buyer) user);
            case 2 -> userRepository.save((Entertainer) user);
            case 3 -> userRepository.save((GenericUser) user);
            case 4 -> userRepository.save((Seller) user);
            default -> throw new RuntimeException("Role not found");
        };
    }


    public User deleteUser(Long id){
        User user = getUser(id);
        userRepository.deleteById(user.getId());
        return user;
    }
}
