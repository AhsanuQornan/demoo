package com.bismillah.demo.service;

import com.bismillah.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepositoy extends JpaRepository <User, String> {
    @Query("FROM User WHERE username =?1")
    User findbyusername(String username);



}
