package com.example.emergency.Controller;

import com.example.emergency.Model.PublicUser;
import com.example.emergency.Service.PublicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publicuser")
public class PublicUserController {

    @Autowired
    public PublicUserService publicUserService;

    @PostMapping("/register")
    public PublicUser createregister(@RequestBody PublicUser publicUser){

        return publicUserService.registeruser(publicUser);
    }

}
