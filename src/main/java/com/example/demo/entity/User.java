package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
@Table(name = "new_user")
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
    private String birth;
    //权限
    private String root;
    //学校
    private String school;
}
