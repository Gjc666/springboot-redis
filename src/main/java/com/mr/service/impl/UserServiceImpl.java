package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ${Gjc} on 2018/5/30.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询
     * @return
     */
    @Override
    public List<User> userList() {
        return userMapper.selectByExample(null);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional
    public void userDel(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 增加
     */
    @Override
    @Transactional
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    /**
     * 修改
     * @param id
     * @return
     */
    @Override
    public User findId(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

}
