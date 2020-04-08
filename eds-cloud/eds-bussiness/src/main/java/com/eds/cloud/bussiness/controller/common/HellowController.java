package com.eds.cloud.bussiness.controller.common;

import com.eds.cloud.bussiness.core.feign.EdsBaseRemote;
import com.eds.cloud.bussiness.core.po.Result;
import com.eds.cloud.bussiness.core.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    EdsBaseRemote edsBaseRemote;

    @RequestMapping(value = "/apis/business/hellows" )
    @ResponseBody
    public Result callService(String id , String name) {
        return edsBaseRemote.baseHellow(id,name);
    }

    @RequestMapping(value = "/apis/business/user")
    @ResponseBody
    public Result callServiceUser(@RequestBody User user) {
        return edsBaseRemote.callServiceUser(user);
    }

}
