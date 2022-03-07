package com.example.seckilldemo;

import com.example.seckilldemo.controller.TUserController;
import com.example.seckilldemo.entity.TUser;
import com.example.seckilldemo.mapper.TUserMapper;
import com.example.seckilldemo.service.ITUserService;
import com.example.seckilldemo.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SeckillDemoApplicationTests {


    @Test
    void contextLoads() {
        System.out.println(MD5Util.inputPassToFromPass("123456"));
    }

    @Test
    void aa() {
        List<String> a = Arrays.asList("1", "2", "3");
        for (String s : a) {
            System.out.println(s);
            if (s.equals("2")) {
                break;
            }
            System.out.println(s + "aaa");
        }
        System.out.println("=================");
        a.forEach(s -> {
            System.out.println(s);
            if (s.equals("2")) {
                return;
            }
            System.out.println(s + "aaa");
        });
    }

    @Test
    void createUser() {
        //插入数据库

    }

}
