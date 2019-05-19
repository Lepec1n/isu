package com.isu.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    public static final String STUDENT = "STUDENT";
    public static final String MAGE = "MAGE";
    public static final String ADMIN = "ADMIN";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    private String name;
}