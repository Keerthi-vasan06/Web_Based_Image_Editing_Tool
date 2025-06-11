package com.myproject.imageeditingtool.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;


//     One-to-One relationship with Profile
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference("user-proflie")
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

//     One-to-Many relationship with Image
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("user-image")
    private List<Image> images;

}
