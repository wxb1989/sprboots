package com.eds.cloud.base.controller;

import com.eds.cloud.base.core.po.Result;
import com.eds.cloud.base.core.po.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @package
 * @description
 * @create 2019-12-24 11:22
 **/
@RestController
public class BaseHellowController {

    /**
    防止使用restTemplate的方式进行调用时出现接收端接收到的是xml的问题
    所以要配置produces = MediaType.APPLICATION_JSON_VALUE*/
    @RequestMapping(value = "/apis/base/hellows", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result callService(@RequestParam(required = false) String id, @RequestParam(required = false) String name) {
        Map map = new HashMap();
        map.put("aaa", "aaa");
        return Result.success(map);
    }

    @RequestMapping(value = "/apis/base/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result callService2(@RequestBody User user) {
        Map map = new HashMap();
        map.put("user", user);
        return Result.success(map);
    }
}
