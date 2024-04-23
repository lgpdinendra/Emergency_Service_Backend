package com.example.emergency.Service;

import com.example.emergency.Model.LoginDTO;
import com.example.emergency.Model.PublicUser;
import com.example.emergency.Repository.PublicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicUserService {

    @Autowired
    private PublicUserRepository publicUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<PublicUser> getAllPublicUsers(){
        return publicUserRepository.findAll();
    }

    //TODO:Error
    public PublicUser getUser(String email){
        return publicUserRepository.getPublicUserByEmail(email);
    }

    public PublicUser getUserByEmail(String email){
        return publicUserRepository.findPublicUserByEmail(email);
    }

    public ResponseEntity<?> addUser(PublicUser user){
        if (publicUserRepository.findPublicUserByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        PublicUser savedUser = publicUserRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    public ResponseEntity<?> login(LoginDTO loginDTO){
        PublicUser user = publicUserRepository.findPublicUserByEmail(loginDTO.getEmail());
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
        if (publicUserRepository.existsByEmail(email)) {
            publicUserRepository.deleteByEmail(email);
            return true;
        }
        return false;
    }

    public PublicUser updateUser(PublicUser userRequest){
        PublicUser existingUser = publicUserRepository.findPublicUserByEmail(userRequest.getEmail());
        existingUser.setPublicName(userRequest.getPublicName());
        existingUser.setEmail(userRequest.getEmail());
        return publicUserRepository.save(existingUser);
    }

    public PublicUser approveUserByEmail(PublicUser userRequest) {
        PublicUser user = publicUserRepository.findPublicUserByEmail(userRequest.getEmail());
        if (user != null) {
            user.setApproved(true);
            return publicUserRepository.save(user);
        } else {
            return null;
        }
    }


    public long getUserCount() {
        return publicUserRepository.count();
    }
}
