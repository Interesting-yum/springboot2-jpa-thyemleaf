package com.example.demo.controller.base;

import com.example.demo.utility.ResponseMsg;


/**
 * @author djs
 * @date 2019/7/27 16:35
 * @description 基类控制器
 */
public class BaseController {
    protected ResponseMsg success(){
        return new ResponseMsg();
    }

    protected ResponseMsg success(Object content){
        return new ResponseMsg(content);
    }
}
