package com.myproject.imageeditingtool.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String profilePictureUrl;

    @OneToOne(mappedBy = "profile")
    @JsonBackReference("user-proflie")
    private User user;
}
