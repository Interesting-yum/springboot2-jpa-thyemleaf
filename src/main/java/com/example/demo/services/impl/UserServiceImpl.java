package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.utility.ResponseMsg;
import com.example.demo.utility.ResponseMsgTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author djs
 * @time 2019/3/25 15:49
 * @description 用户逻辑实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Override
    @Transactional
    public ResponseMsg save(String name, String password, Integer age,String account,String school,String birth,String root) {
        User user=User.builder().name(name).password(password).age(age).account(account).school(school).birth(birth).root(root).build();
        userRepository.save(user);
        ResponseMsg responseMsg=new ResponseMsg(0,"成功");
        return responseMsg;
    }

    @Override
    @Transactional
    public ResponseMsgTable get() {
        List<User> userList=userRepository.findAll();
        return new ResponseMsgTable(0,"成功",userList);
    }

    @Override
    public ResponseMsg del(List<Long> id) {
        for(int i=0;i<id.size();i++){
            userRepository.deleteById(id.get(i));
        }
        return new ResponseMsg(0,"成功");
    }

    @Override
    public ResponseMsg s(User user) {
        userRepository.save(user);
        return new ResponseMsg(0,"成功");
    }

    @Override
    public User getById(Long id) {
        User user=userRepository.findOneById(id);
        return user;
    }
}
