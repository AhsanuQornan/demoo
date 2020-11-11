package com.bismillah.demo.service;

import com.bismillah.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
    @Service


public class  UserDAOImp implements UserDAO{
    @Autowired
    private EntityManager em;

    public User getbyUsername(String username){
        List<User> listuser =(List<User>) em.createNativeQuery("SELECT *FROM user WHERE username= :username",User.class)
                .setParameter("username", username).getResultList();
        return listuser!=null && !listuser.isEmpty()? listuser.get(0) :null;
    }

}
