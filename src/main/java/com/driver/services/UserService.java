package com.driver.services;

import com.driver.Repo.UserRepo;
import com.driver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Integer addUser(User user) {
        return userRepo.addUser(user);
    }
}
