package com.example.demo.controller;

import com.example.demo.services.VerifyLogService;
import com.example.demo.utility.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djs
 * @version 1.0
 * @time 2019/6/28 0:57
 * @description 用户验证记录控制器
 */
@RestController
@RequestMapping(value = "/verify")
public class VerifyLogController {
    @Autowired
    public VerifyLogService verifyLogService;

    /**
     * 插入
     * @param userId
     * @param email
     * @param resetKey
     */
    @PostMapping(value = "/save")
    public ResponseMsg verifySave(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "resetKey") String resetKey
    ){
        return verifyLogService.save(userId,email,resetKey);
    }
}
