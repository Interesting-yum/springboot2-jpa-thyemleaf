package com.example.demo.utility;

/**
 * @author djs
 * @version 1.0
 * @time 2019/4/5 15:29
 * @description 构造数据表格格式返回语句工具类
 */

import java.util.List;

/**
 * code 状态码：code==0？成功；==1?失败
 *  msg 消息
 *  count 数据个数
 *  data 返回的数据表格格式数据
 * **泛型
 */
public class ResponseMsgTable<T> {
    public Integer code;
    public String msg;
    public Integer count;
    public List<T> data;

    public ResponseMsgTable(Integer code,String msg,List<T> data){
        this.code=code;
        this.msg=msg;
        this.count=data.size();
        this.data=data;
    }
}
