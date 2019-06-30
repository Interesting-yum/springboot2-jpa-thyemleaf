package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author djs
 * @version 1.0
 * @time 2019/6/28 0:35
 * @description 用户验证记录
 */
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user_verifyLog")
public class VerifyLog {
    //自增主键
    @Id
    @GeneratedValue
    private Long id;
    //用户id
    private Long userId;
    //用户邮箱
    private String email;
    //验证秘钥，确保安全，由UUID生成
    private String resetKey;
}
