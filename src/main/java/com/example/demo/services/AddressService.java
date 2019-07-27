package com.example.demo.services;

import com.example.demo.entity.UserAddress;

import java.util.Map;
import java.util.Set;

/**
 * @author djs
 * @date 2019/7/27 17:33
 * @description 地址服务
 */
public interface AddressService {
    void createAddress(UserAddress address);

    Map<String, UserAddress> getAddressMap(Set<String> accounts);
}
