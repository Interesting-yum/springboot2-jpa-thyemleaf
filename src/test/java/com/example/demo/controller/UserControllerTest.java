package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.BaseTest;
import com.example.demo.param.UserListSearchParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author djs
 * @date 2019/7/28 14:56
 * @description 用户控制器单元测试
 */
@Slf4j
public class UserControllerTest extends BaseTest {

    @Test
    public void listUser() throws Exception{
        //构造查询条件对象
        UserListSearchParam param = new UserListSearchParam();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/list-user")
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(param))).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        log.info(content);
    }
}
