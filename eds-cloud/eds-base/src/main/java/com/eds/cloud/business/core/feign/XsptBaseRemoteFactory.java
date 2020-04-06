package com.eds.cloud.business.core.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

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

        };
    }
}
