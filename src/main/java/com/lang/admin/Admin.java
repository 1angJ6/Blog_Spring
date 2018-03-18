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

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
