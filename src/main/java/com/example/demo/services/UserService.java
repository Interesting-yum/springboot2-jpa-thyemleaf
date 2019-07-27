package com.example.demo.services;

import com.example.demo.dto.CreateUserDTO;
import com.example.demo.entity.User;
import com.example.demo.utility.ResponseMsg;
import com.example.demo.utility.ResponseMsgTable;

import java.util.Date;
import java.util.List;

/**
 * @author djs
 * @time 2019/3/25 15:49
 * @description 用户逻辑
 */
public interface UserService {

    void save(CreateUserDTO createUserDTO);

}
