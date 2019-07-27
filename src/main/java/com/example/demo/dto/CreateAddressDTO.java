package com.example.demo.dto;

import lombok.Data;

/**
 * @author djs
 * @date 2019/7/27 17:12
 * @description TODO
 */
@Data
public class CreateAddressDTO {
    private String province;
    private String city;
    private String county;
    private String address;
}
