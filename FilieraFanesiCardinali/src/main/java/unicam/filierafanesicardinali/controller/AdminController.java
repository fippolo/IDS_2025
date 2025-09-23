package unicam.filierafanesicardinali.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.controller.DTO.RoleRequestDTO;
import unicam.filierafanesicardinali.model.ruoli.RoleRequest;
import unicam.filierafanesicardinali.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/RoleRequest")
public class AdminController {
    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService=adminService;
    }

    @PostMapping("/SubmitRequest")
    public ResponseEntity<RoleRequest>  submitRequest(@RequestBody RoleRequestDTO roleRequestDTO){
        return ResponseEntity.ok( adminService.submitRoleRequest(
                roleRequestDTO.userId(), roleRequestDTO.roleId()));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<RoleRequest>  approveRequest(@PathVariable Long id, @RequestBody Long adminId){
        return ResponseEntity.ok( adminService.approveRoleRequest(id, adminId));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<RoleRequest>  deleteRequest(@PathVariable Long id){
        return ResponseEntity.ok( adminService.deleteRoleRequest(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleRequest>  getRoleRequest(@PathVariable Long id){
        return ResponseEntity.ok( adminService.getRoleRequest(id));
    }

    @GetMapping
    public ResponseEntity<List<RoleRequest>>  getRoleRequests(){
        return ResponseEntity.ok(adminService.getRoleRequests());
    }
}
