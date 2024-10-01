package com.example.servicecenter.entity;

import javax.persistence.*;

@Entity
public class CallMe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

    // Getters and setters
}
