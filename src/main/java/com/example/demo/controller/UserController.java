package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.base.BaseController;
import com.example.demo.dto.CreateAddressDTO;
import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.UserListSearchDTO;
import com.example.demo.param.CreateUserParam;
import com.example.demo.param.UserListSearchParam;
import com.example.demo.services.UserService;
import com.example.demo.utility.BeanCopierUtils;
import com.example.demo.utility.ResponseMsg;
import com.example.demo.utility.ResponseMsgTable;
import com.example.demo.vo.UserListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户列表",responseContainer = "list",response = UserListVO.class)
    @PostMapping(value = "/listUser")
    public ResponseMsgTable get(@RequestBody @Valid UserListSearchParam param){
        UserListSearchDTO searchDTO = new UserListSearchDTO();
        BeanCopierUtils.copy(param,searchDTO);

        return userService.get();
    }

    @ApiOperation(value = "创建用户")
    @PostMapping(value = "/create")
    public ResponseMsg save(@RequestBody @Valid CreateUserParam param){
        CreateUserDTO dto = JSON.parseObject(JSON.toJSONString(param),CreateUserDTO.class);
        userService.save(dto);
        return success();
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping(value = "/del")
    public ResponseMsg del(@RequestParam(value = "id[]") List<Long> id){
        return userService.del(id);
    }
}
