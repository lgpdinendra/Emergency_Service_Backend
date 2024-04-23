package com.example.emergency.Controller;

import com.example.emergency.Model.LoginDTO;
import com.example.emergency.Model.ServiceUser;
import com.example.emergency.Service.ServiceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/service")
public class ServiceUserController {

    @Autowired
    private ServiceUserService serviceUserService;

    @GetMapping
    public List<ServiceUser> getAllUsers(){
        return serviceUserService.getAllServiceUsers();
    }

    @GetMapping("/by-service-type/{serviceType}")
    public List<ServiceUser> getUsersByServiceType(@PathVariable String serviceType) {
        return serviceUserService.getServiceUsersByServiceType(serviceType);
    }

    @GetMapping("/{email}")
    public ServiceUser getUserEmail(@PathVariable String email){
        return serviceUserService.getUserByEmail(email);
    }

    @PostMapping("/register")
    public ServiceUser addUser(@RequestBody ServiceUser user){
        return serviceUserService.addUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        return serviceUserService.login(loginDTO);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteTask(@PathVariable String email) {
        boolean isDeleted = serviceUserService.deleteTask(email);

        if (isDeleted) {
            return ResponseEntity.ok( email + " has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/approve/{email}")
    public ServiceUser approveUser(@RequestBody ServiceUser user) {
        return serviceUserService.approveUserByEmail(user);
    }

    @GetMapping("/Usercount")
    public long getUserCount(){
        return serviceUserService.getUserCount();
    }

    @PutMapping("{email}")
    public ServiceUser updateUser(@RequestBody ServiceUser user){
        return serviceUserService.updateUser(user);
    }

}
