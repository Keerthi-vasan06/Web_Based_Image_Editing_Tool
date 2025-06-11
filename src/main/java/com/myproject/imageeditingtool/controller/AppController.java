package com.myproject.imageeditingtool.controller;

import com.myproject.imageeditingtool.entity.Tag;
import com.myproject.imageeditingtool.entity.User;
import com.myproject.imageeditingtool.entity.Image;
import com.myproject.imageeditingtool.service.ProfileService;
import com.myproject.imageeditingtool.service.TagService;
import com.myproject.imageeditingtool.service.UserService;
import com.myproject.imageeditingtool.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api") // Base URL for all APIs
public class

AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ProfileService profileService;


    @Autowired
    private TagService tagService;

    // -------------------- User Management APIs --------------------

    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/users{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }



    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }

    // -------------------- Image Management APIs --------------------

    @GetMapping("/images")
    public List<Image> getAllImages()
    {
        return imageService.getAllImages();
    }

    @GetMapping("/images/{id}")
    public Optional<Image> getImageById(@PathVariable Long id)
    {
        return imageService.getImageById(id);
    }

    @GetMapping("/images/user/{userId}")
    public List<Image> getImagesByUserId(@PathVariable Long userId)
    {
        return imageService.getImagesByUserId(userId);
    }

    @PostMapping("/uploadimages")
    public Image uploadImage(@RequestBody Image image) {
        System.out.println("Received Image: " + image);
        return imageService.uploadImage(image);
    }



    @DeleteMapping("/images/{id}")
    public void deleteImage(@PathVariable Long id)
    {
        imageService.deleteImage(id);
    }



    // -------------------- Tag Management APIs --------------------
    @GetMapping("/tags")
    public List<Tag> getAllTags()
    {
        return tagService.getAllTags();
    }


    @PostMapping("/tags")
    public Tag createTag(@RequestBody Tag tag)
    {
        return tagService.createTag(tag);
    }




}




// -------------------- RELATIONSHIPS IMPLEMENTED IN THIS PROJECT --------------------

// 1. One-to-One (1:1) Relationship:
//    - A User has a Profile (if a Profile entity is introduced).
//    - Implemented using @OneToOne in User and Profile entities.

// 2. One-to-Many (1:N) Relationship:
//    - A User can upload multiple Images.
//    - Implemented using @OneToMany in User entity and @ManyToOne in Image entity.

// 3. Many-to-One (N:1) Relationship:
//    - Each Image belongs to a single User.
//    - Implemented using @ManyToOne in Image entity with a reference to User.

// 4. Many-to-Many (M:N) Relationship:
//    - Images can have multiple Tags, and a Tag can be associated with multiple Images.
//    - Implemented using @ManyToMany in Image and Tag entities with a join table.

// These relationships ensure structured and efficient data management
// in the web-based image editing tool.
