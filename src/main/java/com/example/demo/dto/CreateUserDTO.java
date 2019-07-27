package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author djs
 * @date 2019/7/27 17:11
 * @description TODO
 */
@Data
public class CreateUserDTO {
    private CreateAddressDTO createAddressDTO;

    private String name;

    private Integer age;

    private String password;

    private String account;

    private Date birth;

    private Integer role;

    private String email;

    private String school;
}
