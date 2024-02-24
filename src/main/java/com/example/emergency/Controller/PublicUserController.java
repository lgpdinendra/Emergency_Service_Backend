package com.example.emergency.Controller;

import com.example.emergency.Model.LoginDTO;
import com.example.emergency.Model.PublicUser;
import com.example.emergency.Service.PublicUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PublicUser addUser(@RequestBody PublicUser user){
        return publicUserService.addUser(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDTO loginDTO){
        return publicUserService.login(loginDTO);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteTask(@PathVariable String email) {
        boolean isDeleted = publicUserService.deleteTask(email);

        if (isDeleted) {
            return ResponseEntity.ok( email + " has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{email}")
    public PublicUser updateUser(@RequestBody PublicUser user){
        return publicUserService.updateUser(user);
    }

}
