package com.example.demo.services;

import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.UserListDTO;
import com.example.demo.dto.UserListSearchDTO;

import java.util.List;

/**
 * @author djs
 * @time 2019/3/25 15:49
 * @description 用户逻辑
 */
public interface UserService {

    void save(CreateUserDTO createUserDTO);

    List<UserListDTO> listUser(UserListSearchDTO searchDTO);
}
