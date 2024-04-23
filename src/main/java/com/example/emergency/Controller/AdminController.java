package com.example.emergency.Controller;

import com.example.emergency.Model.Admin;
import com.example.emergency.Model.LoginDTO;
import com.example.emergency.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAllUsers(){
        return adminService.getAllAdmin();
    }

    @GetMapping("/{email}")
    public Admin getUserEmail(@PathVariable String email){
        return adminService.getUserByEmail(email);
    }


    @PostMapping("/register")
    public Admin addUser(@RequestBody Admin user){
        return adminService.addUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        return adminService.login(loginDTO);
    }

    @PutMapping("{email}")
    public Admin updateUser(@RequestBody Admin user){
        return adminService.updateUser(user);
    }
}
