package com.lang.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lang on 2018/3/17.
 */
@Entity
@Table(name = "admin")
public class Admin implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    int user_id;

    @Column(name = "user_name")
    String user_name;

    @Column(name = "password")
    String password;

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.user_name = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
