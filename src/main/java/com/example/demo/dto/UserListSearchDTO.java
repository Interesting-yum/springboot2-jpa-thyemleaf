package com.example.demo.dto;

import lombok.Data;

/**
 * @author djs
 * @date 2019/7/27 15:38
 * @description TODO
 */
@Data
public class UserListSearchDTO {
    private String account;
    private Integer role;
    private String name;
    private Integer age;
}
