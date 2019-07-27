package com.example.demo.services.impl;

import com.example.demo.entity.UserAddress;
import com.example.demo.repository.AddressRep;
import com.example.demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author djs
 * @date 2019/7/27 17:34
 * @description TODO
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    public AddressRep addressRep;

    @Override
    @Transactional
    public void createAddress(UserAddress address) {
        addressRep.save(address);
    }
}
