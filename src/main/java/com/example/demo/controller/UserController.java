package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.base.BaseController;
import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.UserListDTO;
import com.example.demo.dto.UserListSearchDTO;
import com.example.demo.enums.RoleEnum;
import com.example.demo.param.CreateUserParam;
import com.example.demo.param.UserListSearchParam;
import com.example.demo.services.UserService;
import com.example.demo.utility.BeanCopierUtils;
import com.example.demo.utility.ResponseMsg;
import com.example.demo.vo.UserListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    @PostMapping(value = "/list-user")
    public ResponseMsg listUser(@RequestBody @Valid UserListSearchParam param){
        //TODO 待分页
        UserListSearchDTO searchDTO = new UserListSearchDTO();
        BeanCopierUtils.copy(param,searchDTO);
        List<UserListDTO> dtoList = userService.listUser(searchDTO);
        if(CollectionUtils.isEmpty(dtoList)){
            return success();
        }
        //DTO转VO
        List<UserListVO> voList = dtoList.stream().map(v->{
            UserListVO vo = new UserListVO();
            BeanCopierUtils.copy(v, vo);
            vo.setRole(RoleEnum.getDescByCode(v.getRole()));
            vo.setAddressName(v.getAddressDTO().getAddressName());
            vo.setAddress(v.getAddressDTO().getAddress());
            return vo;
        }).collect(Collectors.toList());
        return success(voList);
    }

    @ApiOperation(value = "创建用户")
    @PostMapping(value = "/create")
    public ResponseMsg save(@RequestBody @Valid CreateUserParam param){
        CreateUserDTO dto = JSON.parseObject(JSON.toJSONString(param),CreateUserDTO.class);
        userService.save(dto);
        return success();
    }
}
