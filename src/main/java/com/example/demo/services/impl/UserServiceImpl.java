package com.example.demo.services.impl;

import com.example.demo.dto.CreateUserDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAddress;
import com.example.demo.repository.UserRep;
import com.example.demo.services.AddressService;
import com.example.demo.services.UserService;
import com.example.demo.utility.ResponseMsg;
import com.example.demo.utility.ResponseMsgTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author djs
 * @time 2019/3/25 15:49
 * @description 用户逻辑实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRep userRep;
    @Autowired
    private AddressService addressService;

    @Override
    @Transactional
    public void save(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setName(createUserDTO.getName());
        user.setPassword(createUserDTO.getPassword());
        user.setAge(createUserDTO.getAge());
        user.setAccount(createUserDTO.getAccount());
        user.setBirth(createUserDTO.getBirth());
        user.setSchool(createUserDTO.getSchool());
        user.setEmail(createUserDTO.getEmail());
        user.setRole(createUserDTO.getRole());
        userRep.save(user);
        //保存地址信息
        UserAddress address = new UserAddress();
        address.setProvince(createUserDTO.getCreateAddressDTO().getProvince());
        address.setCity(createUserDTO.getCreateAddressDTO().getCity());
        address.setCounty(createUserDTO.getCreateAddressDTO().getCounty());
        address.setAddressName(createUserDTO.getCreateAddressDTO().getProvince()+createUserDTO.
                getCreateAddressDTO().getCity()+createUserDTO.getCreateAddressDTO().getCounty());
        address.setAddress(createUserDTO.getCreateAddressDTO().getAddress());
        addressService.createAddress(address);
    }

}
