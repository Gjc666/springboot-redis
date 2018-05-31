package com.mr.service;

import com.mr.model.User;

import java.util.List;

/**
 * Created by ${Gjc} on 2018/5/30.
 */
public interface UserService {
    List<User> userList();

    void userDel(Integer id);

    void addUser(User user);

    User findId(Integer id);

    void updateUser(User user);
}
