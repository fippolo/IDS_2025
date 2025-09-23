package unicam.filierafanesicardinali.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;
import unicam.filierafanesicardinali.model.ruoli.UserRole;
import unicam.filierafanesicardinali.model.utenti.*;
import unicam.filierafanesicardinali.repository.AuthenticatorRepository;
import unicam.filierafanesicardinali.repository.BuyerRepository;
import unicam.filierafanesicardinali.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BuyerRepository buyerRepository;
    private final AuthenticatorRepository authenticatorRepository;

    @Autowired
    public UserService(UserRepository userRepository, BuyerRepository buyerRepository
    , AuthenticatorRepository authenticatorRepository) {
        this.userRepository = userRepository; this.buyerRepository = buyerRepository;
        this.authenticatorRepository = authenticatorRepository;
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

    public User assignRole(Long id, UserRole role){
        User user = getUser(id);
        String nome = user.getNome();
        String email = user.getEmail();
        String password = user.getPassword();
        userRepository.deleteById(id);
        return switch (role.getCode()) {
            case 0 -> userRepository.save(new Authenticator(nome, email, password));
            case 1 -> buyerRepository.save(new Buyer(nome, email, password));
            case 2 -> userRepository.save(new Entertainer(nome, email, password));
            case 3 -> userRepository.save(new Seller(nome, email, password));
            default -> throw new RuntimeException("Role not found");
        };
    }

    public User deleteUser(Long id){
        User user = getUser(id);
        userRepository.deleteById(user.getId());
        user.setInvites(null);
        return user;
    }

    public Product addProductToSeller(Long sellerId, Product product){
        Seller seller = getSeller(sellerId);
        seller.addOnSaleProduct(product);
        // return product added to the list
        return userRepository.save(seller).getOnSaleProducts().get(seller.getOnSaleProducts().size() - 1);
    }

    public Seller getSeller(Long id){
        if(!(getUser(id) instanceof Seller)) throw new RuntimeException("User is not a Seller");
        return (Seller) getUser(id);
    }

    public Entertainer getEventCreator(Long id){
        User user = getUser(id);
        if(user instanceof Entertainer){
            return (Entertainer) user;
        } else {
            throw new RuntimeException("User is not an entertainer");
        }
    }

    public void addEventToEntertainer(Long entertainerId, Event event){
        Entertainer entertainer = getEventCreator(entertainerId);
        entertainer.addEvent(event);
        userRepository.save(entertainer);
    }

    public void removeEventFromEntertainer(Long entertainerId, Event event){
        Entertainer entertainer = getEventCreator(entertainerId);
        entertainer.removeEvent(event);
        userRepository.save(entertainer);
    }

    public void addAuthenticatedProduct(Long authenticatorId, Product product){
        Authenticator authenticator = getAuthenticator(authenticatorId);
        authenticator.addAuthenticatedProduct(product);
        userRepository.save(authenticator);
    }

    public void removeAuthenticatedProduct(Product product){
        Authenticator authenticator = authenticatorRepository.findAllByProductId(product.getId()).get(0);
        authenticator.removeAuthenticatedProduct(product);
        authenticatorRepository.save(authenticator);
    }

    public void addRoleRequestToAdmin(Long adminId, RoleRequest roleRequest){
        PlatformAdmin platformAdmin = getPlatformAdmin(adminId);
        platformAdmin.addAcceptedRequest(roleRequest);
        userRepository.save(platformAdmin);
    }

    //helper methods
    private Authenticator getAuthenticator(Long id){
        User user = getUser(id);
        if(user instanceof Authenticator){
            return (Authenticator) user;
        } else { throw new RuntimeException("User is not an authenticator"); }
    }

    private PlatformAdmin getPlatformAdmin(Long id){
        User user = getUser(id);
        if(user instanceof PlatformAdmin){
            return (PlatformAdmin) user;
        } else  { throw new RuntimeException("User is not an platform admin"); }
    }

    @PostConstruct
    public void init(){
        // inizializzazione admin, TODO: implementare acquisizione dati da un file di config esterno
        PlatformAdmin platformAdmin = new PlatformAdmin("admin", "admin", "admin");
        userRepository.save(platformAdmin);
    }
}
