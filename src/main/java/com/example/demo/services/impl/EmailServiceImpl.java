package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.EmailLog;
import com.example.demo.repository.EmailLogRep;
import com.example.demo.services.EmailService;
import com.example.demo.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.UUID;

/**
 * @author djs
 * @version 1.0
 * @time 2019/6/28 0:59
 * @description 验证记录 业务实现
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailLogRep emailLogRep;
    @Autowired
    private UserService userService;
    @Resource
    private JavaMailSender javaMailSender;

    @Override
    @Transactional
    public void save(Long userId, String email, String resetKey) {
        EmailLog emailLog = EmailLog.builder().userId(userId).email(email).resetKey(resetKey).build();
        emailLogRep.save(emailLog);
    }

    @Override
    public void sendEmail(Long userId, String toEmail, String fromEmail) {
        User user=userService.getById(userId);
        boolean isExist = user==null?false:true; //当前用户是否存在
        boolean emailExist=user.getEmail()==null?false:true;//邮箱是否正确
        if(!isExist || !emailExist){
            log.error("用户或邮箱不存在！");
            return;
        }
        //插入请求记录
        save(userId,toEmail, UUID.randomUUID().toString());
        //确定邮箱内容
        String verifyCode=UUID.randomUUID().toString();
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmail); //邮件发送方，我方邮箱地址
        simpleMailMessage.setTo(toEmail);  //邮件接收方，用户邮箱地址
        simpleMailMessage.setSubject("【知学友用户】密码重置");
        simpleMailMessage.setText("验证码："+verifyCode+";有效期为30m");
        //发送邮件
        javaMailSender.send(simpleMailMessage);
    }

}
