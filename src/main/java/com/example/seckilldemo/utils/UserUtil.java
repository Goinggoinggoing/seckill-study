package com.example.seckilldemo.utils;

import com.example.seckilldemo.entity.TUser;
import com.example.seckilldemo.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成用户工具类
 *
 * @author: LC
 * @date 2022/3/4 3:29 下午
 * @ClassName: UserUtil
 */
public class UserUtil {

    @Autowired
    ITUserService tUserService;

    public void CreateUser() throws IOException {
        List<TUser> list = new ArrayList<>();
//        生成用户
        for (int i = 0; i < 100; i++) {
            TUser tUser = new TUser();
            tUser.setId(1233L + i);
            tUser.setNickname("user" + i);
            tUser.setSalt("1a2b3c");
            tUser.setPassword("6e0a7fe692684372437c9e508508990d");
            list.add(tUser);
        }
        tUserService.saveBatch(list);
    }


}
