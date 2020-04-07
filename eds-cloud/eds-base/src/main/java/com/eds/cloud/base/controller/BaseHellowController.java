package com.eds.cloud.base.controller;

import com.eds.cloud.base.core.po.Result;
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

//
    @RequestMapping(value = "/apis/base/hellows",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result callService() {
        Map map = new HashMap();
        map.put("aaa","aaa");
        return Result.success(map);
    }
}
