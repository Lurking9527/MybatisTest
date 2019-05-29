package com.nvr.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "v1", description = "这是逻辑控制层的版本v1")
@RequestMapping("/v1")
public class ControllerTest {
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "这是获取用户个数的接口",httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");
    }
    @RequestMapping(value = "/getUserList",method =RequestMethod.GET)
    @ApiOperation(value="这是获取用户列表信息的接口",httpMethod = "GET")
    public String getUserList(){
        return template.selectList("getUserList").toString();
    }
}
