package com.eds.cloud.base.core.po;

import lombok.Builder;
import lombok.Data;

/**
 * @author wxb
 * @version V1.0
 * @Package com.eds.cloud.base.core.po
 * @date 2020/4/8 10:19
 */
@Data
@Builder
public class User {
    private Integer userId;
    private String userName;
    private String passwd;
}
