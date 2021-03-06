package com.lang.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * Created by lang on 2018/3/17.
 */

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminDAO adminDAO;

    @Override
    public boolean auth(Admin admin) {
        return adminDAO.auth(admin);
    }

    @Override
    public void create(Admin admin) {
        try {
            adminDAO.create(admin);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
