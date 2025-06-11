package com.myproject.imageeditingtool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "smtpdatatable")
@Data
public class SmtpEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "subject")
    private String subject;
    @Column(name = "content")
    private String content;
}
