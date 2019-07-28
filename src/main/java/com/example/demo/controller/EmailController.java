package com.example.demo.controller;

import com.example.demo.controller.base.BaseController;
import com.example.demo.services.EmailService;
import com.example.demo.utility.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author djs
 * @version 1.0
 * @time 2019/6/27 23:54
 * @description 邮件控制器
 */
@RestController
@RequestMapping(value = "/resetPas")
@Api(tags = "邮件控制器")
@Slf4j
public class EmailController extends BaseController {
    @Autowired
    private EmailService emailService;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @PostMapping(value = "/sendEmail")
    @ApiOperation(value = "发送邮件")
    public ResponseMsg sendEmail(
            @ApiParam(value = "用户id") @RequestParam(value = "userId" ) Long userId,
            @ApiParam(value = "用户邮箱") @RequestParam(value = "email" ) String toEmail
    ){
        emailService.sendEmail(userId,toEmail,fromEmail);
        return success();
    }

}
