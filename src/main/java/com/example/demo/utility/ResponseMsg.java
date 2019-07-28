package com.example.demo.utility;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * @author djs
 * @time 2019/4/2 17:26
 * @description 用来提供返回值得工具类
 */
@Data
@ApiModel(value = "通用返回值工具")
public class ResponseMsg {
    @ApiModelProperty(value = "返回状态,SUCCESS？ERROR")
    private String status;
    @ApiModelProperty(value = "错误代码")
    private String errorCode;
    @ApiModelProperty(value = "错误消息")
    private String errorMsg;
    @ApiModelProperty(value = "返回内容")
    private Object content;

    public enum Status {
        SUCCESS,
        ERROR
    }

    public ResponseMsg(){
        this.status = Status.SUCCESS.name();
    }

    public ResponseMsg(Object content){
        this.status = Status.SUCCESS.name();
        this.content = content;
    }

    public ResponseMsg(String errorCode,String errorMsg,Status status){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.status = status.name();
    }

    public static ResponseMsg error(String errorCode, String errorMsg){
        return new ResponseMsg(errorCode,errorMsg,Status.ERROR);
    }
}
