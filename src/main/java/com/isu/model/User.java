package com.isu.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String pwdHash;

    private int role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public User(String name, String pwdHash, int role, Group group){
        this.name = name;
        this.pwdHash = pwdHash;
        this.role = role;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public int getRole() {
        return role;
    }

    public Group getGroup() {
        return group;
    }
}