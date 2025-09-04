package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Product;
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

    public User createUser(User user){
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
        String nome = user.getNome();
        String email = user.getEmail();
        String password = user.getPassword();
        userRepository.deleteById(id);
        return switch (role) {
            case 0 -> userRepository.save(new Authenticator(nome, email, password));
            case 1 -> buyerRepository.save(new Buyer(nome, email, password));
            case 2 -> userRepository.save(new Entertainer(nome, email, password));
            case 4 -> userRepository.save(new Seller(nome, email, password));
            default -> throw new RuntimeException("Role not found");
        };
    }


    public User deleteUser(Long id){
        User user = getUser(id);
        userRepository.deleteById(user.getId());
        user.setInvites(null);
        return user;
    }

    public void addProductToSeller(Long SellerId, Product product){
        Seller seller = (Seller) getUser(SellerId);
        seller.addOnSaleProduct(product);
        userRepository.save(seller);
    }

    public Seller getSeller(Long id){
        if(!(getUser(id) instanceof Seller)) throw new RuntimeException("User is not a Seller");
        return (Seller) getUser(id);
    }
}
