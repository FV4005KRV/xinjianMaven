package com.it.service.impl;

import com.it.pojo.User;
import com.it.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private com.it.mapper.userMapper userMapper;

    @Override
    public Integer getcount() {
        System.out.println("1234568912345689");
        Integer count = userMapper.getCount();
        System.out.println("count="+count);
        return count;

    }

    @Override
    public List<User> getUserlist() {
        return userMapper.getUserList();
    }

    @Override
    public void saveUser(User user) {
        userMapper.myaUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void upate(User userById) {
        userMapper.updteUser(userById);
    }

    @Override
    public void delUser(Integer id) {
        userMapper.delUser(id);
    }

    @Override
    public void bant(List<User> list) {
        userMapper.bant(list);
    }
}
