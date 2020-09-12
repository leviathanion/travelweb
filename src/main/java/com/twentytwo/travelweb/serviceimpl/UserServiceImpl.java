package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.User;
import com.twentytwo.travelweb.mapper.UserMapper;
import com.twentytwo.travelweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer deleteUser(String user_id) {
        return userMapper.deleteUser(user_id);
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public User getUserById(String user_id) {
        return userMapper.getUserById(user_id);
    }

    @Override
    public Integer updateUserPrivilege(String user_id, Integer user_privilege) {
        return userMapper.updateUserPrivilege(user_id,user_privilege);
    }
}
