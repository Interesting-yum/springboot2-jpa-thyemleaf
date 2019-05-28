package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.utility.ResponseMsg;
import com.example.demo.utility.ResponseMsgTable;

import java.util.List;

/**
 * @author djs
 * @time 2019/3/25 15:49
 * @description 用户逻辑
 */
public interface UserService {
    User getById(Long id);

    ResponseMsg save(String name, String password, Integer age,String account,String school,String birth,String root);

    ResponseMsgTable get();

    ResponseMsg del(List<Long> id);

    ResponseMsg s(User user);
}
