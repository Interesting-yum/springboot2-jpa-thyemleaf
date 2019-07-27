package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author djs
 * @date 2019/7/27 15:30
 * @description TODO
 */
@Data
public class UserListDTO {
    private AddressDTO addressDTO;

    private String name;

    private Integer age;

    private String account;

    private Date birth;

    private Integer role;

    private String email;

    private String school;
}
