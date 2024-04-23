package com.example.emergency.Service;

import com.example.emergency.Model.Admin;
import com.example.emergency.Model.LoginDTO;
import com.example.emergency.Model.PublicUser;
import com.example.emergency.Model.ServiceUser;
import com.example.emergency.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    public Admin getUserByEmail(String email){
        return adminRepository.findAdminByEmail(email);
    }

    public ResponseEntity<?> login(LoginDTO loginDTO){
        Admin user = adminRepository.findAdminByEmail(loginDTO.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid Password");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User does not exist");
    }

    public Admin updateUser(Admin userRequest){
        Admin existingUser = adminRepository.findAdminByEmail(userRequest.getEmail());
        existingUser.setPassword(userRequest.getPassword());
        return adminRepository.save(existingUser);
    }
    public  Admin addUser(Admin user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return adminRepository.save(user);
    }
}
