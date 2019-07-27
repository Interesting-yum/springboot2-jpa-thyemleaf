package com.example.demo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author djs
 * @date 2019/7/27 17:07
 * @description TODO
 */
@Data
@ApiModel(value = "创建用户入参")
public class CreateUserParam {
    @ApiModelProperty(value = "用户地址信息")
    private CreateAddressParam createAddressParam;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "生日")
    private Date birth;

    @ApiModelProperty(value = "角色")
    private Integer role;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "学校")
    private String school;
}
