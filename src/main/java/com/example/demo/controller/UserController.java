package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import com.example.demo.utility.ResponseMsg;
import com.example.demo.utility.ResponseMsgTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author djs
 * @time 2019/3/25 15:51
 * @description 用户控制器
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    public UserService userService;

    /**
     * 获取
     */
    @GetMapping(value = "/get")
    public ResponseMsgTable get(
    ){
        return userService.get();
    }
    /**
     * 存储
     * @param name  姓名
     * @param password  密码
     * @param age 年龄
     */
    @PostMapping(value = "/save")
    public ResponseMsg save(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "age") Integer age,
            @RequestParam(value = "account") String account,
            @RequestParam(value = "school") String school,
            @RequestParam(value = "birth") String birth,
            @RequestParam(value = "root",required = false,defaultValue = "普通用户") String root
    ){
        return userService.save(name,password,age,account,school,birth,root);
    }

    @RequestMapping(value = "/s",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseMsg s(
            @RequestBody User user
    ){
        return userService.s(user);
    }

    /**
     * 删除
     * @param id id标识数组
     */
    @PostMapping(value = "/del")
    public ResponseMsg del(
            @RequestParam(value = "id[]") List<Long> id
    ){
        return userService.del(id);
    }
    /**
     * 根据id获取
     * @param id 主键
     */
    @GetMapping(value = "/get_by_id")
    public User getById(
            @RequestParam(value = "id",defaultValue = "12",required = false) Long id
    ){
        return userService.getById(id);
    }
}
