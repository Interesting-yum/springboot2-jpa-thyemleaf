package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

/**
 * @author djs
 * @time 2019/3/25 16:02
 * @description 用户jpa接口
 */
@Repository
public interface UserRep extends JpaRepository<User,Long> {

    User findOneById(Long id);
    List<User> findAll();

}
