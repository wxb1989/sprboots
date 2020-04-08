package com.eds.cloud.bussiness.core.feign;

import com.alibaba.fastjson.JSONObject;
import com.eds.cloud.bussiness.core.po.Result;
import com.eds.cloud.bussiness.core.po.User;
import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author
 * @package com.cxjky.xspt.common.FeignRemote
 * @description api项目服务熔断处理工厂
 * eate 2019-10-26 13:44
 **/
@Component
public class XsptBaseRemoteFactory implements FallbackFactory<EdsBaseRemote> {

    @Override
    public EdsBaseRemote create(Throwable throwable) {
        return new EdsBaseRemote() {
            @Override
            public Result baseHellow(String id , String name) {
                return Result.illagalRequest();
            }

            @Override
            public Result callServiceUser(User user) {
                return Result.illagalRequest();
            }
        };
    }
}
