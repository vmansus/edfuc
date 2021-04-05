package com.ljh.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ljh.pojo.User;
import com.ljh.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ClientInfoStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/json1")
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        User user=new User("李金浩",22,"男");
        String str=mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        User user1=new User("李金浩1",22,"男");
        User user2=new User("李金浩2",22,"男");
        User user3=new User("李金浩3",22,"男");
        User user4=new User("李金浩4",22,"男");
        List<User> users=new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        String str=mapper.writeValueAsString(users);
        return str;

    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //创建时间一个对象，java.util.Date
        Date date = new Date();
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);

        return str;
    }

    @RequestMapping("/json5")
    public String json5() throws JsonProcessingException {
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }

}
