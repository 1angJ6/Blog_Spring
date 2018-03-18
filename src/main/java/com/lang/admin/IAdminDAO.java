package com.lang.admin;

import java.security.NoSuchAlgorithmException;

/**
 * Created by lang on 2018/3/17.
 */
public interface IAdminDAO {

    Boolean auth(Admin admin);
    void create(Admin admin) throws NoSuchAlgorithmException;

}
