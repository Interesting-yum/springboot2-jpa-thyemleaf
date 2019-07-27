package com.example.demo.repository;

import com.example.demo.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * @author djs
 * @date 2019/7/27 17:32
 * @description TODO
 */
public interface AddressRep extends JpaRepository<UserAddress,Long> {
    List<UserAddress> findByAccountIn(Set<String> accounts);
}
