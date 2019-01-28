package com.example.service;

import com.example.entity.User;

/**
 * @description: TODO
 * @author: li_jiazhi
 * @create: 2019-01-17 17:35
 **/
public interface IUserService {
    User findUserByName(String name);

    Integer save(User user);
}
