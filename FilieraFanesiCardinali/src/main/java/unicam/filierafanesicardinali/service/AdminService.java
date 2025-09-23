package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;
import unicam.filierafanesicardinali.model.ruoli.UserRole;
import unicam.filierafanesicardinali.model.utenti.User;
import unicam.filierafanesicardinali.repository.RoleRequestRepository;

import java.util.List;

@Service
public class AdminService {
    private final RoleRequestRepository roleRequestRepository;
    private final UserService userService;


    @Autowired
    public AdminService(RoleRequestRepository roleRequestRepository,  UserService userService) {
        this.roleRequestRepository = roleRequestRepository;
        this.userService = userService;
    }

    public RoleRequest submitRoleRequest(Long userId, byte roleId){
        //UserRole.fromCode already checks if the role code is valid input or throws exception
        RoleRequest roleRequest = new RoleRequest(UserRole.fromCode(roleId), userService.getUser(userId));
        return roleRequestRepository.save(roleRequest);
    }

    public RoleRequest getRoleRequest(Long id){
        return roleRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Role request not found with id: " + id));
    }

    public List<RoleRequest> getRoleRequests(){
        return roleRequestRepository.findAll();
    }

    public RoleRequest approveRoleRequest(Long roleRequestId, Long adminId){
        RoleRequest RR = getRoleRequest(roleRequestId);
        RR.setApproved(true);
        User user =  userService.getUser(RR.getUser().getId());
        RR.setUser(null);
        roleRequestRepository.save(RR);
        user =  userService.assignRole(user.getId(), RR.getRole());
        RR.setUser(user);
        userService.addRoleRequestToAdmin(adminId, RR);
        return roleRequestRepository.save(RR);
    }

    public RoleRequest deleteRoleRequest(Long roleRequestId){
        RoleRequest RR = getRoleRequest(roleRequestId);
        RR.setApproved(false);
        roleRequestRepository.delete(RR);
        return RR;
    }
}
