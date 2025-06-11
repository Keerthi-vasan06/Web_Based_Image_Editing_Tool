package com.myproject.imageeditingtool.controller;


import com.myproject.imageeditingtool.entity.User;
import com.myproject.imageeditingtool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }


    @GetMapping("/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username)
    {
        return userService.getUserByUsername(username);
    }


    @PostMapping("/createuser")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @PutMapping("/resetpassword")
    public String resetPassword(@RequestParam int userid, String password)
    {
        return userService.resetPassword(Integer.toUnsignedLong(userid), password);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }


    @GetMapping("/pagination/")
    public List<User> pagination(@RequestParam int page, @RequestParam int size , @RequestParam String name)
    {
        return userService.getPaginatedEmployee(page, size, name);
    }


    @GetMapping("/startsWith/{prefix}")
    public List<User> getUsersByNameStartsWith(@PathVariable String prefix) {
        return userService.getUsersByNameStartsWith(prefix);
    }

    @GetMapping("/endsWith/{suffix}")
    public List<User> getUsersByNameEndsWith(@PathVariable String suffix) {
        return userService.getUsersByNameEndsWith(suffix);
    }

    // Find users whose name contains the given string
    @GetMapping("/contains")
    public List<User> getUsersContaining(@RequestParam String name) {
        return userService.getUsersByNameContains(name);
    }

    // Find users whose name exactly contains the given string (alternative)
    @GetMapping("/containing")
    public List<User> getUsersContainingAlternative(@RequestParam String name) {
        return userService.getUsersByNameContaining(name);
    }

    // Find users whose name does NOT contain the given string
    @GetMapping("/notcontaining")
    public List<User> getUsersNotContaining(@RequestParam String name) {
        return userService.getUsersByNameNotContaining(name);
    }


    @PostMapping("/email")
    public String generateEmail(@RequestParam String receiver, @RequestParam String subject, @RequestParam String content)
    {
        return userService.generateEmail(receiver,subject,content);
    }


}
