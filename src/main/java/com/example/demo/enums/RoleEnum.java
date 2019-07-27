package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author djs
 * @date 2019/7/27 15:42
 * @description 用户角色枚举
 */
@Getter
@AllArgsConstructor
public enum  RoleEnum {
    /**
     * 用户角色枚举
     */
    ORDINARY_USER(0,"普通用户"),
    ADMIN(1,"管理员"),
    SUPER_ADMIN(2,"超级管理员");

    private Integer code;
    private String desc;
    public static String getDescByCode(Integer code){
        switch (code){
            case 0:
                return ORDINARY_USER.getDesc();
            case 1:
                return ADMIN.getDesc();
            case 2:
                return SUPER_ADMIN.getDesc();
            default:
                return "";
        }
    }
}
