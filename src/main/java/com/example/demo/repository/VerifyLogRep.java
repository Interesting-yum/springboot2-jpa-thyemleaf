package com.example.demo.repository;

import com.example.demo.entity.VerifyLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author djs
 * @version 1.0
 * @time 2019/6/28 1:04
 * @description 验证记录，POJO
 */
public interface VerifyLogRep extends JpaRepository<VerifyLog,Long> {
    VerifyLog findByIdIn(Long userId);
}
