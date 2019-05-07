package com.example.demo.utility;

/**
 * @author djs
 * @time 2019/4/2 17:26
 * @description 用来提供返回值得工具类
 */

/**
 * code==0?操作成功 ==1 操作失败
 * msg 自定义返回的语句信息
 * count 用于查询时返回查询到的数量
 */
public class ResponseMsg {
    public Integer code;
    public String msg;

    public ResponseMsg(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
