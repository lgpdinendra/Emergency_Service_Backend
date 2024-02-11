package com.example.emergency.Service;

import com.example.emergency.Model.LoginDTO;
import com.example.emergency.Model.PublicUser;
import com.example.emergency.Repository.PublicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public  PublicUser addUser(PublicUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return publicUserRepository.save(user);
    }

    public boolean login(LoginDTO loginDTO){
        PublicUser user = publicUserRepository.findPublicUserByEmail(loginDTO.getEmail());
        boolean a = passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());
        return user != null && a;
    }
}
