package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author djs
 * @date 2019/7/27 15:27
 * @description TODO
 */
@Data
@ApiModel
public class UserListVO {
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "生日")
    private Date birth;

    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "学校")
    private String school;

    @ApiModelProperty(value = "省市区")
    private String addressName;

    @ApiModelProperty(value = "详细地址")
    private String address;

}
