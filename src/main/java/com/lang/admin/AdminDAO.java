package com.lang.admin;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by lang on 2018/3/17.
 */

@Transactional
@Repository
public class AdminDAO implements IAdminDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Boolean auth(Admin admin) {
        String query = "FROM Admin as admin WHERE admin.user_name = ?1";
        List<Admin> list = manager.createQuery(query).setParameter(1, admin.getUsername()).getResultList();
        if (list.size() == 0) return false;

        Admin _admin = (Admin) list.get(0);
        String hash;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] inputByteArray = admin.getPassword().getBytes();
            byte[] bytesOfDigest = md.digest(inputByteArray);
            hash = DatatypeConverter.printHexBinary(bytesOfDigest).toLowerCase();

        } catch (NoSuchAlgorithmException e) {
            return false;
        }

        return hash.equals(_admin.getPassword());
    }
}
