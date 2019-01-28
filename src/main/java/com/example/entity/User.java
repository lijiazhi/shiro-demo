package com.example.entity;

import java.util.List;

/**
 * @description: TODO
 * @author: li_jiazhi
 * @create: 2019-01-17 17:36
 **/
public class User {
    private int id;
    private String username;
    private String password;
    private String salt= "lijiazhi";

    //用户的角色   一对多关系
    private List<Role> roleList;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}