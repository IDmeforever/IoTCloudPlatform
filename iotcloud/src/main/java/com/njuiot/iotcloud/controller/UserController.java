package com.njuiot.iotcloud.controller;


import com.njuiot.iotcloud.service.UserService;
import com.njuiot.iotcloud.utils.AesEncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser/{userName}")
    public String GetUser(@PathVariable String userName) {
        return userService.Sel(userName).toString();
    }

    @RequestMapping("/api/login")
    public boolean getAuth(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "Encrypt", required = true) String Encrypt) throws Exception {
        System.out.println("Request: "+userName+", Encrypt: "+Encrypt);
        String KEY = "1234567890123456";
        String IV = "1234567890123456";

        String encryptPsw = AesEncryptUtil.encrypt(userService.Sel(userName).getPassWord(), KEY, IV);

        if(Encrypt.equals(encryptPsw)) {
            return true;
        } else {
            return false;
        }
    }
}
