package com.project.questapp.controllers;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import com.project.questapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    //private UserRepository userRepository; repoya değil servise bağlanacağız

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService; //spring bootun getirdiği beani bizim repomuza atayacak.
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){ //gelen istekteki bodydeki bilgileri alıp bir User objesine maple ve bana o User objesini dön (newUser)
        return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){ //userId i pathvariable olarak almamız lazım
        //custom exception ekle
        return userService.getOneUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser){ //update edeceğimiz user'ı da almamız lazım reqbody
        return userService.updateOneUser(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }

}
