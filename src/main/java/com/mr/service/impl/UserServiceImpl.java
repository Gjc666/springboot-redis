package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "userList" , key = "1")
    //注解代表从缓存中查询指定的key,如果有,从缓存中取,不再执行方法.如果没有则执行方法,并且将查询数据库中的数据和指定的key关联起来,
    public List<User> userList() {
        return userMapper.selectByExample(null);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional
    @CacheEvict(value = "userList" , allEntries = true)
    //放入到缓存中.而@CacheEvict则是从缓存中清除指定的key对应的数据
    public void userDel(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 增加
     */
    @Override
    @Transactional
    @CacheEvict(value = "userList" , allEntries = true)
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
    @CacheEvict(value = "userList" , allEntries = true)
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

}
