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
 * @date 2019/7/27 16:50
 * @description TODO
 */
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue
    private Long id;
    private String account;
    private String province;
    private String city;
    private String county;
    private String addressName; //省市区中文
    private String address; //详细住址
}
