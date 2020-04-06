package com.eds.cloud.base.controller.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @package
 * @description
 * @create 2019-12-24 11:22
 **/
@RestController
public class HellowController {

    @RequestMapping(value = "/apis/base/hellos")
    @ResponseBody
    public Map callService() {
        Map map = new HashMap();
        map.put("aaa","aaa");
        return map;
    }
}
