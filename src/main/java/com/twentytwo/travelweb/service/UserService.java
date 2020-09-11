package com.twentytwo.travelweb.service;

import com.twentytwo.travelweb.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    Integer addUser(User user);
    Integer deleteUser(Integer user_id);
    Integer updateUserById(User user);
    User getUserById(Integer user_id);
    Integer updateUserPrivilege(Integer user_id,Integer user_privilege);
}
