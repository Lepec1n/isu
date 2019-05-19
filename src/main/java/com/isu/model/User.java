package com.isu.model;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotEmpty(message = "*Введите имя пользователя")
    private String username;

    @Length(min = 5, message = "*Пароль должен быть длиннее 5 символов")
    @NotEmpty(message = "*Пожалуйста, введите пароль")
    private String password;

    @NotEmpty(message = "*Пожалуйста, введите ваше имя")
    private String name;

    @NotEmpty(message = "*Пожалуйста, введите вашу фамилию")
    private String lastName;

    private int active;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;
}