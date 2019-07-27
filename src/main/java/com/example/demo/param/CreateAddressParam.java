package com.example.demo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author djs
 * @date 2019/7/27 17:09
 * @description TODO
 */
@Data
@ApiModel
public class CreateAddressParam {
    @ApiModelProperty(value = "省市区")
    private String addressName;

    @ApiModelProperty(value = "详细地址")
    private String address;
}
