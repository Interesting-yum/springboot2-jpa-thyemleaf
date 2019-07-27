package com.example.demo.services.impl;

import com.example.demo.entity.UserAddress;
import com.example.demo.repository.AddressRep;
import com.example.demo.services.AddressService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

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

    @Override
    public Map<String, UserAddress> getAddressMap(Set<String> accounts) {
        List<UserAddress> addressList = addressRep.findByAccountIn(accounts);
        return addressList.stream().filter(e-> Strings.isNotBlank(e.getAccount())).collect(toMap(e->e.getAccount(), Function.identity(),(e1, e2)->e1));
    }
}
