package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @description: TODO
 * @author: li_jiazhi
 * @create: 2019-01-22 14:26
 **/
@Repository
public interface UserMapper {
    public User findUserByName(String name);
    int deleteByPrimaryKey(Integer id);

    Integer insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
