package com.example.demo.repository;

import com.example.demo.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author djs
 * @date 2019/7/27 17:32
 * @description TODO
 */
public interface AddressRep extends JpaRepository<UserAddress,Long> {
}
