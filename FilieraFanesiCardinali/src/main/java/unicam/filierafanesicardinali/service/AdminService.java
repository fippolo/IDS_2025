package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;
import unicam.filierafanesicardinali.model.ruoli.UserRole;
import unicam.filierafanesicardinali.model.utenti.PlatformAdmin;
import unicam.filierafanesicardinali.model.utenti.User;
import unicam.filierafanesicardinali.repository.AdminRepository;
import unicam.filierafanesicardinali.repository.RoleRequestRepository;

import java.util.List;

@Service
public class AdminService {
    private final RoleRequestRepository roleRequestRepository;
    private final UserService userService;
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(RoleRequestRepository roleRequestRepository,  UserService userService
    , AdminRepository adminRepository) {
        this.roleRequestRepository = roleRequestRepository;
        this.userService = userService;
        this.adminRepository = adminRepository;
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
        addRoleRequestToAdmin(adminId, RR);
        return roleRequestRepository.save(RR);
    }

    public RoleRequest deleteRoleRequest(Long roleRequestId){
        RoleRequest RR = getRoleRequest(roleRequestId);
        RR.setApproved(false);
        removeRoleRequestFromUserId(RR.getUser().getId());
        roleRequestRepository.delete(RR);
        return RR;
    }

    private void addRoleRequestToAdmin(Long adminId, RoleRequest roleRequest){
        PlatformAdmin platformAdmin = getPlatformAdmin(adminId);
        platformAdmin.addAcceptedRequest(roleRequest);
        adminRepository.save(platformAdmin);
    }

    private List<PlatformAdmin> findPlatformAdminbyRoleRequestUserId(Long id){
        return adminRepository.findByAcceptedRequestsListUserId(id);
    }

    private PlatformAdmin getPlatformAdmin(Long id){
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }
    public void  removeRoleRequestFromUserId(Long id){
        List<PlatformAdmin> admins = findPlatformAdminbyRoleRequestUserId(id);
        for (PlatformAdmin admin : admins) {
            admin.removeRoleRequestFromUserId(id);
            adminRepository.save(admin);
        }
        roleRequestRepository.deleteByUserId(id);
    }
    public User deleteUser(Long id){
        User user = userService.getUser(id);
        removeRoleRequestFromUserId(id);
        userService.removeUser(user.getId());
        user.setInvites(null);
        return user;
    }

}
