package com.eds.cloud.bussiness.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

/**
 * 正常限流都是在网关做限流和token验证
 * @author wxb
 * @version V1.0
 * @Package com.eds.cloud.bussiness.filter
 * @date 2020/4/8 14:27
 */
@Slf4j
@WebFilter(filterName = "tokenFilter", urlPatterns = "/apis/business/*")
public class RateLimitFilter implements Filter {
    //每秒发几个的令牌数量
    public static final int REQUEST_COUNT = 10;
    /*** set the number of requests per second */
    private static final RateLimiter rateLimiter = RateLimiter.create(REQUEST_COUNT);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!rateLimiter.tryAcquire()) {
            //如果限流成功就会返回504，请求超时
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendError(HttpServletResponse.SC_GATEWAY_TIMEOUT);
            log.error(">>>>>>>>>> 亲！接口限流,请稍后重试！");
            return;
        }
        log.info(">>>>>>>> 恭喜通过的限流接口！");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
