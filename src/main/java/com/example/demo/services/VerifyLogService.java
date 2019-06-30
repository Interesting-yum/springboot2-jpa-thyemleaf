package com.example.demo.services;

import com.example.demo.utility.ResponseMsg;

/**
 * @author djs
 * @version 1.0
 * @time 2019/6/28 0:59
 * @description 用户验证记录 业务接口
 */
public interface VerifyLogService {
    ResponseMsg save(Long userId, String email, String resetKey);

    String getResetKeyById(Long userId);
}
