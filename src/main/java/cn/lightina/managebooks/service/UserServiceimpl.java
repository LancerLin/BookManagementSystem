package cn.lightina.managebooks.service;

import cn.lightina.managebooks.dao.UserMapper;
import cn.lightina.managebooks.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public User checkUser(User user) {
        return userMapper.checkUser(user);
    }

    @Override
    public User checkManager(User user) {
        return userMapper.checkManager(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
        //return userMapper.addUser(user);
    }

    @Override
    public User findByName(String name) {
        User param = new User();
        param.setUserName(name);
        return userMapper.findOne(name);
    }
}
