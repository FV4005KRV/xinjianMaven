package com.it.service;

import com.it.pojo.User;

import java.util.List;

public interface userService {
    public Integer getcount();
    public List<User> getUserlist();
    public void saveUser(User user);
    public User getUserById(Integer id);

    public void upate(User userById);

    public void delUser(Integer id);

    public void bant(List<User> list);

}
