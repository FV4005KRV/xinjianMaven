package com.it.mapper;

import com.it.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper {
    public Integer getCount();

    public List<User> getUserList();

    public void myaUser(User user);

    public User getUserById(Integer id);

    public void updteUser(User userById);

    public void delUser(Integer id);

    public void bant(List<User> list);
}
