package com.rusteye.jwtdemo;

import javax.persistence.*;

import lombok.ToString;

@Entity
@Table(name = "tb_user")
@ToString
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}