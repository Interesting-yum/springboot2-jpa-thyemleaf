package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserListSearchDTO;
import com.example.demo.entity.User;
import com.example.demo.param.UserListSearchParam;
import com.example.demo.services.UserService;
import com.example.demo.utility.BeanCopierUtils;
import com.example.demo.utility.ResponseMsg;
import com.example.demo.utility.ResponseMsgTable;
import com.example.demo.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author djs
 * @time 2019/3/25 15:51
 * @description 用户控制器
 */
@RestController
@Api(tags = "用户控制器")
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    public UserService userService;

    @ApiOperation(value = "用户列表",responseContainer = "list",response = UserVO.class)
    @PostMapping(value = "/listUser")
    public ResponseMsgTable get(@RequestBody @Valid UserListSearchParam param){
        UserListSearchDTO searchDTO = new UserListSearchDTO();
        BeanCopierUtils.copy(param,searchDTO);

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

    @ApiOperation(value = "根据id批量删除")
    @PostMapping(value = "/del")
    public ResponseMsg del(@RequestParam(value = "id[]") List<Long> id){
        return userService.del(id);
    }
}
