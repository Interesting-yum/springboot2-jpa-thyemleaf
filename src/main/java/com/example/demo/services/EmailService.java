package com.example.demo.services;

import com.example.demo.utility.ResponseMsg;

/**
 * @author djs
 * @version 1.0
 * @time 2019/6/28 0:59
 * @description 邮件服务
 */
public interface EmailService {
    /**
     * 保存发送邮箱记录
     * @param userId
     * @param email
     * @param resetKey
     */
    void save(Long userId, String email, String resetKey);

    /**
     *  发送邮件
     * @param userId  用户id
     * @param toEmail  /用户邮箱
     * @param fromEmail 我方邮箱
     */
    void sendEmail(Long userId, String toEmail, String fromEmail);
}
