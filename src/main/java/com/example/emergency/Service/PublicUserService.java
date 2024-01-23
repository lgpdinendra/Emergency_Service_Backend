package com.example.emergency.Service;

import com.example.emergency.Model.PublicUser;
import com.example.emergency.Repository.PublicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PublicUserService {

    @Autowired
    public PublicUserRepository publicUserRepository;

    public PublicUser registeruser(PublicUser publicUser){
       // PublicUser.s(UUID.randomUUID().toString().split("-")[0]);
        return publicUserRepository.save(publicUser);
    }

}
