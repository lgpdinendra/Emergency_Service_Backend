package com.example.emergency.Controller;

import com.example.emergency.Model.LoginDTO;
import com.example.emergency.Model.PublicUser;
import com.example.emergency.Service.PublicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/user")
public class PublicUserController {

    @Autowired
    private PublicUserService publicUserService;

    @GetMapping
    public List<PublicUser> getAllUsers(){
        return publicUserService.getAllPublicUsers();
    }

    @GetMapping("/{email}")
    public PublicUser getUserEmail(@PathVariable String email){
        return publicUserService.getUserByEmail(email);
    }


    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody PublicUser user) {
        return publicUserService.addUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        return publicUserService.login(loginDTO);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteTask(@PathVariable String email) {
        boolean isDeleted = publicUserService.deleteTask(email);

        if (isDeleted) {
            return ResponseEntity.ok( email + " has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/approve/{email}")
    public PublicUser approveUser(@RequestBody PublicUser user) {
        return publicUserService.approveUserByEmail(user);
    }

    @GetMapping("/Usercount")
    public long getUserCount(){
        return publicUserService.getUserCount();
    }

    @PutMapping("{email}")
    public PublicUser updateUser(@RequestBody PublicUser user){
        return publicUserService.updateUser(user);
    }

}
