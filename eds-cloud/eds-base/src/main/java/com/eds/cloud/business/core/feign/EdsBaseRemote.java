package com.eds.cloud.business.core.feign;

import com.eds.cloud.business.core.config.FeignMultipartSupportConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "eds-business", configuration = FeignMultipartSupportConfiguration.class,
        fallbackFactory = XsptBaseRemoteFactory.class
)
public interface EdsBaseRemote {


}
