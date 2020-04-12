package com.njuiot.iotcloud.service;



import com.njuiot.iotcloud.mapper.UserMapper;
import com.njuiot.iotcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(String userName) {
        return userMapper.Sel(userName);
    }
}
