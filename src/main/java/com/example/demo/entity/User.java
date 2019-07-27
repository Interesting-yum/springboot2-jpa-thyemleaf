package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author djs
 * @time 2019/3/25 15:38
 * @description 用户实体类
 */
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user")
public class User {
    //自增主键
    @Id
    @GeneratedValue
    private Long id;
    //姓名
    private String name;
    //密码
    private String password;
    //年龄
    private Integer age;
    //账号
    private String account;
    //出生日期
    private Date birth;
    //权限 0-用户/1-管理员/2-超级管理员
    private Integer role;
    //学校
    private String school;
    //邮箱
    private String email;
}
