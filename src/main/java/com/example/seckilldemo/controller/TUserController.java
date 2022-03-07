package com.example.seckilldemo.controller;

import com.example.seckilldemo.entity.TUser;
import com.example.seckilldemo.service.ITUserService;
import com.example.seckilldemo.utils.MD5Util;
import com.example.seckilldemo.vo.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author LiChao
 * @since 2022-03-02
 */
@RestController
@RequestMapping("/user")
public class TUserController {


    @Autowired
    private ITUserService tUserService;

    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(TUser user) {
        return RespBean.success(user);
    }

    @GetMapping("/createuser")
    public void CreateUser() throws IOException {
        List<TUser> list = new ArrayList<>();
        //生成用户
//        for (int i = 0; i < 100; i++) {
//            TUser tUser = new TUser();
//            tUser.setId(1233L + i);
//            tUser.setNickname("user" + i);
//            tUser.setSalt("1a2b3c");
//            tUser.setPassword("05314c6fbe1d0cdb5eab4e80f1bda30a");
//            list.add(tUser);
//        }
//        tUserService.saveBatch(list);
//        System.out.println("create user");

        //读取用户
        list = tUserService.list();

        //登录，生成UserTicket
        String urlString = "http://localhost:8080/login/doLogin";
        File file = new File("/Users/lichao/Downloads/config.txt");
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(0);
        for (int i = 0; i < list.size(); i++) {
            TUser tUser = list.get(i);
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            String params = "mobile=" + tUser.getId() + "&password=c38dc3dcb8f0b43ac8ea6a70b5ec7648";
            outputStream.write(params.getBytes());
            outputStream.flush();
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buff)) >= 0) {
                byteArrayOutputStream.write(buff, 0, len);
            }
            inputStream.close();
            byteArrayOutputStream.close();
            String respone = new String(byteArrayOutputStream.toByteArray());
            ObjectMapper mapper = new ObjectMapper();
            RespBean respBean = mapper.readValue(respone, RespBean.class);
            String userTicket = (String) respBean.getObject();
            System.out.println("create userTicket:" + tUser.getId());
            String row = tUser.getId() + "," + userTicket;
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(row.getBytes());
            randomAccessFile.write("\r\n".getBytes());
            System.out.println("write to file :" + tUser.getId());
        }
        randomAccessFile.close();
        System.out.println();
    }
}
