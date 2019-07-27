package com.example.demo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author djs
 * @date 2019/7/27 15:13
 * @description 查询用户列表条件入参
 */
@ApiModel(value = "用户查询条件入参")
@Data
public class UserListSearchParam {

    @ApiModelProperty(value = "用户账号")
    @NotNull(message = "用户账号不能为空")
    @Length(min = 1, max = 11, message = "长度不对")
    private String account;

    @ApiModelProperty(value = "用户角色",required = true)
    @NotNull(message = "角色不能为空")
    private Integer role;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;
}
