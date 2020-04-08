package com.eds.cloud.bussiness.core.feign;

import com.eds.cloud.bussiness.core.config.FeignConfig;
import com.eds.cloud.bussiness.core.po.Result;
import com.eds.cloud.bussiness.core.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@FeignClient(name = "eds-base", configuration = FeignConfig.class,
        fallbackFactory = XsptBaseRemoteFactory.class
)
public interface EdsBaseRemote {

    @GetMapping(value = "/apis/base/hellows")
    Result baseHellow(@RequestParam(required = false) String id, @RequestParam(required = false) String name);

    @PostMapping(value = "/apis/base/user")
    Result callServiceUser(@RequestBody User user);
}
