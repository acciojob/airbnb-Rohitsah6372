package com.driver.Repo;

import com.driver.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepo {
    HashMap<Integer, User> userDB = new HashMap<>();


    public Integer addUser(User user) {

        if(userDB.containsKey(user.getaadharCardNo()))
            return -1;

        User savedUser = userDB.put(user.getaadharCardNo(), user);
        return savedUser.getaadharCardNo();
    }

    public User findUserByAdhaar(Integer aadharCard) {
        return userDB.get(aadharCard);
    }
}
