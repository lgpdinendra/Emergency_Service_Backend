package com.example.emergency.Service;

import com.example.emergency.Model.LoginDTO;
import com.example.emergency.Model.PublicUser;
import com.example.emergency.Model.ServiceUser;
import com.example.emergency.Repository.ServiceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceUserService {

    @Autowired
    private ServiceUserRepository serviceUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<ServiceUser> getAllServiceUsers(){
        return serviceUserRepository.findAll();
    }

    public List<ServiceUser> getServiceUsersByServiceType(String serviceType) {
        return serviceUserRepository.findServiceUsersByServiceType(serviceType);
    }
    public ServiceUser getUserByEmail(String email){
        return serviceUserRepository.findServiceUserByEmail(email);
    }

    public  ServiceUser addUser(ServiceUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return serviceUserRepository.save(user);
    }

    public ResponseEntity<?> login(LoginDTO loginDTO){
        ServiceUser user = serviceUserRepository.findServiceUserByEmail(loginDTO.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
                if (user.isApproved()) {
                    return ResponseEntity.ok(user);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Registration is not approved");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid Password");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User does not exist");
    }

    public boolean deleteTask(String email){
        if (serviceUserRepository.existsByEmail(email)) {
            serviceUserRepository.deleteByEmail(email);
            return true;
        }
        return false;
    }

    public ServiceUser updateUser(ServiceUser userRequest){
        ServiceUser existingUser = serviceUserRepository.findServiceUserByEmail(userRequest.getEmail());
        existingUser.setServiceName(userRequest.getServiceName());
        existingUser.setEmail(userRequest.getEmail());
        return serviceUserRepository.save(existingUser);
    }

    public ServiceUser approveUserByEmail(ServiceUser serviceUserRequest) {
        ServiceUser user = serviceUserRepository.findServiceUserByEmail(serviceUserRequest.getEmail());
        if (user != null) {
            user.setApproved(true);
            return serviceUserRepository.save(user);
        } else {
            return null;
        }
    }
    public long getUserCount() {
        return serviceUserRepository.count();
    }
}

