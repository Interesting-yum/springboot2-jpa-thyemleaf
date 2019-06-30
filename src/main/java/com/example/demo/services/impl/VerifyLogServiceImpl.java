package com.example.demo.services.impl;

import com.example.demo.entity.VerifyLog;
import com.example.demo.repository.VerifyLogRep;
import com.example.demo.services.VerifyLogService;
import com.example.demo.utility.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author djs
 * @version 1.0
 * @time 2019/6/28 0:59
 * @description 验证记录 业务实现
 */
@Service
public class VerifyLogServiceImpl implements VerifyLogService {
    @Autowired
    public VerifyLogRep verifyLogRep;

    @Override
    @Transactional
    public ResponseMsg save(Long userId, String email, String resetKey) {
        VerifyLog verifyLog=VerifyLog.builder().userId(userId).email(email).resetKey(resetKey).build();
        verifyLogRep.save(verifyLog);
        return null;
    }

    @Override
    public String getResetKeyById(Long userId) {
        VerifyLog verifyLog=verifyLogRep.findByIdIn(userId);
        return verifyLog.getResetKey();

    }
}
