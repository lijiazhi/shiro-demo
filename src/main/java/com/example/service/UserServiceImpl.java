package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @author: li_jiazhi
 * @create: 2019-01-17 17:43
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public Integer save(User user) {
        //算法，密码，盐值，迭代次数,十六进制。
//        SimpleHash password = new SimpleHash("md5",user.getPassword(), ByteSource.Util.bytes(user.getSalt()),2);
//        user.setPassword(String.valueOf(password));
        String password = new SimpleHash("md5",user.getPassword(), ByteSource.Util.bytes(user.getSalt()),2).toHex();
        user.setPassword(password);
        return userDao.insert(user);
    }
}
