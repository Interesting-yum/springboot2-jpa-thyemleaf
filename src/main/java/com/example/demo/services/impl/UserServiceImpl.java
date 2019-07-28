package com.example.demo.services.impl;

import com.example.demo.dto.AddressDTO;
import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.UserListDTO;
import com.example.demo.dto.UserListSearchDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAddress;
import com.example.demo.repository.UserRep;
import com.example.demo.services.AddressService;
import com.example.demo.services.UserService;
import com.example.demo.utility.BeanCopierUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.MapUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public List<UserListDTO> listUser(UserListSearchDTO searchDTO) {
        //构造查询条件
        Specification<User> query = getQuery(searchDTO);
        List<User> userList = userRep.findAll(query);
        List<UserListDTO> dtoList = new ArrayList<>();
        if(CollectionUtils.isEmpty(userList)){
            return dtoList;
        }
        Set<String> accounts =userList.stream().map(data->data.getAccount()).collect(Collectors.toSet());
        //根据账号批量查询地址信息,建立账号与相应地址的映射
        Map<String,UserAddress> addressMap = addressService.getAddressMap(accounts);
        dtoList = userList.stream().map(d->{
            UserListDTO dto = new UserListDTO();
            BeanCopierUtils.copy(d,dto);
            AddressDTO addressDTO = new AddressDTO();
            if(!MapUtils.isEmpty(addressMap)){
                BeanCopierUtils.copy(addressMap.get(d.getAccount()),addressDTO);
            }
            dto.setAddressDTO(addressDTO);
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public User getById(Long userId) {
        return userRep.findOneById(userId);
    }

    private Specification<User> getQuery(UserListSearchDTO searchDTO){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(!StringUtils.isEmpty(searchDTO.getAccount())){ //根据账号精确查询
                    list.add(cb.equal(root.get("account").as(String.class),searchDTO.getAccount()));
                }
                if(!StringUtils.isEmpty(searchDTO.getName())){  //根据姓名模糊查询
                    list.add(cb.like(root.get("name").as(String.class),searchDTO.getName()+"%"));
                }
                if(!StringUtils.isEmpty(searchDTO.getRole())){
                    list.add(cb.equal(root.get("role").as(Integer.class),searchDTO.getRole()));
                }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        };
    }
}
