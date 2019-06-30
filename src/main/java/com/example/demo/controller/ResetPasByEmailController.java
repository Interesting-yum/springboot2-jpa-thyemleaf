package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.services.ResetPasByEmailService;
import com.example.demo.services.UserService;
import com.example.demo.services.VerifyLogService;
import com.example.demo.utility.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author djs
 * @version 1.0
 * @time 2019/6/27 23:54
 * @description 通过发送邮件重置用户密码
 */
@RestController
@RequestMapping(value = "/resetPas")
public class ResetPasByEmailController {
    @Autowired
    public ResetPasByEmailService resetPasByEmailService;
    @Autowired
    public UserService userService;
    @Autowired
    public VerifyLogService verifyLogService;
    @Autowired
    public JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    public String from; //从配置文件中获取邮箱地址
    /**
     * 验证用户请求，请求通过后发送密码重置邮件
     * @param userId
     * @param email
     * @param request
     * @return
     */
    @PostMapping(value = "/sendEmail")
    public ResponseMsg sendEmail(
            @RequestParam(value = "userId",required = true) Long userId,
            @RequestParam(value = "email",required = true) String email,
            HttpServletRequest request
    ){
        User user=userService.getById(userId);
        boolean isExist=user==null?false:true; //当前用户是否存在
        boolean emailExist=user.getEmail()==null?false:true;//邮箱是否正确
        if(!isExist || !emailExist){
            return new ResponseMsg(1,"账号或邮箱错误");
        }
        //插入请求记录
        verifyLogService.save(userId,email, UUID.randomUUID().toString());
        //确定邮箱内容
        String verifyCode=UUID.randomUUID().toString();
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(from); //邮件发送方，我方邮箱地址
        simpleMailMessage.setTo(email);  //邮件接收方，用户邮箱地址
        simpleMailMessage.setSubject("【知学友用户】密码重置");
        simpleMailMessage.setText("验证码："+verifyCode+";有效期为30m");
        //发送邮件
        javaMailSender.send(simpleMailMessage);
        return new ResponseMsg(0,"成功");
    }

}
